package cn.edu.sdu.jt808.service.handler.terminal;

import cn.edu.sdu.jt808.jtframework.codec.MessageDecoder;
import cn.edu.sdu.jt808.jtframework.codec.MessageEncoder;
import cn.edu.sdu.jt808.jtframework.mapping.Handler;
import cn.edu.sdu.jt808.jtframework.message.PackageData;
import cn.edu.sdu.jt808.mapping.JT808HandlerMapper;
import cn.edu.sdu.jt808.protocol.Header;
import cn.edu.sdu.jt808.protocol.Session;
import cn.edu.sdu.jt808.jtframework.server.manager.SessionManager;
import cn.edu.sdu.jt808.service.codec.JT808MessageDecoder;
import cn.edu.sdu.jt808.service.codec.JT808MessageEncoder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;


@Slf4j
@ChannelHandler.Sharable
public class TerminalHandler extends ChannelInboundHandlerAdapter {

    private MessageDecoder decoder = new JT808MessageDecoder();
    private MessageEncoder encoder = new JT808MessageEncoder();
    private SessionManager sessionManager = SessionManager.getInstance();
    private static JT808HandlerMapper handlerMapper = new JT808HandlerMapper("cn.edu.sdu.jt808.mapping");
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            // log.info("something in");
            ByteBuf byteBuf = (ByteBuf) msg;
            if (byteBuf.readableBytes() <= 0) return;

            int type = decoder.getMsgId(byteBuf);


            Handler handler = handlerMapper.getHandler(type);
            if (handler == null) {
                log.error("未知消息");
                return;
            }

            Class<?>[] types = handler.getTargetParameterTypes();
            Class<? extends PackageData> targetClass = (Class<? extends PackageData>) types[0];

            PackageData packageData = decoder.decode(byteBuf, Header.class, targetClass);


            PackageData<Header> result;
            if (types.length == 1) {
                result = handler.invoke(packageData);
            } else {
                result = handler.invoke(packageData, sessionManager.findBySessionId(ctx.channel().id().asLongText()));
            }

            // encode
            if (result == null) return;
            log.info("i {} {}", result.getHeader().getTerminalPhone(), type);
            ByteBuf resultBuf = encoder.encode(result);
            ByteBuf allResultBuf = Unpooled.wrappedBuffer(Unpooled.wrappedBuffer(new byte[]{ 0x7e }),
                    resultBuf, Unpooled.wrappedBuffer(new byte[]{ 0x7e }));
            ctx.writeAndFlush(allResultBuf.retain()).sync();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            if (e.state() == IdleState.READER_IDLE) {
                sessionManager.removeBySessionId(ctx.channel().id().asLongText());
                log.info("【终端超时断开】 " + ctx.channel());
                ctx.channel().close();
            }
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        Session session = Session.buildSession(ctx.channel());
        session.setLocalDateTime(LocalDateTime.now());
        sessionManager.put(session.getChannel().id().asLongText(), session);
        log.info("【终端连接】 " + ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        sessionManager.removeBySessionId(ctx.channel().id().asLongText());
        log.info("【终端断开】 " + ctx.channel());
        ctx.channel().close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable e) {
        log.error("【发生异常】 " + ctx.channel(), e);
    }
}

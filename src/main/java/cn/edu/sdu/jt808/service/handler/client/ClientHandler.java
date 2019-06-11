package cn.edu.sdu.jt808.service.handler.client;

import cn.edu.sdu.jt808.jtframework.codec.ProtoBufCodec;
import cn.edu.sdu.jt808.jtframework.manager.MessageManager;
import cn.edu.sdu.jt808.jtframework.message.PackageData;
import cn.edu.sdu.jt808.jtframework.message.SyncFuture;
import cn.edu.sdu.jt808.mapping.JT808DownMsgMapper;
import cn.edu.sdu.jt808.protobuf.ClientData;
import cn.edu.sdu.jt808.protobuf.ServerData;
import cn.edu.sdu.jt808.protocol.Header;
import cn.edu.sdu.jt808.protocol.Session;
import cn.edu.sdu.jt808.protocol.downMsg.NoBody;
import cn.edu.sdu.jt808.server.manager.SessionManager;
import cn.edu.sdu.jt808.service.codec.JT808MessageEncoder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import static cn.edu.sdu.jt808.commons.MessageId.*;

@Slf4j
@ChannelHandler.Sharable
public class ClientHandler extends SimpleChannelInboundHandler<ClientData.Protocol> {

    private JT808MessageEncoder encoder = new JT808MessageEncoder(Charset.forName("GBK"));
    private SessionManager sessionManager = SessionManager.getInstance();
    private static JT808DownMsgMapper downMessageMapper = new JT808DownMsgMapper("cn.edu.sdu.jt808.protocol.downMsg");

    @Override
    public void channelRead0(ChannelHandlerContext ctx, ClientData.Protocol protocol) throws Exception {
        int type = protocol.getProtoType();
        String terminalPhone = protocol.getTerminalPhone();
        int flowId = protocol.getFlowId();
        Session session = sessionManager.findByTerminalPhone(terminalPhone);
        if(session == null) {
            log.info("session is null");
            return;
        }

        Class<?> clazz = downMessageMapper.getDownMsg(type);
        PackageData<Header> packageData = NoBody.class.getDeclaredConstructor().newInstance();
        if (clazz != null) {
            String cName = clazz.getName().substring(clazz.getName().lastIndexOf('.') + 1);
            log.info("o {}", cName);
            Object pObject = protocol.getClass().getMethod("get" + cName).invoke(protocol);
            Object jObject = clazz.getDeclaredConstructor().newInstance();
            packageData = (PackageData<Header>) ProtoBufCodec.protoBeanToJavaBean(pObject, jObject);
        }
        boolean hasReplyFlowId = true;
        if (type == cmd_Identity_information_request || type == cmd_terminal_attribute_query
                || type == cmd_platform_RSA)
            hasReplyFlowId = false;
        Header header = new Header(type, sessionManager.currentFlowId(), terminalPhone);
        packageData.setHeader(header);

        ByteBuf buf = encoder.encode(packageData);

        ByteBuf allResultBuf = Unpooled.wrappedBuffer(Unpooled.wrappedBuffer(
                new byte[]{ 0x7e }), buf, Unpooled.wrappedBuffer(new byte[]{ 0x7e }));

        ChannelFuture channelFuture = session.getChannel().writeAndFlush(allResultBuf.retain()).sync();
        if (!channelFuture.isSuccess()) {
            log.info("message send failed");
            return;
        }
        String key = terminalPhone + (hasReplyFlowId ? header.getFlowId() : type);
        SyncFuture receive = MessageManager.INSTANCE.receive(key);

        try {
            Object object = receive.get(8, TimeUnit.SECONDS);
            if (object != null) {
                ServerData.Protocol.Builder pBuilder = (ServerData.Protocol.Builder) object;
                pBuilder.setFlowId(flowId);
                ctx.channel().writeAndFlush(Unpooled.wrappedBuffer(pBuilder.build().toByteArray())).sync();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            MessageManager.INSTANCE.remove(key);
        }

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.info("【 Client 终端连接 】 " + ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        log.info("【 Client 终端断开 】 " + ctx.channel());
        ctx.channel().close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable e) {
        log.error("【 Client 发生异常 】 " + ctx.channel(), e);
    }
}

package cn.edu.sdu.jt808.jtframework.server.initializer;

import cn.edu.sdu.jt808.service.handler.terminal.TerminalHandler;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class TerminalInitializer extends ChannelInitializer {
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast("idleStateHandler", new IdleStateHandler(300,
                0, 0, TimeUnit.SECONDS));
        pipeline.addLast("delimiter", new DelimiterBasedFrameDecoder(65535,
                Unpooled.wrappedBuffer(new byte[]{ 0x7e }),
                Unpooled.wrappedBuffer(new byte[]{ 0x7e }, new byte[]{ 0x7e })));

        pipeline.addLast("terminalHandler", new TerminalHandler());

    }
}

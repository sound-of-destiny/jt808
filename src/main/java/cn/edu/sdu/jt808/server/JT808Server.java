package cn.edu.sdu.jt808.server;

import cn.edu.sdu.jt808.server.initializer.BrowserInitializer;
import cn.edu.sdu.jt808.server.initializer.ClientInitializer;
import cn.edu.sdu.jt808.server.initializer.TerminalInitializer;
import cn.edu.sdu.jt808.utils.JT808Config;
import cn.edu.sdu.jt808.utils.MQUtil;
import cn.edu.sdu.jt808.utils.MongoUtil;
import cn.edu.sdu.jt808.utils.RedisUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class JT808Server {

    private final JT808Config conf;

    private int terminalPort;
    private int clientPort;
    private int testPort;

    private final EventLoopGroup bossGroup;
    private final EventLoopGroup terminalWorkerGroup;
    private final EventLoopGroup clientWorkerGroup;
    private final EventLoopGroup webSocketWorkerGroup;

    public JT808Server(JT808Config config) {
        this.conf = config;
        bossGroup = new EpollEventLoopGroup(3);
        terminalWorkerGroup = new EpollEventLoopGroup();
        clientWorkerGroup = new EpollEventLoopGroup();
        webSocketWorkerGroup = new EpollEventLoopGroup();
    }



    static JT808Config loadProperties(Path config) {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = Files.newInputStream(config)) {
            return yaml.loadAs(inputStream, JT808Config.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void bindTerminal() {
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, terminalWorkerGroup).channel(EpollServerSocketChannel.class)
                    .childHandler(new TerminalInitializer())
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture channelFuture = b.bind(terminalPort).sync();
            channelFuture.addListener(future -> {
                if (future.isSuccess()) {
                    log.info("---> JT808终端服务器启动成功, 端口号: " + terminalPort);
                } else {
                    log.info("---> JT808终端服务器启动失败");
                }
            });
        } catch (Exception e) {
            log.error("JT808终端服务器启动出错", e);
        }

    }

    private void bindBrowser() {
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, webSocketWorkerGroup).channel(EpollServerSocketChannel.class)
                    .childHandler(new BrowserInitializer())
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture channelFuture = b.bind(testPort).sync();
            channelFuture.addListener(future -> {
                if (future.isSuccess()) {
                    log.info("---> JT808WebSocket服务器启动成功, 端口号: " + testPort);
                } else {
                    log.info("---> JT808WebSocket服务器启动失败");
                }
            });
        } catch (Exception e) {
            log.error("JT808WebSocket服务器启动出错", e);
        }
    }

    private void bindClient() {
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, clientWorkerGroup).channel(EpollServerSocketChannel.class)
                    .childHandler(new ClientInitializer())
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture channelFuture = b.bind(clientPort).sync();
            channelFuture.addListener(future -> {
                if (future.isSuccess()) {
                    log.info("---> JT808Client服务器启动成功, 端口号: " + clientPort);
                } else {
                    log.info("---> JT808Client服务器启动失败");
                }
            });
        } catch (InterruptedException e) {
            log.error("JT808Web服务器启动出错", e);
        }
    }

    private final ExecutorService executorService = Executors.newFixedThreadPool(3);

    synchronized void startServer() {
        executorService.submit(this::bindTerminal);
        executorService.submit(this::bindBrowser);
        executorService.submit(this::bindClient);
    }

    JT808Server setup() {
        terminalPort = conf.getTerminalPort();
        clientPort = conf.getClientPort();
        testPort = conf.getTestPort();

        MQUtil.host = conf.getMqHost();
        MQUtil.virtualHost = conf.getMqVirtualHost();
        MQUtil.username = conf.getMqUsername();
        MQUtil.password = conf.getMqPassword();

        RedisUtil.REDIS_HOST = conf.getRedisHost();

        MongoUtil.mongoServer = conf.getMongoServer();
        MongoUtil.mongodb = conf.getMongodb();
        return this;
    }

    private synchronized void stopServer() {
        terminalWorkerGroup.shutdownGracefully();
        clientWorkerGroup.shutdownGracefully();
        webSocketWorkerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
        executorService.shutdown();
    }

}

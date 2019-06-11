package cn.edu.sdu.jt808.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class MQUtil {

    public static String host;
    public static String virtualHost;
    public static String username;
    public static String password;

    public final static String JT808Server_OriginData_Queue = "JT808Server_OriginData_Queue";

    public static ConnectionFactory getConnectionFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);
        factory.setVirtualHost(virtualHost);
        factory.setUsername(username);
        factory.setPassword(password);
        return factory;
    }

    public static Channel getChannel() {
        Channel channel = null;
        do {
            try {
                ConnectionFactory factory = getConnectionFactory();
                Connection connection = factory.newConnection();
                channel = connection.createChannel();
            } catch (Exception e) {
                try {
                    e.printStackTrace();
                    Thread.sleep(1000);
                    System.out.println("try to connect to rabbitMQ");
                } catch (InterruptedException ie) {
                    System.out.println("rabbitMQ Error");
                }
            }
        } while (channel == null);
        return channel;
    }

    /**
     * 写入rabbitmq queue
     */
    public static void toQueue(String QUEUE_NAME, byte[] bytes) {
        ConnectionFactory factory = getConnectionFactory();
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_BASIC, bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入rabbitmq fanout
     */
    public static void fanout(String EXCHANGE_NAME, byte[] bytes) {
        ConnectionFactory factory = getConnectionFactory();
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
            channel.basicPublish(EXCHANGE_NAME, "", null, bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入rabbitmq topic
     */
    public static void topic(String EXCHANGE_NAME, String routingKey, byte[] bytes) {
        ConnectionFactory factory = getConnectionFactory();
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");
            channel.basicPublish(EXCHANGE_NAME, routingKey,null, bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

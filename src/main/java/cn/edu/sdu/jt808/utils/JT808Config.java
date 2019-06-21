package cn.edu.sdu.jt808.utils;

public class JT808Config {
    private int terminalPort;
    private int clientPort;
    private int testPort;

    private String mqHost;
    private String mqVirtualHost;
    private String mqUsername;
    private String mqPassword;

    private String redisHost;
    private Integer redisPort;

    private String mongoServer;
    private String mongodb;


    public int getTerminalPort() {
        return terminalPort;
    }

    public void setTerminalPort(int terminalPort) {
        this.terminalPort = terminalPort;
    }

    public int getClientPort() {
        return clientPort;
    }

    public void setClientPort(int clientPort) {
        this.clientPort = clientPort;
    }

    public int getTestPort() {
        return testPort;
    }

    public void setTestPort(int testPort) {
        this.testPort = testPort;
    }

    public String getMqHost() {
        return mqHost;
    }

    public void setMqHost(String mqHost) {
        this.mqHost = mqHost;
    }

    public String getMqVirtualHost() {
        return mqVirtualHost;
    }

    public void setMqVirtualHost(String mqVirtualHost) {
        this.mqVirtualHost = mqVirtualHost;
    }

    public String getMqUsername() {
        return mqUsername;
    }

    public void setMqUsername(String mqUsername) {
        this.mqUsername = mqUsername;
    }

    public String getMqPassword() {
        return mqPassword;
    }

    public void setMqPassword(String mqPassword) {
        this.mqPassword = mqPassword;
    }

    public String getRedisHost() {
        return redisHost;
    }

    public void setRedisHost(String redisHost) {
        this.redisHost = redisHost;
    }

    public Integer getRedisPort() {
        return redisPort;
    }

    public void setRedisPort(Integer redisPort) {
        this.redisPort = redisPort;
    }

    public String getMongoServer() {
        return mongoServer;
    }

    public void setMongoServer(String mongoServer) {
        this.mongoServer = mongoServer;
    }

    public String getMongodb() {
        return mongodb;
    }

    public void setMongodb(String mongodb) {
        this.mongodb = mongodb;
    }
}

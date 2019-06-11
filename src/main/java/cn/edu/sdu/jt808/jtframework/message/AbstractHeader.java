package cn.edu.sdu.jt808.jtframework.message;

public abstract class AbstractHeader {
    /**
     * 消息类型
     */
    public abstract Integer getType();

    /**
     * 消息头长度
     */
    public abstract Integer getHeaderLength();

    /**
     * 消息体长度
     */
    public abstract Integer getMsgBodyLength();
    public abstract void setMsgBodyLength(Integer bodyLength);

}

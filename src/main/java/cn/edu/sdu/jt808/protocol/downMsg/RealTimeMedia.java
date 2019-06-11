package cn.edu.sdu.jt808.protocol.downMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;
import cn.edu.sdu.jt808.protocol.Header;

@MsgType(MessageId.cmd_real_time_media_transmission_request)
public class RealTimeMedia extends PackageData<Header> {
    private Integer hostAddressLength;
    private String hostAddress;
    private Integer videoPortTCP;
    private Integer videoPortUDP;
    private Integer logicalChannelId;
    private Integer dataType;
    private Integer codeType;


    @Property(index = 0, type = DataType.BYTE, desc = "服务器IP地址长度")
    public Integer getHostAddressLength() {
        return hostAddressLength;
    }

    public void setHostAddressLength(Integer hostAddressLength) {
        this.hostAddressLength = hostAddressLength;
    }

    @Property(index = 1, length = 15, type = DataType.STRING, desc = "服务器IP地址")
    public String getHostAddress() {
        return hostAddress;
    }

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    @Property(index = 16, type = DataType.WORD, desc = "服务器监听端口号TCP")
    public Integer getVideoPortTCP() {
        return videoPortTCP;
    }

    public void setVideoPortTCP(Integer videoPortTCP) {
        this.videoPortTCP = videoPortTCP;
    }

    @Property(index = 18, type = DataType.WORD, desc = "服务器监听端口号UDP")
    public Integer getVideoPortUDP() {
        return videoPortUDP;
    }

    public void setVideoPortUDP(Integer videoPortUDP) {
        this.videoPortUDP = videoPortUDP;
    }

    @Property(index = 20, type = DataType.BYTE, desc = "逻辑通道号")
    public Integer getLogicalChannelId() {
        return logicalChannelId;
    }

    public void setLogicalChannelId(Integer logicalChannelId) {
        this.logicalChannelId = logicalChannelId;
    }

    @Property(index = 21, type = DataType.BYTE, desc = "数据类型")
    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    @Property(index = 22, type = DataType.BYTE, desc = "码流类型")
    public Integer getCodeType() {
        return codeType;
    }

    public void setCodeType(Integer codeType) {
        this.codeType = codeType;
    }
}

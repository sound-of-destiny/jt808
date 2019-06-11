package cn.edu.sdu.jt808.protocol.downMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;
import cn.edu.sdu.jt808.protocol.Header;

@MsgType(MessageId.cmd_alarm_file_upload)
public class AlarmFileUpload extends PackageData<Header> {
    // 附件服务器 IP 地址长度
    private Integer hostLength;
    // 附件服务器 IP 地址
    private String host;
    // 附件服务器端口 (TCP)
    private Integer tcpPort;
    // 附件服务器端口 (UDP)
    private Integer udpPort;
    // 报警标识号
    private byte[] alarmFlag;
    // 报警编号
    private byte[] alarmCode;

    @Property(index = 0, type = DataType.BYTE)
    public Integer getHostLength() {
        return hostLength;
    }

    public void setHostLength(Integer hostLength) {
        this.hostLength = hostLength;
    }

    @Property(index = 1, type = DataType.STRING, length = 15)
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Property(index = 16, type = DataType.WORD)
    public Integer getTcpPort() {
        return tcpPort;
    }

    public void setTcpPort(Integer tcpPort) {
        this.tcpPort = tcpPort;
    }

    @Property(index = 17, type = DataType.WORD)
    public Integer getUdpPort() {
        return udpPort;
    }

    public void setUdpPort(Integer udpPort) {
        this.udpPort = udpPort;
    }

    @Property(index = 18, type = DataType.BYTES, length = 16)
    public byte[] getAlarmFlag() {
        return alarmFlag;
    }

    public void setAlarmFlag(byte[] alarmFlag) {
        this.alarmFlag = alarmFlag;
    }

    @Property(index = 34, type = DataType.BYTES, length = 32)
    public byte[] getAlarmCode() {
        return alarmCode;
    }

    public void setAlarmCode(byte[] alarmCode) {
        this.alarmCode = alarmCode;
    }
}

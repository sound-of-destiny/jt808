package cn.edu.sdu.jt808.protocol;

import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.AbstractHeader;

public class Header extends AbstractHeader {
    // 消息ID byte[0-1]
    private Integer type;

    // 消息体属性 byte[2-3]
    private Integer msgBodyProperties;

    // 终端手机号 byte[4-9]
    private String terminalPhone;

    // 流水号 byte[10-11]
    private Integer flowId;

    // 消息包总数(word(16bit))
    private Integer totalSubPackage;

    // 包序号(word(16bit))这次发送的这个消息包是分包中的第几个消息包, 从 1 开始
    private Integer subPackageSeq;

    // 消息体长度 bit[0-9]
    private Integer msgBodyLength = 0;
    // 数据加密方式 bit[10-12]
    private Integer encryptionType = 0b000;
    // 是否分包,true==>有消息包封装项 bit[13]
    private boolean hasSubPackage = false;
    // 保留位 bit[14-15]
    private Integer reservedBit = 0;

    public Header() {
    }

    public Header(Integer type, Integer flowId, String terminalPhone) {
        this.type = type;
        this.flowId = flowId;
        this.terminalPhone = terminalPhone;
    }

    @Override
    @Property(index = 0, type = DataType.WORD, desc = "消息ID")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Property(index = 2, type = DataType.WORD, desc = "消息体属性")
    public Integer getMsgBodyProperties() {
        if (msgBodyLength >= 1024)
            System.out.println("The max value of msgLen is 1023, but {} ." + msgBodyLength);
        int subPkg = hasSubPackage ? 1 : 0;
        int ret = (msgBodyLength & 0x3FF) |
                ((encryptionType << 10) & 0x1C00) |
                ((subPkg << 13) & 0x2000) |
                ((reservedBit << 14) & 0xC000);

        return ret & 0xffff;
    }

    public void setMsgBodyProperties(Integer msgBodyProperties) {
        this.msgBodyProperties = msgBodyProperties;

        this.msgBodyLength = msgBodyProperties & 0x3ff;
        this.encryptionType = (msgBodyProperties & 0x1c00) >> 10;
        this.hasSubPackage = ((msgBodyProperties & 0x2000) >> 13) == 1;
        this.reservedBit = ((msgBodyProperties & 0xc000) >> 14);
    }

    @Property(index = 4, type = DataType.BCD8421, length = 6, pad = 48, desc = "终端手机号")
    public String getTerminalPhone() {
        return terminalPhone;
    }

    public void setTerminalPhone(String terminalPhone) {
        this.terminalPhone = terminalPhone;
    }

    @Property(index = 10, type = DataType.WORD, desc = "流水号")
    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    @Property(index = 12, type = DataType.WORD, desc = "消息包总数")
    public Integer getTotalSubPackage() {
        return totalSubPackage;
    }

    public void setTotalSubPackage(Integer totalSubPackage) {
        this.totalSubPackage = totalSubPackage;
    }

    @Property(index = 14, type = DataType.WORD, desc = "包序号")
    public Integer getSubPackageSeq() {
        return subPackageSeq;
    }

    public void setSubPackageSeq(Integer subPackageSeq) {
        this.subPackageSeq = subPackageSeq;
    }

    public Integer getEncryptionType() {
        return encryptionType;
    }

    public void setEncryptionType(Integer encryptionType) {
        this.encryptionType = encryptionType;
    }

    public boolean isHasSubPackage() {
        return hasSubPackage;
    }

    public void setHasSubPackage(boolean hasSubPackage) {
        this.hasSubPackage = hasSubPackage;
    }

    public Integer getReservedBit() {
        return reservedBit;
    }

    public void setReservedBit(Integer reservedBit) {
        this.reservedBit = reservedBit;
    }

    @Override
    public Integer getHeaderLength() {
        return hasSubPackage ? 16 : 12;
    }

    @Override
    public Integer getMsgBodyLength() {
        return msgBodyLength;
    }

    @Override
    public void setMsgBodyLength(Integer bodyLength) {
        this.msgBodyLength = bodyLength;
    }
}

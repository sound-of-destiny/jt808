package cn.edu.sdu.jt808.protocol.upMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.protocol.Header;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;

@MsgType(MessageId.msg_id_terminal_attribute_query_resp)
public class AttributeQueryResponse extends PackageData<Header> {
    // 终端类型
    private Integer terminalType;
    // 制造商ID 5 个字节，终端制造商编码
    private String manufacturerId;
    // 终端型号 8个字节， 此终端型号 由制造商自行定义 位数不足八位的，补0x00
    private String terminalModel;
    // 终端ID 7个字节， 由大写字母 和数字组成， 此终端 ID由制造 商自行定义
    private String terminalId;
    // 终端 SIM 卡 ICCID
    private String ICCID;
    // 终端硬件版本号长度
    private Integer terminalHardwareVersionLength;
    // 终端硬件版本号
    private String terminalHardwareVersion;
    // 终端固件版本号长度
    private Integer terminalFirmwareVersionLength;
    // 终端固件版本号
    private String terminalFirmwareVersion;
    // GNSS 模块属性
    private Integer gnssAttribute;
    // 通信模块属性
    private Integer communicationModuleAttribute;

    public AttributeQueryResponse() {}

    public AttributeQueryResponse(Header header) {
    }

    @Property(index = 0, type = DataType.BYTE, desc = "终端类型")
    public Integer getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(Integer terminalType) {
        this.terminalType = terminalType;
    }

    @Property(index = 1, type = DataType.STRING, length = 7, pad = 32, desc = "制造商ID,终端制造商编码")
    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    @Property(index = 8, type = DataType.STRING, length = 20, pad = 32, desc = "终端型号,由制造商自行定义,位数不足八位补空格")
    public String getTerminalModel() {
        return terminalModel;
    }

    public void setTerminalModel(String terminalModel) {
        this.terminalModel = terminalModel;
    }

    @Property(index = 27, type = DataType.STRING, length = 7, desc = "终端ID,由大写字母和数字组成,此终端ID由制造商自行定义")
    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    @Property(index = 34, type = DataType.BCD8421, length = 10, desc = "终端SIM卡ICCID")
    public String getICCID() {
        return ICCID;
    }

    public void setICCID(String ICCID) {
        this.ICCID = ICCID;
    }

    @Property(index = 45, type = DataType.BYTE, desc = "硬件版本号长度")
    public Integer getTerminalHardwareVersionLength() {
        return terminalHardwareVersionLength;
    }

    public void setTerminalHardwareVersionLength(Integer terminalHardwareVersionLength) {
        this.terminalHardwareVersionLength = terminalHardwareVersionLength;
    }

    @Property(index = 46, type = DataType.STRING, lengthName = "terminalHardwareVersionLength", desc = "硬件版本号")
    public String getTerminalHardwareVersion() {
        return terminalHardwareVersion;
    }

    public void setTerminalHardwareVersion(String terminalHardwareVersion) {
        this.terminalHardwareVersion = terminalHardwareVersion;
    }

    @Property(index = 46, indexOfName = "terminalHardwareVersionLength", type = DataType.BYTE, desc = "固件版本号长度")
    public Integer getTerminalFirmwareVersionLength() {
        return terminalFirmwareVersionLength;
    }

    public void setTerminalFirmwareVersionLength(Integer terminalFirmwareVersionLength) {
        this.terminalFirmwareVersionLength = terminalFirmwareVersionLength;
    }

    @Property(index = 47, type = DataType.STRING, lengthName = "terminalFirmwareVersionLength", desc = "固件版本号")
    public String getTerminalFirmwareVersion() {
        return terminalFirmwareVersion;
    }

    public void setTerminalFirmwareVersion(String terminalFirmwareVersion) {
        this.terminalFirmwareVersion = terminalFirmwareVersion;
    }

    @Property(index = 47, indexOfName = {"terminalHardwareVersionLength", "terminalFirmwareVersionLength"}, type = DataType.BYTE, desc = "GNSS模块属性")
    public Integer getGnssAttribute() {
        return gnssAttribute;
    }

    public void setGnssAttribute(Integer gnssAttribute) {
        this.gnssAttribute = gnssAttribute;
    }

    @Property(index = 48, indexOfName = {"terminalHardwareVersionLength", "terminalFirmwareVersionLength"}, type = DataType.BYTE, desc = "通信模块属性")
    public Integer getCommunicationModuleAttribute() {
        return communicationModuleAttribute;
    }

    public void setCommunicationModuleAttribute(Integer communicationModuleAttribute) {
        this.communicationModuleAttribute = communicationModuleAttribute;
    }
}

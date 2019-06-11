package cn.edu.sdu.jt808.protocol.upMsg;


import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.protocol.Header;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;

@MsgType(MessageId.msg_id_digital_data_upload)
public class DigitWaybill extends PackageData<Header> {
    // 电子运单长度
    private Integer digitWaybillLength;
    // 电子运单内容
    private byte[] digitWaybillData;

    @Property(index = 0, type = DataType.DWORD, desc = "电子运单长度")
    public Integer getDigitWaybillLength() {
        return digitWaybillLength;
    }

    public void setDigitWaybillLength(Integer digitWaybillLength) {
        this.digitWaybillLength = digitWaybillLength;
    }

    @Property(index = 0, type = DataType.BYTES, desc = "电子运单内容")
    public byte[] getDigitWaybillData() {
        return digitWaybillData;
    }

    public void setDigitWaybillData(byte[] digitWaybillData) {
        this.digitWaybillData = digitWaybillData;
    }

    @Override
    public String toString() {
        return "{ " +
                "\"terminalPhone\" : \"" + this.getHeader().getTerminalPhone() +
                "\", \"digitWaybillData\" : " + new String(digitWaybillData) +
                "\" }";
    }
}

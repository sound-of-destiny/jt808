package cn.edu.sdu.jt808.protocol.upMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.protocol.Header;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;

@MsgType(MessageId.msg_id_Identity_information_upload)
public class DriverIdentity extends PackageData<Header> {
    // 状态
    // 0x01:从业资格证 IC 卡插入(驾驶员上班)
    // 0x02:从业资格证 IC 卡拔出(驾驶员下班)
    private Integer state;
    // 时间
    // 插卡/拔卡时间,YY-MM-DD-hh-mm-ss;
    // 以下字段在状态为 0x01 时才有效并做填充
    private String time;
    // IC 卡读取结果
    // 0x00:IC 卡读卡成功;
    // 0x01:读卡失败,原因为卡片密钥认证未通过;
    // 0x02:读卡失败,原因为卡片已被锁定;
    // 0x03:读卡失败,原因为卡片被拔出;
    // 0x04:读卡失败,原因为数据校验错误。
    // 以下字段在 IC 卡读取结果等于 0x00 时才有效
    private Integer ICCardInfo;
    // 驾驶员姓名长度
    private Integer driverNameLength;
    // 驾驶员姓名
    private String driverName;
    // 从业资格证编码
    // 长度 20 位,不足补 0x00
    private String qualificationCode;
    // 发证机构名称长度
    private Integer authorityNameLength;
    // 发证机构名称
    private String authorityName;
    // 证件有效期 BCD[4] YYYYMMDD
    private String cardValidityTerm;



    public DriverIdentity(){}


    @Property(index = 0, type = DataType.BYTE, desc = "状态")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Property(index = 1, type = DataType.BCD8421, length = 6, desc = "时间")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Property(index = 7, type = DataType.BYTE, desc = "IC卡读取结果")
    public Integer getICCardInfo() {
        return ICCardInfo;
    }

    public void setICCardInfo(Integer ICCardInfo) {
        this.ICCardInfo = ICCardInfo;
    }

    @Property(index = 8, type = DataType.BYTE, desc = "驾驶员姓名长度")
    public Integer getDriverNameLength() {
        return driverNameLength;
    }

    public void setDriverNameLength(Integer driverNameLength) {
        this.driverNameLength = driverNameLength;
    }

    @Property(index = 9, type = DataType.STRING, lengthName = "driverNameLength", desc = "驾驶员姓名")
    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Property(index = 9, indexOfName = "driverNameLength", type = DataType.STRING, length = 20, desc = "从业资格证编码")
    public String getQualificationCode() {
        return qualificationCode;
    }

    public void setQualificationCode(String qualificationCode) {
        this.qualificationCode = qualificationCode;
    }

    @Property(index = 29, indexOfName = "driverNameLength", type = DataType.BYTE, desc = "发证机构名称长度")
    public Integer getAuthorityNameLength() {
        return authorityNameLength;
    }

    public void setAuthorityNameLength(Integer authorityNameLength) {
        this.authorityNameLength = authorityNameLength;
    }

    @Property(index = 30, indexOfName = "driverNameLength", type = DataType.STRING, lengthName = "authorityNameLength", desc = "发证机构名称")
    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    @Property(index = 30, indexOfName = {"driverNameLength", "authorityNameLength"}, type = DataType.BCD8421, length = 4, desc = "证件有效期")
    public String getCardValidityTerm() {
        return cardValidityTerm;
    }

    public void setCardValidityTerm(String cardValidityTerm) {
        this.cardValidityTerm = cardValidityTerm;
    }

    @Override
    public String toString() {
        return "{ " +
                "\"terminalPhone\" : \"" + this.getHeader().getTerminalPhone() +
                "\", \"state\" : " + state +
                ", \"time\" : \"" + time +
                "\", \"ICCardInfo\" : " + ICCardInfo +
                ", \"driverName\" : \"" + driverName +
                "\", \"qualificationCode\" : \"" + qualificationCode +
                "\", \"authorityName\" : \"" + authorityName +
                "\", \"cardValidityTerm\" : \"" + cardValidityTerm +
                "\" }";
    }



}

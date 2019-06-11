package cn.edu.sdu.jt808.protocol.downMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.protocol.Header;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;

@MsgType(MessageId.cmd_terminal_register_resp)
public class RegisterResponse extends PackageData<Header> {

    public static final Integer success = 0;
    public static final Integer car_already_registered = 1;
    public static final Integer car_not_found = 2;
    public static final Integer terminal_already_registered = 3;
    public static final Integer terminal_not_found = 4;

    public RegisterResponse() {
    }

    public RegisterResponse(Header header) {
        super(header);
    }

    public RegisterResponse(Header header, Integer replyCode, String replyToken) {
        super(header);
        this.replyFlowId = header.getFlowId();
        this.replyCode = replyCode;
        this.replyToken = replyToken;
    }

    // 应答流水号 byte[0-1] 对应的终端注册消息的流水号
    private Integer replyFlowId;


    private Integer replyCode;

    // 鉴权码(STRING) byte[3-x] 只有在成功后才有该字段
    private String replyToken;

    @Property(index = 0, type = DataType.WORD, desc = "应答流水号")
    public Integer getReplyFlowId() {
        return replyFlowId;
    }

    public void setReplyFlowId(Integer replyFlowId) {
        this.replyFlowId = replyFlowId;
    }

    @Property(index = 2, type = DataType.BYTE, desc = "结果")
    public Integer getReplyCode() {
        return replyCode;
    }

    public void setReplyCode(Integer replyCode) {
        this.replyCode = replyCode;
    }

    @Property(index = 3, type = DataType.STRING, desc = "鉴权码")
    public String getReplyToken() {
        return replyToken;
    }

    public void setReplyToken(String replyToken) {
        this.replyToken = replyToken;
    }

    @Override
    public String toString() {
        return "[replyFlowId=" + replyFlowId + ", replyCode=" + replyCode + ", replyToken=" + replyToken + "]";
    }

}

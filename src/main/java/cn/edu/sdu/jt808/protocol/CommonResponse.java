package cn.edu.sdu.jt808.protocol;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;

@MsgType({MessageId.msg_id_terminal_common_resp, MessageId.cmd_common_resp})
public class CommonResponse extends PackageData<Header> {

    public static final int success = 0;
    public static final int failure = 1;
    public static final int msg_error = 2;
    public static final int unsupported = 3;
    public static final int AlarmConfirmation = 4;

    // 应答流水号 byte[0-1] 对应的终端消息的流水号
    private Integer replyFlowId;

    // 应答ID byte[2-3] 对应的终端消息的ID
    private Integer replyId;

    /**
     * 0：成功∕确认<br>
     * 1：失败<br>
     * 2：消息有误<br>
     * 3：不支持<br>
     */
    private Integer replyCode;

    public CommonResponse() {
    }

    public CommonResponse(Header header, int replyId) {
        super(header);
        this.replyId = replyId;
        this.replyFlowId = header.getFlowId();
    }

    public CommonResponse(Header header, int replyId, int replyFlowId, int replyCode) {
        super(header);
        this.replyId = replyId;
        this.replyFlowId = replyFlowId;
        this.replyCode = replyCode;
    }

    @Property(index = 0, type = DataType.WORD, desc = "应答流水号")
    public Integer getReplyFlowId() {
        return replyFlowId;
    }

    public void setReplyFlowId(Integer replyFlowId) {
        this.replyFlowId = replyFlowId;
    }

    @Property(index = 2, type = DataType.WORD, desc = "应答ID")
    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    @Property(index = 4, type = DataType.BYTE, desc = "结果（响应码）")
    public Integer getReplyCode() {
        return replyCode;
    }

    public void setReplyCode(Integer replyCode) {
        this.replyCode = replyCode;
    }

    @Override
    public String toString() {
        return "[replyFlowId=" + replyFlowId + ", replyId=" + replyId + ", replyCode=" + replyCode + "]";
    }
}

package cn.edu.sdu.jt808.protocol.upMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.protocol.Header;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;

@MsgType(MessageId.msg_id_ask_answer)
public class QuestionMsgResponse extends PackageData<Header> {

    private Integer replyFlowId;
    private Integer answerId;

    @Property(index = 0, type = DataType.WORD, desc = "应答流水号")
    public Integer getReplyFlowId() {
        return replyFlowId;
    }

    public void setReplyFlowId(Integer replyFlowId) {
        this.replyFlowId = replyFlowId;
    }

    @Property(index = 2, type = DataType.BYTE, desc = "答案ID")
    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }
}
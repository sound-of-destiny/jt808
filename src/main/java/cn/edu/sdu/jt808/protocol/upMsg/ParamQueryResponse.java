package cn.edu.sdu.jt808.protocol.upMsg;


import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.protocol.Header;
import cn.edu.sdu.jt808.protocol.TerminalParam;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;

import java.util.List;

@MsgType(MessageId.msg_id_terminal_param_query_resp)
public class ParamQueryResponse extends PackageData<Header> {

    private Integer replyFlowId;
    private Integer replyParamNumber;
    private List<TerminalParam> terminalParams;

    @Property(index = 0, type = DataType.WORD, desc = "应答流水号")
    public Integer getReplyFlowId() {
        return replyFlowId;
    }

    public void setReplyFlowId(Integer replyFlowId) {
        this.replyFlowId = replyFlowId;
    }

    @Property(index = 2, type = DataType.BYTE, desc = "应答参数个数")
    public Integer getReplyParamNumber() {
        return replyParamNumber;
    }

    public void setReplyParamNumber(Integer replyParamNumber) {
        this.replyParamNumber = replyParamNumber;
    }

    @Property(index = 3, type = DataType.LIST, desc = "参数项列表")
    public List<TerminalParam> getTerminalParams() {
        return terminalParams;
    }

    public void setTerminalParams(List<TerminalParam> terminalParams) {
        this.terminalParams = terminalParams;
    }
}

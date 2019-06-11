package cn.edu.sdu.jt808.protocol.downMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.protocol.Header;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;

import java.util.List;

@MsgType(MessageId.cmd_terminal_param_settings)
public class ParameterSetting extends PackageData<Header> {

    private Integer total;
    private List<ParameterSetting> parameters;

    @Property(index = 0, type = DataType.BYTE, desc = "参数总数")
    public Integer getTotal() {
        if (parameters == null || parameters.isEmpty())
            return 0;
        return parameters.size();
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Property(index = 1, type = DataType.LIST, desc = "参数项列表")
    public List<ParameterSetting> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParameterSetting> parameters) {
        this.parameters = parameters;
    }
}
package cn.edu.sdu.jt808.protocol.downMsg;

import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;

public class AppointParamQuery {

    private Integer paramNumber;
    private int[] paramIdList;

    @Property(index = 0, type = DataType.BYTE, desc = "参数总数")
    public Integer getParamNumber() {
        return paramNumber;
    }

    public void setParamNumber(Integer paramNumber) {
        this.paramNumber = paramNumber;
    }

    @Property(index = 1, type = DataType.LIST, desc = "参数Id列表")
    public int[] getParamIdList() {
        return paramIdList;
    }

    public void setParamIdList(int[] paramIdList) {
        this.paramIdList = paramIdList;
    }
}

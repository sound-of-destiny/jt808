package cn.edu.sdu.jt808.protocol.downMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;
import cn.edu.sdu.jt808.protocol.Header;

@MsgType(MessageId.cmd_data_download)
public class PassThroughDownLoad extends PackageData<Header> {

    // 高级驾驶辅助系统
    public static final int ADAS = 0x64;
    // 驾驶员状态监控系统
    public static final int DSM = 0x65;
    // 轮胎气压监测系统
    public static final int TPMS = 0x66;
    // 盲点监测系统
    public static final int BSD = 0x67;


    private Integer type;
    private Integer total;
    private int[] peripheralIdList;

    public PassThroughDownLoad() {
    }

    public PassThroughDownLoad(Integer type) {
        this.type = type;
    }

    @Property(index = 0, type = DataType.BYTE, desc = "透传消息类型")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Property(index = 1, type = DataType.BYTE, desc = "消息列表总数")
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Property(index = 2, type = DataType.BYTES, desc = "消息列表")
    public int[] getPeripheralIdList() {
        return peripheralIdList;
    }

    public void setPeripheralIdList(int[] peripheralIdList) {
        this.peripheralIdList = peripheralIdList;
    }
}
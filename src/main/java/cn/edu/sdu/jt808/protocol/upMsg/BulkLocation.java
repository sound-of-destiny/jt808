package cn.edu.sdu.jt808.protocol.upMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.protocol.Header;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;

import java.util.List;

@MsgType(MessageId.msg_id_bulk_location_upload)
public class BulkLocation extends PackageData<Header> {

    private Integer dataNum;
    private Integer dataType;
    private List<Location> locationMsgs;


    @Property(index = 0, type = DataType.WORD, desc = "数据项个数")
    public Integer getDataNum() {
        return dataNum;
    }

    public void setDataNum(Integer dataNum) {
        this.dataNum = dataNum;
    }

    @Property(index = 2, type = DataType.BYTE, desc = "位置数据类型")
    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    @Property(index = 3, type = DataType.LIST, desc = "位置数据类型")
    public List<Location> getLocationMsgs() {
        return locationMsgs;
    }

    public void setLocationMsgs(List<Location> locationMsgs) {
        this.locationMsgs = locationMsgs;
    }
}

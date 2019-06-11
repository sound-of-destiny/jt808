package cn.edu.sdu.jt808.protocol.upMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.protocol.Header;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;

import java.util.List;

/**
 *
 * 位置信息应答消息
 *
 */
@MsgType(MessageId.msg_id_terminal_location_query_resp)
public class LocationReply extends PackageData<Header> {

    private Integer replyFlowId;

    //报警标志 byte[0-3]
    private Integer warningFlag;

    //状态 byte[4-7]
    private Integer status;

    //纬度 byte[8-11]
    private Integer latitude;

    //经度 byte[12-15]
    private Integer longitude;

    //高程 byte[16-17]
    private Integer elevation;

    //速度 byte[18-19]
    private Integer speed;

    //方向 byte[20-21]
    private Integer direction;

    //时间(BCD[6] YY-MM-DD-hh-mm-ss) byte[22-27]
    private String time;

    // 位置附加信息项
    private List<ExtraLocation> extraLocations;



    @Property(index = 0, type = DataType.WORD, desc = "应答流水号")
    public Integer getReplyFlowId() {
        return replyFlowId;
    }

    public void setReplyFlowId(Integer replyFlowId) {
        this.replyFlowId = replyFlowId;
    }

    @Property(index = 2, type = DataType.DWORD, desc = "报警标志")
    public Integer getWarningFlag() {
        return warningFlag;
    }

    public void setWarningFlag(Integer warningFlag) {
        this.warningFlag = warningFlag;
    }

    @Property(index = 6, type = DataType.DWORD, desc = "状态")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Property(index = 10, type = DataType.DWORD, desc = "纬度")
    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    @Property(index = 14, type = DataType.DWORD, desc = "经度")
    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    @Property(index = 18, type = DataType.WORD, desc = "海拔")
    public Integer getElevation() {
        return elevation;
    }

    public void setElevation(Integer elevation) {
        this.elevation = elevation;
    }

    @Property(index = 20, type = DataType.WORD, desc = "速度")
    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    @Property(index = 22, type = DataType.WORD, desc = "方向")
    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    @Property(index = 24, type = DataType.BCD8421, length = 6, desc = "时间")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Property(index = 30, type = DataType.LIST, desc = "位置附加信息")
    public List<ExtraLocation> getExtraLocations() {
        return extraLocations;
    }

    public void setExtraLocations(List<ExtraLocation> extraLocations) {
        this.extraLocations = extraLocations;
    }
}

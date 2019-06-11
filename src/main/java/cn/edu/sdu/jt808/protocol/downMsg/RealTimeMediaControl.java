package cn.edu.sdu.jt808.protocol.downMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;
import cn.edu.sdu.jt808.protocol.Header;

@MsgType(MessageId.cmd_real_time_media_transmission_control)
public class RealTimeMediaControl extends PackageData<Header> {
    private Integer logicalChannelId;
    private Integer controlCOde;
    private Integer closeMediaType;
    private Integer changeCode;


    @Property(index = 0, type = DataType.BYTE, desc = "逻辑通道号")
    public Integer getLogicalChannelId() {
        return logicalChannelId;
    }

    public void setLogicalChannelId(Integer logicalChannelId) {
        this.logicalChannelId = logicalChannelId;
    }

    @Property(index = 1, type = DataType.BYTE, desc = "控制指令")
    public Integer getControlCOde() {
        return controlCOde;
    }

    public void setControlCOde(Integer controlCOde) {
        this.controlCOde = controlCOde;
    }

    @Property(index = 2, type = DataType.BYTE, desc = "关闭音视频类型")
    public Integer getCloseMediaType() {
        return closeMediaType;
    }

    public void setCloseMediaType(Integer closeMediaType) {
        this.closeMediaType = closeMediaType;
    }

    @Property(index = 3, type = DataType.BYTE, desc = "切换码流类型")
    public Integer getChangeCode() {
        return changeCode;
    }

    public void setChangeCode(Integer changeCode) {
        this.changeCode = changeCode;
    }
}

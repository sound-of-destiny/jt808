package cn.edu.sdu.jt808.protocol.upMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.annotation.ProtoBuf;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.commons.JavaType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;
import cn.edu.sdu.jt808.protocol.Header;

@MsgType(MessageId.msg_id_media_upload)
public class MediaData extends PackageData<Header> {
    // 多媒体 ID
    private Integer mediaId;
    // 多媒体类型 0:图像;1:音频;2:视频
    private Integer mediaType;
    // 多媒体格式编码 0:JPEG;1:TIF;2:MP3;3:WAV;4:WMV
    private Integer mediaCode;
    // 事件项编码 0:平台下发指令;1:定时动作;2:抢劫报警触发;3:碰撞侧翻报警触发;其他保留
    private Integer eventCode;
    // 通道 ID
    private Integer channelId;
    // 位置信息汇报
    private Location location;
    // 多媒体数据包
    @ProtoBuf(type = JavaType.BYTE)
    private byte[] data;

    public MediaData(){}

    @Property(index = 0, type = DataType.DWORD, desc = "多媒体数据ID")
    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    @Property(index = 4, type = DataType.BYTE, desc = "多媒体类型 0：图像；1：音频；2：视频；")
    public Integer getMediaType() {
        return mediaType;
    }

    public void setMediaType(Integer mediaType) {
        this.mediaType = mediaType;
    }

    @Property(index = 5, type = DataType.BYTE, desc = "多媒体格式编码 0：JPEG；1：TIF；2：MP3；3：WAV；4：WMV；")
    public Integer getMediaCode() {
        return mediaCode;
    }

    public void setMediaCode(Integer mediaCode) {
        this.mediaCode = mediaCode;
    }

    @Property(index = 6, type = DataType.BYTE, desc = "事件项编码")
    public Integer getEventCode() {
        return eventCode;
    }

    public void setEventCode(Integer eventCode) {
        this.eventCode = eventCode;
    }

    @Property(index = 7, type = DataType.BYTE, desc = "通道ID")
    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    @Property(index = 8, type = DataType.OBJ, length = 28, desc = "位置信息")
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Property(index = 36, type = DataType.BYTES, desc = "多媒体数据包")
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }


}

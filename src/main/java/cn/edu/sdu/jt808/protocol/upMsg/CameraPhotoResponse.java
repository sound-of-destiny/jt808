package cn.edu.sdu.jt808.protocol.upMsg;


import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.protocol.Header;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;

import java.util.Arrays;

@MsgType(MessageId.msg_id_camera_photo_response)
public class CameraPhotoResponse extends PackageData<Header> {
    // 应答流水号 对应平台摄像头立即拍摄命令的消息流水号
    private Integer replyFlowId;
    // 结果 0:成功;1:失败;2:通道不支持 以下字段在结果=0 时才有效
    private Integer result;
    // 多媒体 ID 个数 拍摄成功的多媒体个数
    private Integer mediaIdNum;
    // 多媒体 ID 列表
    private byte[] mediaIdList;

    @Override
    public String toString() {
        return "TerminalCameraPhotoResponseMsg{" +
                "replyFlowId=" + replyFlowId +
                ", result=" + result +
                ", mediaIdNum=" + mediaIdNum +
                ", mediaIdList=" + Arrays.toString(mediaIdList) +
                '}';
    }

    @Property(index = 0, type = DataType.WORD, desc = "应答流水号")
    public Integer getReplyFlowId() {
        return replyFlowId;
    }

    public void setReplyFlowId(Integer replyFlowId) {
        this.replyFlowId = replyFlowId;
    }

    @Property(index = 2, type = DataType.BYTE, desc = "结果")
    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Property(index = 2, type = DataType.WORD, desc = "多媒体ID个数")
    public Integer getMediaIdNum() {
        return mediaIdNum;
    }

    public void setMediaIdNum(Integer mediaIdNum) {
        this.mediaIdNum = mediaIdNum;
    }

    @Property(index = 4, type = DataType.BYTES, desc = "多媒体ID列表")
    public byte[] getMediaIdList() {
        return mediaIdList;
    }

    public void setMediaIdList(byte[] mediaIdList) {
        this.mediaIdList = mediaIdList;
    }
}

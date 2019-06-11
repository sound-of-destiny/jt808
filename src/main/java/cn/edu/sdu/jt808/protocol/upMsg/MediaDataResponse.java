package cn.edu.sdu.jt808.protocol.upMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.protocol.Header;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;

@MsgType(MessageId.cmd_media_upload_resp)
public class MediaDataResponse extends PackageData<Header> {

    private Integer mediaId;
    private Integer packageTotal;
    private byte[] idList;

    public MediaDataResponse() {
    }


    public MediaDataResponse(Header header) {
        super(header);
    }
    /** >0，如收到全部数据包则没有后续字段 */

    @Property(index = 0, type = DataType.DWORD, desc = "多媒体ID")
    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    @Property(index = 4, type = DataType.BYTE, desc = "重传包总数")
    public Integer getPackageTotal() {
        return packageTotal;
    }

    public void setPackageTotal(Integer packageTotal) {
        this.packageTotal = packageTotal;
    }

    @Property(index = 5, type = DataType.BYTES, desc = "重传包ID列表")
    public byte[] getIdList() {
        return idList;
    }

    public void setIdList(byte[] idList) {
        this.idList = idList;
    }
}
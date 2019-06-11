package cn.edu.sdu.jt808.protocol.downMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;
import cn.edu.sdu.jt808.protocol.Header;

import java.util.List;

@MsgType(MessageId.cmd_file_upload_complete_response)
public class FileUploadFinishResponse extends PackageData<Header> {
    // 文件名称长度
    private Integer fileNameLength;
    // 文件名称
    private String fileName;
    // 文件类型
    private Integer fileType;
    // 上传结果
    private Integer uploadResult;
    // 补传数据包数量
    private Integer retransmittedPacketNum;
    // 补传数据包列表
    private List<RetransmittedPacket> retransmittedPackets;

    public static class RetransmittedPacket {
        // 数据偏移量
        private Integer dataOffset;
        // 数据偏移量
        private Integer dataLength;

        @Property(index = 0, type = DataType.DWORD)
        public Integer getDataOffset() {
            return dataOffset;
        }

        public void setDataOffset(Integer dataOffset) {
            this.dataOffset = dataOffset;
        }

        @Property(index = 4, type = DataType.DWORD)
        public Integer getDataLength() {
            return dataLength;
        }

        public void setDataLength(Integer dataLength) {
            this.dataLength = dataLength;
        }
    }

    @Property(index = 0, type = DataType.BYTE)
    public Integer getFileNameLength() {
        return fileNameLength;
    }

    public void setFileNameLength(Integer fileNameLength) {
        this.fileNameLength = fileNameLength;
    }

    @Property(index = 1, type = DataType.STRING, lengthName = "fileNameLength")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Property(index = 2, type = DataType.BYTE)
    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    @Property(index = 3, type = DataType.BYTE)
    public Integer getUploadResult() {
        return uploadResult;
    }

    public void setUploadResult(Integer uploadResult) {
        this.uploadResult = uploadResult;
    }

    @Property(index = 4, type = DataType.BYTE)
    public Integer getRetransmittedPacketNum() {
        return retransmittedPacketNum;
    }

    public void setRetransmittedPacketNum(Integer retransmittedPacketNum) {
        this.retransmittedPacketNum = retransmittedPacketNum;
    }

    @Property(index = 5, type = DataType.LIST)
    public List<RetransmittedPacket> getRetransmittedPackets() {
        return retransmittedPackets;
    }

    public void setRetransmittedPackets(List<RetransmittedPacket> retransmittedPackets) {
        this.retransmittedPackets = retransmittedPackets;
    }
}

package cn.edu.sdu.jt808.protocol.upMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;
import cn.edu.sdu.jt808.protocol.Header;

@MsgType({ MessageId.msg_id_file_msg_upload, MessageId.msg_id_file_upload_complete })
public class FIleInfoUpload extends PackageData<Header> {
    // 文件名称长度
    private Integer fileNameLength;
    // 文件名称
    private String fileName;
    // 文件类型
    private Integer fileType;
    // 文件大小
    private Integer fileSize;

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
    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }
}

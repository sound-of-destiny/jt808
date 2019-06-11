package cn.edu.sdu.jt808.protocol.upMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;
import cn.edu.sdu.jt808.protocol.Header;

import java.util.List;

@MsgType(MessageId.msg_id_alarm_file_msg)
public class AlarmFileInfo extends PackageData<Header> {
    // 终端 ID
    private byte[] terminalId;
    // 报警标识号
    private byte[] alarmFlag;
    // 报警编号
    private byte[] alarmCode;
    // 信息类型
    private Integer infoType;
    // 附件数量
    private Integer fileNum;
    // 附件信息列表
    private List<FileInfo> fileInfoList;

    public static class FileInfo {
        // 文件名称长度
        private Integer fileNameLength;
        // 文件名称
        private String fileName;
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

        @Property(index = 2, type = DataType.DWORD)
        public Integer getFileSize() {
            return fileSize;
        }

        public void setFileSize(Integer fileSize) {
            this.fileSize = fileSize;
        }
    }

    @Property(index = 0, type = DataType.BYTE)
    public byte[] getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(byte[] terminalId) {
        this.terminalId = terminalId;
    }

    @Property(index = 1, type = DataType.BYTES, length = 16)
    public byte[] getAlarmFlag() {
        return alarmFlag;
    }

    public void setAlarmFlag(byte[] alarmFlag) {
        this.alarmFlag = alarmFlag;
    }

    @Property(index = 17, type = DataType.BYTES, length = 32)
    public byte[] getAlarmCode() {
        return alarmCode;
    }

    public void setAlarmCode(byte[] alarmCode) {
        this.alarmCode = alarmCode;
    }

    @Property(index = 49, type = DataType.BYTE)
    public Integer getInfoType() {
        return infoType;
    }

    public void setInfoType(Integer infoType) {
        this.infoType = infoType;
    }

    @Property(index = 50, type = DataType.BYTE)
    public Integer getFileNum() {
        return fileNum;
    }

    public void setFileNum(Integer fileNum) {
        this.fileNum = fileNum;
    }

    @Property(index = 51, type = DataType.LIST)
    public List<FileInfo> getFileInfoList() {
        return fileInfoList;
    }

    public void setFileInfoList(List<FileInfo> fileInfoList) {
        this.fileInfoList = fileInfoList;
    }
}

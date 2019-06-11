package cn.edu.sdu.jt808.protocol.downMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;
import cn.edu.sdu.jt808.protocol.Header;

@MsgType(MessageId.cmd_file_upload)
public class FileUpload extends PackageData<Header> {
    // 服务器地址长度
    private Integer hostLength;
    // 服务器地址
    private String host;
    // 端口
    private Integer port;
    // 用户名长度
    private Integer usernameLength;
    // 用户名
    private String username;
    // 密码长度
    private Integer passwordLength;
    // 密码
    private String password;
    // 文件上传路径长度
    private Integer fileUploadPathLength;
    // 文件上传路径
    private String fileUploadPath;
    // 逻辑通道号
    private Integer channelId;
    // 开始时间
    private String startTime;
    // 结束时间
    private String endTime;
    // 报警标志
    private Long alarmFlag;
    // 音视频资源类型
    private Integer mediaResourceType;
    // 码流类型
    private Integer streamType;
    // 存储位置
    private Integer storeLocation;
    // 任务执行条件
    private Integer missionCodition;

    @Property(index = 0, type = DataType.BYTE)
    public Integer getHostLength() {
        return hostLength;
    }

    public void setHostLength(Integer hostLength) {
        this.hostLength = hostLength;
    }

    @Property(index = 1, type = DataType.STRING, lengthName = "hostLength")
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Property(index = 2, type = DataType.BYTE)
    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Property(index = 3, type = DataType.BYTE)
    public Integer getUsernameLength() {
        return usernameLength;
    }

    public void setUsernameLength(Integer usernameLength) {
        this.usernameLength = usernameLength;
    }

    @Property(index = 4, type = DataType.STRING, lengthName = "usernameLength")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Property(index = 5, type = DataType.BYTE)
    public Integer getPasswordLength() {
        return passwordLength;
    }

    public void setPasswordLength(Integer passwordLength) {
        this.passwordLength = passwordLength;
    }

    @Property(index = 6, type = DataType.STRING, lengthName = "passwordLength")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Property(index = 7, type = DataType.BYTE)
    public Integer getFileUploadPathLength() {
        return fileUploadPathLength;
    }

    public void setFileUploadPathLength(Integer fileUploadPathLength) {
        this.fileUploadPathLength = fileUploadPathLength;
    }

    @Property(index = 8, type = DataType.STRING, lengthName = "fileUploadPathLength")
    public String getFileUploadPath() {
        return fileUploadPath;
    }

    public void setFileUploadPath(String fileUploadPath) {
        this.fileUploadPath = fileUploadPath;
    }

    @Property(index = 9, type = DataType.BYTE)
    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    @Property(index = 10, type = DataType.BCD8421, length = 6)
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Property(index = 16, type = DataType.BCD8421, length = 6)
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Property(index = 22, type = DataType.LONG)
    public Long getAlarmFlag() {
        return alarmFlag;
    }

    public void setAlarmFlag(Long alarmFlag) {
        this.alarmFlag = alarmFlag;
    }

    @Property(index = 30, type = DataType.BYTE)
    public Integer getMediaResourceType() {
        return mediaResourceType;
    }

    public void setMediaResourceType(Integer mediaResourceType) {
        this.mediaResourceType = mediaResourceType;
    }

    @Property(index = 31, type = DataType.BYTE)
    public Integer getStreamType() {
        return streamType;
    }

    public void setStreamType(Integer streamType) {
        this.streamType = streamType;
    }

    @Property(index = 32, type = DataType.BYTE)
    public Integer getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(Integer storeLocation) {
        this.storeLocation = storeLocation;
    }

    @Property(index = 33, type = DataType.BYTE)
    public Integer getMissionCodition() {
        return missionCodition;
    }

    public void setMissionCodition(Integer missionCodition) {
        this.missionCodition = missionCodition;
    }
}

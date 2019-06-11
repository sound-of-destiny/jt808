package cn.edu.sdu.jt808.protocol;

import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;

import java.util.ArrayList;

public class TerminalParam {

    private Integer type;
    private Integer paramLength;

    @Property(index = 0, type = DataType.DWORD, desc = "参数ID")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Property(index = 2, type = DataType.BYTE, desc = "参数长度")
    public Integer getParamLength() {
        return paramLength;
    }

    public void setParamLength(Integer paramLength) {
        this.paramLength = paramLength;
    }

    // 终端心跳发送间隔,单位为秒(s)
    private Integer beatInterval;
    // TCP 消息应答超时时间,单位为秒(s)
    private Integer TCPTimeout;
    // TCP 消息重传次数
    private Integer TCPretransTimes;
    // UDP 消息应答超时时间,单位为秒(s)
    private Integer UDPTimeout;
    // UDP 消息重传次数
    private Integer UDPretransTimes;
    // SMS 消息应答超时时间,单位为秒(s)
    private Integer SMSTimeout;
    // SMS 消息重传次数
    private Integer SMSretransTimes;
    // 主服务器 APN
    private String mainServerAPN;
    // 主服务器无线通信拨号用户名
    private String mainServerUsername;
    // 主服务器无线通信拨号密码
    private String mainServerPassword;
    // 主服务器地址,IP 或域名
    private String mainServerHost;
    // 备份服务器 APN
    private String backupServerAPN;
    // 备份服务器无线通信拨号用户名
    private String backupServerUsername;
    // 备份服务器无线通信拨号密码
    private String backupServerPassword;
    // 备份服务器地址,IP 或域名
    private String backupServerHost;
    // 服务器 TCP 端口
    private Integer serverTCPport;
    // 服务器 UDP 端口
    private Integer serverUDPport;
    // 道路运输证 IC 卡认证主服务器 IP 地址或域名
    private String ICverifyMainServerHost;
    // 道路运输证 IC 卡认证主服务器 TCP 端口
    private Integer ICverifyServerTCPport;
    // 道路运输证 IC 卡认证主服务器 UDP 端口
    private Integer ICverifyServerUDPport;
    // 道路运输证 IC 卡认证备份服务器 IP 地址或域名
    private String ICVerifyBackupServerHost;
    // 位置汇报策略,0:定时汇报;1:定距汇报;2:定时和定距汇报
    private Integer locationInfoStrategy;
    // 位置汇报方案,0:根据 ACC 状态; 1:根据登录状态和 ACC 状态,先判断登录状态,若登录再根据 ACC 状态
    private Integer locationInfoPlan;
    // 驾驶员未登录汇报时间间隔,单位为秒(s),>0
    private Integer unloginTimeInterval;
    // 休眠时汇报时间间隔,单位为秒(s),>0
    private Integer sleepTimeInterval;
    // 紧急报警时汇报时间间隔,单位为秒(s),>0
    private Integer warningTimeInterval;
    // 缺省时间汇报间隔,单位为秒(s),>0
    private Integer defaultInterval;
    // 缺省距离汇报间隔,单位为米(m),>0
    private Integer defaultDistanceInterval;
    // 驾驶员未登录汇报距离间隔,单位为米(m),>0
    private Integer unloginDistanceInterval;
    // 休眠时汇报距离间隔,单位为米(m),>0
    private Integer sleepDistanceInterval;
    // 紧急报警时汇报距离间隔,单位为米(m),>0
    private Integer warningDistanceInterval;
    // 拐点补传角度,<180
    private Integer retransmissionAngle;
    // 电子围栏半径(非法位移阈值),单位为米
    private Integer electronicFenceRadius;
    // 监控平台电话号码
    private String platformPhoneNum;
    // 复位电话号码,可采用此电话号码拨打终端电话让终端复位
    private String resetPhoneNum;
    // 恢复出厂设置电话号码,可采用此电话号码拨打终端电话让终端恢复出厂设置
    private String restorePhoneNum;
    // 监控平台 SMS 电话号码
    private String platformSMSphoneNum;
    // 接收终端 SMS 文本报警号码
    private String alarmSMSphoneNum;
    // 终端电话接听策略,0:自动接听;1:ACC ON 时自动接听,OFF 时手动接听
    private Integer phoneStrategy;
    // 每次最长通话时间,单位为秒(s),0 为不允许通话,0xFFFFFFFF 为不限制
    private Integer longestPhoneTime;
    // 当月最长通话时间,单位为秒(s),0 为不允许通话,0xFFFFFFFF 为不限制
    private Integer monthLongestPhoneTime;
    // 监听电话号码
    private String monitorPhone;
    // 监管平台特权短信号码
    private String platformPrivilegeSMS;
    // 报警屏蔽字,与位置信息汇报消息中的报警标志相对应,相应位为 1则相应报警被屏蔽
    private Integer alarmShieldingWord;
    // 报警发送文本 SMS 开关,与位置信息汇报消息中的报警标志相对应,相应位为 1 则相应报警时发送文本 SMS
    private Integer alarmSMS;
    // 报警拍摄开关,与位置信息汇报消息中的报警标志相对应,相应位为1 则相应报警时摄像头拍摄
    private Integer alarmPhoto;
    // 报警拍摄存储标志,与位置信息汇报消息中的报警标志相对应,相应位为 1 则对相应报警时拍的照片进行存储,否则实时上传
    private Integer alarmPhotoSave;
    // 关键标志,与位置信息汇报消息中的报警标志相对应,相应位为 1 则对相应报警为关键报警
    private Integer keyFlag;
    // 最高速度,单位为公里每小时(km/h)
    private Integer highestSpeed;
    // 超速持续时间,单位为秒(s)
    private Integer speedingTime;
    // 连续驾驶时间门限,单位为秒(s)
    private Integer driverTimeLimit;
    // 当天累计驾驶时间门限,单位为秒(s)
    private Integer todayDriverTime;
    // 最小休息时间,单位为秒(s)
    private Integer leastRestTime;
    // 最长停车时间,单位为秒(s)
    private Integer longestPortTime;
    // 超速报警预警差值,单位为 1/10Km/h
    private Integer speedingWarningDifferenceValue;
    // 疲劳驾驶预警差值,单位为秒(s),>0
    private Integer tiredDriveWarningDifferenceValue;
    // 碰撞报警参数设置:b7-b0: 碰撞时间,单位 4ms;b15-b8:碰撞加速度,单位 0.1g,设置范围在:0-79 之间,默认为10 TODO
    private Integer collisionParam;
    // 侧翻报警参数设置:侧翻角度,单位 1 度,默认为 30 度
    private Integer rolloverParam;
    // 定时拍照控制,见 表 13
    private Integer timingPhotoControlBit;
    // 定距拍照控制,见 表 14
    private Integer fixedPictureControlBit;
    // 图像/视频质量,1-10,1 最好
    private Integer cameraQuality;
    // 亮度,0-255
    private Integer light;
    // 对比度,0-127
    private Integer contrast;
    // 饱和度,0-127
    private Integer saturation;
    // 色度,0-255
    private Integer color;
    // 车辆里程表读数,1/10km
    private Integer mileage;
    // 车辆所在的省域 ID
    private Integer provinceId;
    // 车辆所在的市域 ID
    private Integer cityId;
    // 公安交通管理部门颁发的机动车号牌
    private String licensePlate;
    // 车牌颜色,按照 JT/T415-2006 的 5.4.12
    private Integer licensePlateColor;
    // GNSS 定位模式,定义如下:
    // bit0,0:禁用 GPS 定位, 1:启用 GPS 定位;
    // bit1,0:禁用北斗定位, 1:启用北斗定位;
    // bit2,0:禁用 GLONASS 定位, 1:启用 GLONASS 定位;
    // bit3,0:禁用 Galileo 定位, 1:启用 Galileo 定位。
    private Integer gnss;
    // GNSS 波特率,定义如下:
    // 0x00:4800;0x01:9600;
    // 0x02:19200;0x03:38400;
    // 0x04:57600;0x05:115200。
    private Integer GNSSbaudRatio;
    // GNSS 模块详细定位数据输出频率,定义如下:
    // 0x00:500ms;0x01:1000ms(默认值);
    // 0x02:2000ms;0x03:3000ms;
    // 0x04:4000ms。
    private Integer GNSSdataOutputFrequency;
    // GNSS 模块详细定位数据采集频率,单位为秒,默认为 1
    private Integer GNSSdataFrequency;
    // GNSS 模块详细定位数据上传方式:
    // 0x00,本地存储,不上传(默认值);
    // 0x01,按时间间隔上传;
    // 0x02,按距离间隔上传;
    // 0x0B,按累计时间上传,达到传输时间后自动停止上传;
    // 0x0C,按累计距离上传,达到距离后自动停止上传;
    // 0x0D,按累计条数上传,达到上传条数后自动停止上传。
    private Integer locationUploadType;
    // GNSS 模块详细定位数据上传设置:
    // 上传方式为 0x01 时,单位为秒;
    // 上传方式为 0x02 时,单位为米;
    // 上传方式为 0x0B 时,单位为秒;
    // 上传方式为 0x0C 时,单位为米;
    // 上传方式为 0x0D 时,单位为条。
    private Integer locationUploadSetting;
    // CAN 总线通道 1 采集时间间隔(ms),0 表示不采集
    private Integer CAN1CatchTimeInterval;
    // CAN 总线通道 1 上传时间间隔(s),0 表示不上传
    private Integer CAN1UploadTimeInterval;
    // CAN 总线通道 2 采集时间间隔(ms),0 表示不采集
    private Integer CAN2CatchTimeInterval;
    // CAN 总线通道 2 上传时间间隔(s),0 表示不上传
    private Integer CAN2UploadTimeInterval;
    // CAN 总线 ID 单独采集设置:
    // bit63-bit32 表示此 ID 采集时间间隔(ms),0 表示不采集;
    // bit31 表示 CAN 通道号,0:CAN1,1:CAN2;
    // bit30 表示帧类型,0:标准帧,1:扩展帧;
    // bit29 表示数据采集方式,0:原始数据,1:采集区间的计算值;
    // bit28-bit0 表示 CAN 总线 ID。
    private Long CANIDParam;
    // private Long otherCANIDParam;

    // public static class GNSS {
        // 0:未使用 GPS 卫星进行定位;1:使用 GPS 卫星进行定位
        private boolean GPS;
        // 0:未使用北斗卫星进行定位;1:使用北斗卫星进行定位
        private boolean beidou;
        // 0:未使用 GLONASS 卫星进行定位;1:使用 GLONASS 卫星进行定位
        private boolean GLONASS;
        // 0:未使用 Galileo 卫星进行定位;1:使用 Galileo 卫星进行定位
        private boolean Galileo;

        public boolean isGPS() {
            return GPS;
        }

        public void setGPS(boolean GPS) {
            this.GPS = GPS;
        }

        public boolean isBeidou() {
            return beidou;
        }

        public void setBeidou(boolean beidou) {
            this.beidou = beidou;
        }

        public boolean isGLONASS() {
            return GLONASS;
        }

        public void setGLONASS(boolean GLONASS) {
            this.GLONASS = GLONASS;
        }

        public boolean isGalileo() {
            return Galileo;
        }

        public void setGalileo(boolean galileo) {
            Galileo = galileo;
        }
    // }

    //public static class TimingPhotoControlBit {
        // 摄像通道 1 定时拍照开关标志
        private boolean cameraChannelTiming1;
        // 摄像通道 2 定时拍照开关标志
        private boolean cameraChannelTiming2;
        // 摄像通道 3 定时拍照开关标志
        private boolean cameraChannelTiming3;
        // 摄像通道 4 定时拍照开关标志
        private boolean cameraChannelTiming4;
        // 摄像通道 5 定时拍照开关标志
        private boolean cameraChannelTiming5;
        // 摄像通道 1 定时拍照存储标志
        private boolean cameraChannelTimingSave1;
        // 摄像通道 2 定时拍照存储标志
        private boolean cameraChannelTimingSave2;
        // 摄像通道 3 定时拍照存储标志
        private boolean cameraChannelTimingSave3;
        // 摄像通道 4 定时拍照存储标志
        private boolean cameraChannelTimingSave4;
        // 摄像通道 5 定时拍照存储标志
        private boolean cameraChannelTimingSave5;
        // 定时时间单位
        private boolean TimingUnit;
        // 定时时间间隔
        private Integer TimingInterval;

        public boolean isCameraChannelTiming1() {
            return cameraChannelTiming1;
        }

        public void setCameraChannelTiming1(boolean cameraChannelTiming1) {
            this.cameraChannelTiming1 = cameraChannelTiming1;
        }

        public boolean isCameraChannelTiming2() {
            return cameraChannelTiming2;
        }

        public void setCameraChannelTiming2(boolean cameraChannelTiming2) {
            this.cameraChannelTiming2 = cameraChannelTiming2;
        }

        public boolean isCameraChannelTiming3() {
            return cameraChannelTiming3;
        }

        public void setCameraChannelTiming3(boolean cameraChannelTiming3) {
            this.cameraChannelTiming3 = cameraChannelTiming3;
        }

        public boolean isCameraChannelTiming4() {
            return cameraChannelTiming4;
        }

        public void setCameraChannelTiming4(boolean cameraChannelTiming4) {
            this.cameraChannelTiming4 = cameraChannelTiming4;
        }

        public boolean isCameraChannelTiming5() {
            return cameraChannelTiming5;
        }

        public void setCameraChannelTiming5(boolean cameraChannelTiming5) {
            this.cameraChannelTiming5 = cameraChannelTiming5;
        }

        public boolean isCameraChannelTimingSave1() {
            return cameraChannelTimingSave1;
        }

        public void setCameraChannelTimingSave1(boolean cameraChannelTimingSave1) {
            this.cameraChannelTimingSave1 = cameraChannelTimingSave1;
        }

        public boolean isCameraChannelTimingSave2() {
            return cameraChannelTimingSave2;
        }

        public void setCameraChannelTimingSave2(boolean cameraChannelTimingSave2) {
            this.cameraChannelTimingSave2 = cameraChannelTimingSave2;
        }

        public boolean isCameraChannelTimingSave3() {
            return cameraChannelTimingSave3;
        }

        public void setCameraChannelTimingSave3(boolean cameraChannelTimingSave3) {
            this.cameraChannelTimingSave3 = cameraChannelTimingSave3;
        }

        public boolean isCameraChannelTimingSave4() {
            return cameraChannelTimingSave4;
        }

        public void setCameraChannelTimingSave4(boolean cameraChannelTimingSave4) {
            this.cameraChannelTimingSave4 = cameraChannelTimingSave4;
        }

        public boolean isCameraChannelTimingSave5() {
            return cameraChannelTimingSave5;
        }

        public void setCameraChannelTimingSave5(boolean cameraChannelTimingSave5) {
            this.cameraChannelTimingSave5 = cameraChannelTimingSave5;
        }

        public boolean isTimingUnit() {
            return TimingUnit;
        }

        public void setTimingUnit(boolean timingUnit) {
            TimingUnit = timingUnit;
        }

        public Integer getTimingInterval() {
            return TimingInterval;
        }

        public void setTimingInterval(Integer timingInterval) {
            TimingInterval = timingInterval;
        }

    // }

    // public static class FixedPictureControlBit {
        // 摄像通道 1 定拍照开关标志
        private boolean cameraChannelFixed1;
        // 摄像通道 2 定距拍照开关标志
        private boolean cameraChannelFixed2;
        // 摄像通道 3 定距拍照开关标志
        private boolean cameraChannelFixed3;
        // 摄像通道 4 定距拍照开关标志
        private boolean cameraChannelFixed4;
        // 摄像通道 5 定距拍照开关标志
        private boolean cameraChannelFixed5;
        // 摄像通道 1 定距拍照存储标志
        private boolean cameraChannelFixedSave1;
        // 摄像通道 2 定距拍照存储标志
        private boolean cameraChannelFixedSave2;
        // 摄像通道 3 定距拍照存储标志
        private boolean cameraChannelFixedSave3;
        // 摄像通道 4 定距拍照存储标志
        private boolean cameraChannelFixedSave4;
        // 摄像通道 5 定距拍照存储标志
        private boolean cameraChannelFixedSave5;
        // 定距距离单位
        private boolean FixedUnit;
        // 定距距离间隔
        private Integer FixedInterval;

        public boolean isCameraChannelFixed1() {
            return cameraChannelFixed1;
        }

        public void setCameraChannelFixed1(boolean cameraChannelFixed1) {
            this.cameraChannelFixed1 = cameraChannelFixed1;
        }

        public boolean isCameraChannelFixed2() {
            return cameraChannelFixed2;
        }

        public void setCameraChannelFixed2(boolean cameraChannelFixed2) {
            this.cameraChannelFixed2 = cameraChannelFixed2;
        }

        public boolean isCameraChannelFixed3() {
            return cameraChannelFixed3;
        }

        public void setCameraChannelFixed3(boolean cameraChannelFixed3) {
            this.cameraChannelFixed3 = cameraChannelFixed3;
        }

        public boolean isCameraChannelFixed4() {
            return cameraChannelFixed4;
        }

        public void setCameraChannelFixed4(boolean cameraChannelFixed4) {
            this.cameraChannelFixed4 = cameraChannelFixed4;
        }

        public boolean isCameraChannelFixed5() {
            return cameraChannelFixed5;
        }

        public void setCameraChannelFixed5(boolean cameraChannelFixed5) {
            this.cameraChannelFixed5 = cameraChannelFixed5;
        }

        public boolean isCameraChannelFixedSave1() {
            return cameraChannelFixedSave1;
        }

        public void setCameraChannelFixedSave1(boolean cameraChannelFixedSave1) {
            this.cameraChannelFixedSave1 = cameraChannelFixedSave1;
        }

        public boolean isCameraChannelFixedSave2() {
            return cameraChannelFixedSave2;
        }

        public void setCameraChannelFixedSave2(boolean cameraChannelFixedSave2) {
            this.cameraChannelFixedSave2 = cameraChannelFixedSave2;
        }

        public boolean isCameraChannelFixedSave3() {
            return cameraChannelFixedSave3;
        }

        public void setCameraChannelFixedSave3(boolean cameraChannelFixedSave3) {
            this.cameraChannelFixedSave3 = cameraChannelFixedSave3;
        }

        public boolean isCameraChannelFixedSave4() {
            return cameraChannelFixedSave4;
        }

        public void setCameraChannelFixedSave4(boolean cameraChannelFixedSave4) {
            this.cameraChannelFixedSave4 = cameraChannelFixedSave4;
        }

        public boolean isCameraChannelFixedSave5() {
            return cameraChannelFixedSave5;
        }

        public void setCameraChannelFixedSave5(boolean cameraChannelFixedSave5) {
            this.cameraChannelFixedSave5 = cameraChannelFixedSave5;
        }

        public boolean isFixedUnit() {
            return FixedUnit;
        }

        public void setFixedUnit(boolean fixedUnit) {
            FixedUnit = fixedUnit;
        }

        public Integer getFixedInterval() {
            return FixedInterval;
        }

        public void setFixedInterval(Integer fixedInterval) {
            FixedInterval = fixedInterval;
        }

    // }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0001)
    public Integer getBeatInterval() {
        return beatInterval;
    }

    public void setBeatInterval(Integer beatInterval) {
        this.beatInterval = beatInterval;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0002)
    public Integer getTCPTimeout() {
        return TCPTimeout;
    }

    public void setTCPTimeout(Integer TCPTimeout) {
        this.TCPTimeout = TCPTimeout;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0003)
    public Integer getTCPretransTimes() {
        return TCPretransTimes;
    }

    public void setTCPretransTimes(Integer TCPretransTimes) {
        this.TCPretransTimes = TCPretransTimes;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0004)
    public Integer getUDPTimeout() {
        return UDPTimeout;
    }

    public void setUDPTimeout(Integer UDPTimeout) {
        this.UDPTimeout = UDPTimeout;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0005)
    public Integer getUDPretransTimes() {
        return UDPretransTimes;
    }

    public void setUDPretransTimes(Integer UDPretransTimes) {
        this.UDPretransTimes = UDPretransTimes;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0006)
    public Integer getSMSTimeout() {
        return SMSTimeout;
    }

    public void setSMSTimeout(Integer SMSTimeout) {
        this.SMSTimeout = SMSTimeout;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0007)
    public Integer getSMSretransTimes() {
        return SMSretransTimes;
    }

    public void setSMSretransTimes(Integer SMSretransTimes) {
        this.SMSretransTimes = SMSretransTimes;
    }

    @Property(index = 3, type = DataType.STRING, lengthName = "paramLength", enumType = 0x0010)
    public String getMainServerAPN() {
        return mainServerAPN;
    }

    public void setMainServerAPN(String mainServerAPN) {
        this.mainServerAPN = mainServerAPN;
    }

    @Property(index = 3, type = DataType.STRING, lengthName = "paramLength", enumType = 0x0011)
    public String getMainServerUsername() {
        return mainServerUsername;
    }

    public void setMainServerUsername(String mainServerUsername) {
        this.mainServerUsername = mainServerUsername;
    }

    @Property(index = 3, type = DataType.STRING, lengthName = "paramLength", enumType = 0x0012)
    public String getMainServerPassword() {
        return mainServerPassword;
    }

    public void setMainServerPassword(String mainServerPassword) {
        this.mainServerPassword = mainServerPassword;
    }

    @Property(index = 3, type = DataType.STRING, lengthName = "paramLength", enumType = 0x0013)
    public String getMainServerHost() {
        return mainServerHost;
    }

    public void setMainServerHost(String mainServerHost) {
        this.mainServerHost = mainServerHost;
    }

    @Property(index = 3, type = DataType.STRING, lengthName = "paramLength", enumType = 0x0014)
    public String getBackupServerAPN() {
        return backupServerAPN;
    }

    public void setBackupServerAPN(String backupServerAPN) {
        this.backupServerAPN = backupServerAPN;
    }

    @Property(index = 3, type = DataType.STRING, lengthName = "paramLength", enumType = 0x0015)
    public String getBackupServerUsername() {
        return backupServerUsername;
    }

    public void setBackupServerUsername(String backupServerUsername) {
        this.backupServerUsername = backupServerUsername;
    }

    @Property(index = 3, type = DataType.STRING, lengthName = "paramLength", enumType = 0x0016)
    public String getBackupServerPassword() {
        return backupServerPassword;
    }

    public void setBackupServerPassword(String backupServerPassword) {
        this.backupServerPassword = backupServerPassword;
    }

    @Property(index = 3, type = DataType.STRING, lengthName = "paramLength", enumType = 0x0017)
    public String getBackupServerHost() {
        return backupServerHost;
    }

    public void setBackupServerHost(String backupServerHost) {
        this.backupServerHost = backupServerHost;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0018)
    public Integer getServerTCPport() {
        return serverTCPport;
    }

    public void setServerTCPport(Integer serverTCPport) {
        this.serverTCPport = serverTCPport;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0019)
    public Integer getServerUDPport() {
        return serverUDPport;
    }

    public void setServerUDPport(Integer serverUDPport) {
        this.serverUDPport = serverUDPport;
    }

    @Property(index = 3, type = DataType.STRING, lengthName = "paramLength", enumType = 0x001A)
    public String getICverifyMainServerHost() {
        return ICverifyMainServerHost;
    }

    public void setICverifyMainServerHost(String ICverifyMainServerHost) {
        this.ICverifyMainServerHost = ICverifyMainServerHost;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x001B)
    public Integer getICverifyServerTCPport() {
        return ICverifyServerTCPport;
    }

    public void setICverifyServerTCPport(Integer ICverifyServerTCPport) {
        this.ICverifyServerTCPport = ICverifyServerTCPport;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x001C)
    public Integer getICverifyServerUDPport() {
        return ICverifyServerUDPport;
    }

    public void setICverifyServerUDPport(Integer ICverifyServerUDPport) {
        this.ICverifyServerUDPport = ICverifyServerUDPport;
    }

    @Property(index = 3, type = DataType.STRING, lengthName = "paramLength", enumType = 0x001D)
    public String getICVerifyBackupServerHost() {
        return ICVerifyBackupServerHost;
    }

    public void setICVerifyBackupServerHost(String ICVerifyBackupServerHost) {
        this.ICVerifyBackupServerHost = ICVerifyBackupServerHost;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0020)
    public Integer getLocationInfoStrategy() {
        return locationInfoStrategy;
    }

    public void setLocationInfoStrategy(Integer locationInfoStrategy) {
        this.locationInfoStrategy = locationInfoStrategy;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0021)
    public Integer getLocationInfoPlan() {
        return locationInfoPlan;
    }

    public void setLocationInfoPlan(Integer locationInfoPlan) {
        this.locationInfoPlan = locationInfoPlan;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0022)
    public Integer getUnloginTimeInterval() {
        return unloginTimeInterval;
    }

    public void setUnloginTimeInterval(Integer unloginTimeInterval) {
        this.unloginTimeInterval = unloginTimeInterval;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0027)
    public Integer getSleepTimeInterval() {
        return sleepTimeInterval;
    }

    public void setSleepTimeInterval(Integer sleepTimeInterval) {
        this.sleepTimeInterval = sleepTimeInterval;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0028)
    public Integer getWarningTimeInterval() {
        return warningTimeInterval;
    }

    public void setWarningTimeInterval(Integer warningTimeInterval) {
        this.warningTimeInterval = warningTimeInterval;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0029)
    public Integer getDefaultInterval() {
        return defaultInterval;
    }

    public void setDefaultInterval(Integer defaultInterval) {
        this.defaultInterval = defaultInterval;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x002C)
    public Integer getDefaultDistanceInterval() {
        return defaultDistanceInterval;
    }

    public void setDefaultDistanceInterval(Integer defaultDistanceInterval) {
        this.defaultDistanceInterval = defaultDistanceInterval;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x002D)
    public Integer getUnloginDistanceInterval() {
        return unloginDistanceInterval;
    }

    public void setUnloginDistanceInterval(Integer unloginDistanceInterval) {
        this.unloginDistanceInterval = unloginDistanceInterval;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x002E)
    public Integer getSleepDistanceInterval() {
        return sleepDistanceInterval;
    }

    public void setSleepDistanceInterval(Integer sleepDistanceInterval) {
        this.sleepDistanceInterval = sleepDistanceInterval;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x002F)
    public Integer getWarningDistanceInterval() {
        return warningDistanceInterval;
    }

    public void setWarningDistanceInterval(Integer warningDistanceInterval) {
        this.warningDistanceInterval = warningDistanceInterval;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0030)
    public Integer getRetransmissionAngle() {
        return retransmissionAngle;
    }

    public void setRetransmissionAngle(Integer retransmissionAngle) {
        this.retransmissionAngle = retransmissionAngle;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0031)
    public Integer getElectronicFenceRadius() {
        return electronicFenceRadius;
    }

    public void setElectronicFenceRadius(Integer electronicFenceRadius) {
        this.electronicFenceRadius = electronicFenceRadius;
    }

    @Property(index = 3, type = DataType.STRING, lengthName = "paramLength", enumType = 0x0040)
    public String getPlatformPhoneNum() {
        return platformPhoneNum;
    }

    public void setPlatformPhoneNum(String platformPhoneNum) {
        this.platformPhoneNum = platformPhoneNum;
    }

    @Property(index = 3, type = DataType.STRING, lengthName = "paramLength", enumType = 0x0041)
    public String getResetPhoneNum() {
        return resetPhoneNum;
    }

    public void setResetPhoneNum(String resetPhoneNum) {
        this.resetPhoneNum = resetPhoneNum;
    }

    @Property(index = 3, type = DataType.STRING, lengthName = "paramLength", enumType = 0x0042)
    public String getRestorePhoneNum() {
        return restorePhoneNum;
    }

    public void setRestorePhoneNum(String restorePhoneNum) {
        this.restorePhoneNum = restorePhoneNum;
    }

    @Property(index = 3, type = DataType.STRING, lengthName = "paramLength", enumType = 0x0043)
    public String getPlatformSMSphoneNum() {
        return platformSMSphoneNum;
    }

    public void setPlatformSMSphoneNum(String platformSMSphoneNum) {
        this.platformSMSphoneNum = platformSMSphoneNum;
    }

    @Property(index = 3, type = DataType.STRING, lengthName = "paramLength", enumType = 0x0044)
    public String getAlarmSMSphoneNum() {
        return alarmSMSphoneNum;
    }

    public void setAlarmSMSphoneNum(String alarmSMSphoneNum) {
        this.alarmSMSphoneNum = alarmSMSphoneNum;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0045)
    public Integer getPhoneStrategy() {
        return phoneStrategy;
    }

    public void setPhoneStrategy(Integer phoneStrategy) {
        this.phoneStrategy = phoneStrategy;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0046)
    public Integer getLongestPhoneTime() {
        return longestPhoneTime;
    }

    public void setLongestPhoneTime(Integer longestPhoneTime) {
        this.longestPhoneTime = longestPhoneTime;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0047)
    public Integer getMonthLongestPhoneTime() {
        return monthLongestPhoneTime;
    }

    public void setMonthLongestPhoneTime(Integer monthLongestPhoneTime) {
        this.monthLongestPhoneTime = monthLongestPhoneTime;
    }

    @Property(index = 3, type = DataType.STRING, lengthName = "paramLength", enumType = 0x0048)
    public String getMonitorPhone() {
        return monitorPhone;
    }

    public void setMonitorPhone(String monitorPhone) {
        this.monitorPhone = monitorPhone;
    }

    @Property(index = 3, type = DataType.STRING, lengthName = "paramLength", enumType = 0x0049)
    public String getPlatformPrivilegeSMS() {
        return platformPrivilegeSMS;
    }

    public void setPlatformPrivilegeSMS(String platformPrivilegeSMS) {
        this.platformPrivilegeSMS = platformPrivilegeSMS;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0050)
    public Integer getAlarmShieldingWord() {
        return alarmShieldingWord;
    }

    public void setAlarmShieldingWord(Integer alarmShieldingWord) {
        this.alarmShieldingWord = alarmShieldingWord;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0051)
    public Integer getAlarmSMS() {
        return alarmSMS;
    }

    public void setAlarmSMS(Integer alarmSMS) {
        this.alarmSMS = alarmSMS;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0052)
    public Integer getAlarmPhoto() {
        return alarmPhoto;
    }

    public void setAlarmPhoto(Integer alarmPhoto) {
        this.alarmPhoto = alarmPhoto;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0053)
    public Integer getAlarmPhotoSave() {
        return alarmPhotoSave;
    }

    public void setAlarmPhotoSave(Integer alarmPhotoSave) {
        this.alarmPhotoSave = alarmPhotoSave;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0054)
    public Integer getKeyFlag() {
        return keyFlag;
    }

    public void setKeyFlag(Integer keyFlag) {
        this.keyFlag = keyFlag;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0055)
    public Integer getHighestSpeed() {
        return highestSpeed;
    }

    public void setHighestSpeed(Integer highestSpeed) {
        this.highestSpeed = highestSpeed;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0056)
    public Integer getSpeedingTime() {
        return speedingTime;
    }

    public void setSpeedingTime(Integer speedingTime) {
        this.speedingTime = speedingTime;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0057)
    public Integer getDriverTimeLimit() {
        return driverTimeLimit;
    }

    public void setDriverTimeLimit(Integer driverTimeLimit) {
        this.driverTimeLimit = driverTimeLimit;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0058)
    public Integer getTodayDriverTime() {
        return todayDriverTime;
    }

    public void setTodayDriverTime(Integer todayDriverTime) {
        this.todayDriverTime = todayDriverTime;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0059)
    public Integer getLeastRestTime() {
        return leastRestTime;
    }

    public void setLeastRestTime(Integer leastRestTime) {
        this.leastRestTime = leastRestTime;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x005A)
    public Integer getLongestPortTime() {
        return longestPortTime;
    }

    public void setLongestPortTime(Integer longestPortTime) {
        this.longestPortTime = longestPortTime;
    }

    @Property(index = 3, type = DataType.WORD, enumType = 0x005B)
    public Integer getSpeedingWarningDifferenceValue() {
        return speedingWarningDifferenceValue;
    }

    public void setSpeedingWarningDifferenceValue(Integer speedingWarningDifferenceValue) {
        this.speedingWarningDifferenceValue = speedingWarningDifferenceValue;
    }

    @Property(index = 3, type = DataType.WORD, enumType = 0x005C)
    public Integer getTiredDriveWarningDifferenceValue() {
        return tiredDriveWarningDifferenceValue;
    }

    public void setTiredDriveWarningDifferenceValue(Integer tiredDriveWarningDifferenceValue) {
        this.tiredDriveWarningDifferenceValue = tiredDriveWarningDifferenceValue;
    }

    @Property(index = 3, type = DataType.WORD, enumType = 0x005D)
    public Integer getCollisionParam() {
        return collisionParam;
    }

    public void setCollisionParam(Integer collisionParam) {
        this.collisionParam = collisionParam;
    }

    @Property(index = 3, type = DataType.WORD, enumType = 0x005E)
    public Integer getRolloverParam() {
        return rolloverParam;
    }

    public void setRolloverParam(Integer rolloverParam) {
        this.rolloverParam = rolloverParam;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0064)
    public Integer getTimingPhotoControlBit() {
        return timingPhotoControlBit;
    }

    public void setTimingPhotoControlBit(Integer timingPhotoControlBit) {
        this.timingPhotoControlBit = timingPhotoControlBit;
        // 摄像通道 1 定时拍照开关标志
        this.cameraChannelTiming1 = ((timingPhotoControlBit >>> 31) & 0x01) == 1;
        // 摄像通道 2 定时拍照开关标志
        this.cameraChannelTiming2 = ((timingPhotoControlBit >>> 30) & 0x01) == 1;
        // 摄像通道 3 定时拍照开关标志
        this.cameraChannelTiming3 = ((timingPhotoControlBit >>> 29) & 0x01) == 1;
        // 摄像通道 4 定时拍照开关标志
        this.cameraChannelTiming4 = ((timingPhotoControlBit >>> 28) & 0x01) == 1;
        // 摄像通道 5 定时拍照开关标志
        this.cameraChannelTiming5 = ((timingPhotoControlBit >>> 27) & 0x01) == 1;
        // 摄像通道 1 定时拍照存储标志
        this.cameraChannelTimingSave1  = ((timingPhotoControlBit >>> 23) & 0x01) == 1;
        // 摄像通道 2 定时拍照存储标志
        this.cameraChannelTimingSave2 = ((timingPhotoControlBit >>> 22) & 0x01) == 1;
        // 摄像通道 3 定时拍照存储标志
        this.cameraChannelTimingSave3 = ((timingPhotoControlBit >>> 21) & 0x01) == 1;
        // 摄像通道 4 定时拍照存储标志
        this.cameraChannelTimingSave4 = ((timingPhotoControlBit >>> 20) & 0x01) == 1;
        // 摄像通道 5 定时拍照存储标志
        this.cameraChannelTimingSave5 = ((timingPhotoControlBit >>> 19) & 0x01) == 1;
        // 定时时间单位
        this.TimingUnit = ((timingPhotoControlBit >>> 15) & 0x01) == 1;
        // 定时时间间隔
        this.TimingInterval = timingPhotoControlBit & 0x007f;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0065)
    public Integer getFixedPictureControlBit() {
        return fixedPictureControlBit;
    }

    public void setFixedPictureControlBit(Integer fixedPictureControlBit) {
        this.fixedPictureControlBit = fixedPictureControlBit;

        // 摄像通道 1 定时拍照开关标志
        this.cameraChannelFixed1 = ((fixedPictureControlBit >>> 31) & 0x01) == 1;
        // 摄像通道 2 定时拍照开关标志
        this.cameraChannelFixed2 = ((fixedPictureControlBit >>> 30) & 0x01) == 1;
        // 摄像通道 3 定时拍照开关标志
        this.cameraChannelFixed3 = ((fixedPictureControlBit >>> 29) & 0x01) == 1;
        // 摄像通道 4 定时拍照开关标志
        this.cameraChannelFixed4 = ((fixedPictureControlBit >>> 28) & 0x01) == 1;
        // 摄像通道 5 定时拍照开关标志
        this.cameraChannelFixed5 = ((fixedPictureControlBit >>> 27) & 0x01) == 1;
        // 摄像通道 1 定时拍照存储标志
        this.cameraChannelFixedSave1  = ((fixedPictureControlBit >>> 23) & 0x01) == 1;
        // 摄像通道 2 定时拍照存储标志
        this.cameraChannelFixedSave2 = ((fixedPictureControlBit >>> 22) & 0x01) == 1;
        // 摄像通道 3 定时拍照存储标志
        this.cameraChannelFixedSave3 = ((fixedPictureControlBit >>> 21) & 0x01) == 1;
        // 摄像通道 4 定时拍照存储标志
        this.cameraChannelFixedSave4 = ((fixedPictureControlBit >>> 20) & 0x01) == 1;
        // 摄像通道 5 定时拍照存储标志
        this.cameraChannelFixedSave5 = ((fixedPictureControlBit >>> 19) & 0x01) == 1;
        // 定时时间单位
        this.FixedUnit = ((fixedPictureControlBit >>> 15) & 0x01) == 1;
        // 定距距离间隔
        this.FixedInterval = fixedPictureControlBit & 0x007f;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0070)
    public Integer getCameraQuality() {
        return cameraQuality;
    }

    public void setCameraQuality(Integer cameraQuality) {
        this.cameraQuality = cameraQuality;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0071)
    public Integer getLight() {
        return light;
    }

    public void setLight(Integer light) {
        this.light = light;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0072)
    public Integer getContrast() {
        return contrast;
    }

    public void setContrast(Integer contrast) {
        this.contrast = contrast;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0073)
    public Integer getSaturation() {
        return saturation;
    }

    public void setSaturation(Integer saturation) {
        this.saturation = saturation;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0074)
    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0080)
    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    @Property(index = 3, type = DataType.WORD, enumType = 0x0081)
    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    @Property(index = 3, type = DataType.WORD, enumType = 0x0082)
    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @Property(index = 3, type = DataType.STRING, lengthName = "paramLength", enumType = 0x0083)
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Property(index = 3, type = DataType.BYTE, enumType = 0x0084)
    public Integer getLicensePlateColor() {
        return licensePlateColor;
    }

    public void setLicensePlateColor(Integer licensePlateColor) {
        this.licensePlateColor = licensePlateColor;
    }

    @Property(index = 3, type = DataType.BYTE, lengthName = "paramLength", enumType = 0x0090)
    public Integer getGnss() {
        return gnss;
    }

    public void setGnss(Integer gnss) {
        this.gnss = gnss;

        // 0:未使用 GPS 卫星进行定位;1:使用 GPS 卫星进行定位
        this.GPS = ((gnss >>> 7) & 0x01) == 1;
        // 0:未使用北斗卫星进行定位;1:使用北斗卫星进行定位
        this.beidou = ((gnss >>> 6) & 0x01) == 1;
        // 0:未使用 GLONASS 卫星进行定位;1:使用 GLONASS 卫星进行定位
        this.GLONASS = ((gnss >>> 5) & 0x01) == 1;
        // 0:未使用 Galileo 卫星进行定位;1:使用 Galileo 卫星进行定位
        this.Galileo = ((gnss >>> 4) & 0x01) == 1;
    }

    @Property(index = 3, type = DataType.BYTE, enumType = 0x0091)
    public Integer getGNSSbaudRatio() {
        return GNSSbaudRatio;
    }

    public void setGNSSbaudRatio(Integer GNSSbaudRatio) {
        this.GNSSbaudRatio = GNSSbaudRatio;
    }

    @Property(index = 3, type = DataType.BYTE, enumType = 0x0092)
    public Integer getGNSSdataOutputFrequency() {
        return GNSSdataOutputFrequency;
    }

    public void setGNSSdataOutputFrequency(Integer GNSSdataOutputFrequency) {
        this.GNSSdataOutputFrequency = GNSSdataOutputFrequency;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0093)
    public Integer getGNSSdataFrequency() {
        return GNSSdataFrequency;
    }

    public void setGNSSdataFrequency(Integer GNSSdataFrequency) {
        this.GNSSdataFrequency = GNSSdataFrequency;
    }

    @Property(index = 3, type = DataType.BYTE, enumType = 0x0094)
    public Integer getLocationUploadType() {
        return locationUploadType;
    }

    public void setLocationUploadType(Integer locationUploadType) {
        this.locationUploadType = locationUploadType;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0095)
    public Integer getLocationUploadSetting() {
        return locationUploadSetting;
    }

    public void setLocationUploadSetting(Integer locationUploadSetting) {
        this.locationUploadSetting = locationUploadSetting;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0100)
    public Integer getCAN1CatchTimeInterval() {
        return CAN1CatchTimeInterval;
    }

    public void setCAN1CatchTimeInterval(Integer CAN1CatchTimeInterval) {
        this.CAN1CatchTimeInterval = CAN1CatchTimeInterval;
    }

    @Property(index = 3, type = DataType.WORD, enumType = 0x0101)
    public Integer getCAN1UploadTimeInterval() {
        return CAN1UploadTimeInterval;
    }

    public void setCAN1UploadTimeInterval(Integer CAN1UploadTimeInterval) {
        this.CAN1UploadTimeInterval = CAN1UploadTimeInterval;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x0102)
    public Integer getCAN2CatchTimeInterval() {
        return CAN2CatchTimeInterval;
    }

    public void setCAN2CatchTimeInterval(Integer CAN2CatchTimeInterval) {
        this.CAN2CatchTimeInterval = CAN2CatchTimeInterval;
    }

    @Property(index = 3, type = DataType.WORD, enumType = 0x0103)
    public Integer getCAN2UploadTimeInterval() {
        return CAN2UploadTimeInterval;
    }

    public void setCAN2UploadTimeInterval(Integer CAN2UploadTimeInterval) {
        this.CAN2UploadTimeInterval = CAN2UploadTimeInterval;
    }

    @Property(index = 3, type = DataType.LONG, enumType = 0x0103)
    public Long getCANIDParam() {
        return CANIDParam;
    }

    public void setCANIDParam(Long CANIDParam) {
        this.CANIDParam = CANIDParam;
    }

    /**
     * 音视频部分
     */
    // 音视频参数设置
    private MediaParam mediaParam;
    // 音视频通道列表设置
    private MediaChannelList mediaChannelList;
    // 单独视频通道参数设置
    private VideoChannelsParam videoChannelsParam;
    // 特殊报警录像参数设置
    private UniqueAlarmVideoParam uniqueAlarmVideoParam;
    // 视频相关报警屏蔽字
    private Integer videoSheildBits;
    // 图像分析报警参数设置
    private PictureAlarmingParam pictureAlarmingParam;
    // 终端休眠唤醒模式设置
    private TerminalWakeUpModel terminalWakeUpModel;

    public static class MediaParam {
        // 实时流编码模式
        private Integer realTimeStreamCode;
        // 实时流分辨率
        private Integer realTimeStreamResovling;
        // 实时流关键帧间隔
        private Integer realTimeKeyFrameInterval;
        // 实时流目标帧率
        private Integer realTimeStreamGoalFrameRate;
        // 实时流目标码率
        private Integer realTimeStreamGoalCodeRate;
        // 存储流编码模式
        private Integer savedStreamCode;
        // 存储流分辨率
        private Integer savedStreamResovling;
        // 存储流关键帧间隔
        private Integer savedKeyFrameInterval;
        // 存储流目标帧率
        private Integer savedStreamGoalFrameRate;
        // 存储流目标码率
        private Integer savedStreamGoalCodeRate;
        // OSD字幕叠加设置
        private Integer OSDSubtitle;
        // 是否启用音频
        private Integer openVoice;

        @Property(index = 0, type = DataType.BYTE)
        public Integer getRealTimeStreamCode() {
            return realTimeStreamCode;
        }

        public void setRealTimeStreamCode(Integer realTimeStreamCode) {
            this.realTimeStreamCode = realTimeStreamCode;
        }

        @Property(index = 1, type = DataType.BYTE)
        public Integer getRealTimeStreamResovling() {
            return realTimeStreamResovling;
        }

        public void setRealTimeStreamResovling(Integer realTimeStreamResovling) {
            this.realTimeStreamResovling = realTimeStreamResovling;
        }

        @Property(index = 2, type = DataType.WORD)
        public Integer getRealTimeKeyFrameInterval() {
            return realTimeKeyFrameInterval;
        }

        public void setRealTimeKeyFrameInterval(Integer realTimeKeyFrameInterval) {
            this.realTimeKeyFrameInterval = realTimeKeyFrameInterval;
        }

        @Property(index = 4, type = DataType.BYTE)
        public Integer getRealTimeStreamGoalFrameRate() {
            return realTimeStreamGoalFrameRate;
        }

        public void setRealTimeStreamGoalFrameRate(Integer realTimeStreamGoalFrameRate) {
            this.realTimeStreamGoalFrameRate = realTimeStreamGoalFrameRate;
        }

        @Property(index = 5, type = DataType.DWORD)
        public Integer getRealTimeStreamGoalCodeRate() {
            return realTimeStreamGoalCodeRate;
        }

        public void setRealTimeStreamGoalCodeRate(Integer realTimeStreamGoalCodeRate) {
            this.realTimeStreamGoalCodeRate = realTimeStreamGoalCodeRate;
        }

        @Property(index = 9, type = DataType.BYTE)
        public Integer getSavedStreamCode() {
            return savedStreamCode;
        }

        public void setSavedStreamCode(Integer savedStreamCode) {
            this.savedStreamCode = savedStreamCode;
        }

        @Property(index = 10, type = DataType.BYTE)
        public Integer getSavedStreamResovling() {
            return savedStreamResovling;
        }

        public void setSavedStreamResovling(Integer savedStreamResovling) {
            this.savedStreamResovling = savedStreamResovling;
        }

        @Property(index = 11, type = DataType.WORD)
        public Integer getSavedKeyFrameInterval() {
            return savedKeyFrameInterval;
        }

        public void setSavedKeyFrameInterval(Integer savedKeyFrameInterval) {
            this.savedKeyFrameInterval = savedKeyFrameInterval;
        }

        @Property(index = 13, type = DataType.BYTE)
        public Integer getSavedStreamGoalFrameRate() {
            return savedStreamGoalFrameRate;
        }

        public void setSavedStreamGoalFrameRate(Integer savedStreamGoalFrameRate) {
            this.savedStreamGoalFrameRate = savedStreamGoalFrameRate;
        }

        @Property(index = 14, type = DataType.DWORD)
        public Integer getSavedStreamGoalCodeRate() {
            return savedStreamGoalCodeRate;
        }

        public void setSavedStreamGoalCodeRate(Integer savedStreamGoalCodeRate) {
            this.savedStreamGoalCodeRate = savedStreamGoalCodeRate;
        }

        @Property(index = 18, type = DataType.WORD)
        public Integer getOSDSubtitle() {
            return OSDSubtitle;
        }

        public void setOSDSubtitle(Integer OSDSubtitle) {
            this.OSDSubtitle = OSDSubtitle;
        }

        @Property(index = 20, type = DataType.BYTE)
        public Integer getOpenVoice() {
            return openVoice;
        }

        public void setOpenVoice(Integer openVoice) {
            this.openVoice = openVoice;
        }
    }

    public static class MediaChannelList {
        // 音视频通道总数
        private Integer mediaChannelNum;
        // 音频通道总数
        private Integer voiceChannelNum;
        // 视频通道总数
        private Integer videoChannelNum;
        // 音视频通道对照表
        private ArrayList<MediaChannel> mediaChannelList;

        public static class MediaChannel {
            // 物理通道号
            private Integer physicalChannelId;
            // 逻辑通道号
            private Integer logicalChannelId;
            // 通道类型
            private Integer channelType;
            // 是否连接云台
            private Integer linkTable;

            @Property(index = 0, type = DataType.BYTE)
            public Integer getPhysicalChannelId() {
                return physicalChannelId;
            }

            public void setPhysicalChannelId(Integer physicalChannelId) {
                this.physicalChannelId = physicalChannelId;
            }

            @Property(index = 1, type = DataType.BYTE)
            public Integer getLogicalChannelId() {
                return logicalChannelId;
            }

            public void setLogicalChannelId(Integer logicalChannelId) {
                this.logicalChannelId = logicalChannelId;
            }

            @Property(index = 2, type = DataType.BYTE)
            public Integer getChannelType() {
                return channelType;
            }

            public void setChannelType(Integer channelType) {
                this.channelType = channelType;
            }

            @Property(index = 3, type = DataType.BYTE)
            public Integer getLinkTable() {
                return linkTable;
            }

            public void setLinkTable(Integer linkTable) {
                this.linkTable = linkTable;
            }
        }

        @Property(index = 0, type = DataType.BYTE)
        public Integer getMediaChannelNum() {
            return mediaChannelNum;
        }

        public void setMediaChannelNum(Integer mediaChannelNum) {
            this.mediaChannelNum = mediaChannelNum;
        }

        @Property(index = 1, type = DataType.BYTE)
        public Integer getVoiceChannelNum() {
            return voiceChannelNum;
        }

        public void setVoiceChannelNum(Integer voiceChannelNum) {
            this.voiceChannelNum = voiceChannelNum;
        }

        @Property(index = 2, type = DataType.BYTE)
        public Integer getVideoChannelNum() {
            return videoChannelNum;
        }

        public void setVideoChannelNum(Integer videoChannelNum) {
            this.videoChannelNum = videoChannelNum;
        }

        @Property(index = 3, type = DataType.LIST)
        public ArrayList<MediaChannel> getMediaChannelList() {
            return mediaChannelList;
        }

        public void setMediaChannelList(ArrayList<MediaChannel> mediaChannelList) {
            this.mediaChannelList = mediaChannelList;
        }
    }

    public static class VideoChannelsParam {
        // 需要单独设置视频参数的通道数量
        private Integer VideoChannelNumber;
        // 单独通道视频参数设置列表
        private ArrayList<VideoChannelParam> VideoChannelParams;

        public static class VideoChannelParam {
            // 逻辑通道号
            private Integer channelId;
            // 实时流编码模式
            private Integer realTimeStreamCode;
            // 实时流分辨率
            private Integer realTimeStreamResovling;
            // 实时流关键帧间隔
            private Integer realTimeKeyFrameInterval;
            // 实时流目标帧率
            private Integer realTimeStreamGoalFrameRate;
            // 实时流目标码率
            private Integer realTimeStreamGoalCodeRate;
            // 存储流编码模式
            private Integer savedStreamCode;
            // 存储流分辨率
            private Integer savedStreamResovling;
            // 存储流关键帧间隔
            private Integer savedKeyFrameInterval;
            // 存储流目标帧率
            private Integer savedStreamGoalFrameRate;
            // 存储流目标码率
            private Integer savedStreamGoalCodeRate;
            // OSD字幕叠加设置
            private Integer OSDSubtitle;

            @Property(index = 0, type = DataType.BYTE)
            public Integer getChannelId() {
                return channelId;
            }

            public void setChannelId(Integer channelId) {
                this.channelId = channelId;
            }

            @Property(index = 1, type = DataType.BYTE)
            public Integer getRealTimeStreamCode() {
                return realTimeStreamCode;
            }

            public void setRealTimeStreamCode(Integer realTimeStreamCode) {
                this.realTimeStreamCode = realTimeStreamCode;
            }

            @Property(index = 2, type = DataType.BYTE)
            public Integer getRealTimeStreamResovling() {
                return realTimeStreamResovling;
            }

            public void setRealTimeStreamResovling(Integer realTimeStreamResovling) {
                this.realTimeStreamResovling = realTimeStreamResovling;
            }

            @Property(index = 3, type = DataType.WORD)
            public Integer getRealTimeKeyFrameInterval() {
                return realTimeKeyFrameInterval;
            }

            public void setRealTimeKeyFrameInterval(Integer realTimeKeyFrameInterval) {
                this.realTimeKeyFrameInterval = realTimeKeyFrameInterval;
            }

            @Property(index = 5, type = DataType.BYTE)
            public Integer getRealTimeStreamGoalFrameRate() {
                return realTimeStreamGoalFrameRate;
            }

            public void setRealTimeStreamGoalFrameRate(Integer realTimeStreamGoalFrameRate) {
                this.realTimeStreamGoalFrameRate = realTimeStreamGoalFrameRate;
            }

            @Property(index = 6, type = DataType.DWORD)
            public Integer getRealTimeStreamGoalCodeRate() {
                return realTimeStreamGoalCodeRate;
            }

            public void setRealTimeStreamGoalCodeRate(Integer realTimeStreamGoalCodeRate) {
                this.realTimeStreamGoalCodeRate = realTimeStreamGoalCodeRate;
            }

            @Property(index = 10, type = DataType.BYTE)
            public Integer getSavedStreamCode() {
                return savedStreamCode;
            }

            public void setSavedStreamCode(Integer savedStreamCode) {
                this.savedStreamCode = savedStreamCode;
            }

            @Property(index = 11, type = DataType.BYTE)
            public Integer getSavedStreamResovling() {
                return savedStreamResovling;
            }

            public void setSavedStreamResovling(Integer savedStreamResovling) {
                this.savedStreamResovling = savedStreamResovling;
            }

            @Property(index = 12, type = DataType.WORD)
            public Integer getSavedKeyFrameInterval() {
                return savedKeyFrameInterval;
            }

            public void setSavedKeyFrameInterval(Integer savedKeyFrameInterval) {
                this.savedKeyFrameInterval = savedKeyFrameInterval;
            }

            @Property(index = 14, type = DataType.BYTE)
            public Integer getSavedStreamGoalFrameRate() {
                return savedStreamGoalFrameRate;
            }

            public void setSavedStreamGoalFrameRate(Integer savedStreamGoalFrameRate) {
                this.savedStreamGoalFrameRate = savedStreamGoalFrameRate;
            }

            @Property(index = 15, type = DataType.DWORD)
            public Integer getSavedStreamGoalCodeRate() {
                return savedStreamGoalCodeRate;
            }

            public void setSavedStreamGoalCodeRate(Integer savedStreamGoalCodeRate) {
                this.savedStreamGoalCodeRate = savedStreamGoalCodeRate;
            }

            @Property(index = 19, type = DataType.BYTE)
            public Integer getOSDSubtitle() {
                return OSDSubtitle;
            }

            public void setOSDSubtitle(Integer OSDSubtitle) {
                this.OSDSubtitle = OSDSubtitle;
            }
        }

        @Property(index = 0, type = DataType.BYTE)
        public Integer getVideoChannelNumber() {
            return VideoChannelNumber;
        }

        public void setVideoChannelNumber(Integer videoChannelNumber) {
            VideoChannelNumber = videoChannelNumber;
        }

        @Property(index = 1, type = DataType.LIST)
        public ArrayList<VideoChannelParam> getVideoChannelParams() {
            return VideoChannelParams;
        }

        public void setVideoChannelParams(ArrayList<VideoChannelParam> videoChannelParams) {
            VideoChannelParams = videoChannelParams;
        }
    }

    public static class UniqueAlarmVideoParam {
        private Integer uniqueAlarmVideoSaveMax;
        private Integer uniqueAlarmVideoGoingTime;
        private Integer uniqueAlarmVideoStartTime;

        @Property(index = 0, type = DataType.BYTE)
        public Integer getUniqueAlarmVideoSaveMax() {
            return uniqueAlarmVideoSaveMax;
        }

        public void setUniqueAlarmVideoSaveMax(Integer uniqueAlarmVideoSaveMax) {
            this.uniqueAlarmVideoSaveMax = uniqueAlarmVideoSaveMax;
        }

        @Property(index = 1, type = DataType.BYTE)
        public Integer getUniqueAlarmVideoGoingTime() {
            return uniqueAlarmVideoGoingTime;
        }

        public void setUniqueAlarmVideoGoingTime(Integer uniqueAlarmVideoGoingTime) {
            this.uniqueAlarmVideoGoingTime = uniqueAlarmVideoGoingTime;
        }

        @Property(index = 2, type = DataType.BYTE)
        public Integer getUniqueAlarmVideoStartTime() {
            return uniqueAlarmVideoStartTime;
        }

        public void setUniqueAlarmVideoStartTime(Integer uniqueAlarmVideoStartTime) {
            this.uniqueAlarmVideoStartTime = uniqueAlarmVideoStartTime;
        }
    }

    public static class PictureAlarmingParam {
        private Integer vehiclePassengerNum;
        private Integer tiredMax;

        @Property(index = 0, type = DataType.BYTE)
        public Integer getVehiclePassengerNum() {
            return vehiclePassengerNum;
        }

        public void setVehiclePassengerNum(Integer vehiclePassengerNum) {
            this.vehiclePassengerNum = vehiclePassengerNum;
        }

        @Property(index = 1, type = DataType.BYTE)
        public Integer getTiredMax() {
            return tiredMax;
        }

        public void setTiredMax(Integer tiredMax) {
            this.tiredMax = tiredMax;
        }
    }

    public static class TerminalWakeUpModel {
        private Integer awakenMode;
        private Integer awakenType;
        private Integer awakenDay;
        private AwakenDayParam awakenDayParam;

        public static class AwakenDayParam {
            private Integer flag;
            private String awakenTime1;
            private String stopTime1;
            private String awakenTime2;
            private String stopTime2;
            private String awakenTime3;
            private String stopTime3;
            private String awakenTime4;
            private String stopTime4;

            @Property(index = 0, type = DataType.BYTE)
            public Integer getFlag() {
                return flag;
            }

            public void setFlag(Integer flag) {
                this.flag = flag;
            }

            @Property(index = 1, type = DataType.BCD8421, length = 2)
            public String getAwakenTime1() {
                return awakenTime1;
            }

            public void setAwakenTime1(String awakenTime1) {
                this.awakenTime1 = awakenTime1;
            }

            @Property(index = 3, type = DataType.BCD8421, length = 2)
            public String getStopTime1() {
                return stopTime1;
            }

            public void setStopTime1(String stopTime1) {
                this.stopTime1 = stopTime1;
            }

            @Property(index = 5, type = DataType.BCD8421, length = 2)
            public String getAwakenTime2() {
                return awakenTime2;
            }

            public void setAwakenTime2(String awakenTime2) {
                this.awakenTime2 = awakenTime2;
            }

            @Property(index = 7, type = DataType.BCD8421, length = 2)
            public String getStopTime2() {
                return stopTime2;
            }

            public void setStopTime2(String stopTime2) {
                this.stopTime2 = stopTime2;
            }

            @Property(index = 9, type = DataType.BCD8421, length = 2)
            public String getAwakenTime3() {
                return awakenTime3;
            }

            public void setAwakenTime3(String awakenTime3) {
                this.awakenTime3 = awakenTime3;
            }

            @Property(index = 11, type = DataType.BCD8421, length = 2)
            public String getStopTime3() {
                return stopTime3;
            }

            public void setStopTime3(String stopTime3) {
                this.stopTime3 = stopTime3;
            }

            @Property(index = 13, type = DataType.BCD8421, length = 2)
            public String getAwakenTime4() {
                return awakenTime4;
            }

            public void setAwakenTime4(String awakenTime4) {
                this.awakenTime4 = awakenTime4;
            }

            @Property(index = 15, type = DataType.BCD8421, length = 2)
            public String getStopTime4() {
                return stopTime4;
            }

            public void setStopTime4(String stopTime4) {
                this.stopTime4 = stopTime4;
            }
        }

        @Property(index = 0, type = DataType.BYTE)
        public Integer getAwakenMode() {
            return awakenMode;
        }

        public void setAwakenMode(Integer awakenMode) {
            this.awakenMode = awakenMode;
        }

        @Property(index = 1, type = DataType.BYTE)
        public Integer getAwakenType() {
            return awakenType;
        }

        public void setAwakenType(Integer awakenType) {
            this.awakenType = awakenType;
        }

        @Property(index = 2, type = DataType.BYTE)
        public Integer getAwakenDay() {
            return awakenDay;
        }

        public void setAwakenDay(Integer awakenDay) {
            this.awakenDay = awakenDay;
        }

        @Property(index = 3, type = DataType.OBJ, length = 17)
        public AwakenDayParam getAwakenDayParam() {
            return awakenDayParam;
        }

        public void setAwakenDayParam(AwakenDayParam awakenDayParam) {
            this.awakenDayParam = awakenDayParam;
        }
    }

    @Property(index = 3, type = DataType.OBJ, lengthName = "paramLength", enumType = 0x0075)
    public MediaParam getMediaParam() {
        return mediaParam;
    }

    public void setMediaParam(MediaParam mediaParam) {
        this.mediaParam = mediaParam;
    }

    @Property(index = 3, type = DataType.OBJ, lengthName = "paramLength", enumType = 0x0076)
    public MediaChannelList getMediaChannelList() {
        return mediaChannelList;
    }

    public void setMediaChannelList(MediaChannelList mediaChannelList) {
        this.mediaChannelList = mediaChannelList;
    }

    @Property(index = 3, type = DataType.OBJ, lengthName = "paramLength", enumType = 0x0077)
    public VideoChannelsParam getVideoChannelsParam() {
        return videoChannelsParam;
    }

    public void setVideoChannelsParam(VideoChannelsParam videoChannelsParam) {
        this.videoChannelsParam = videoChannelsParam;
    }

    @Property(index = 3, type = DataType.OBJ, lengthName = "paramLength", enumType = 0x0079)
    public UniqueAlarmVideoParam getUniqueAlarmVideoParam() {
        return uniqueAlarmVideoParam;
    }

    public void setUniqueAlarmVideoParam(UniqueAlarmVideoParam uniqueAlarmVideoParam) {
        this.uniqueAlarmVideoParam = uniqueAlarmVideoParam;
    }

    @Property(index = 3, type = DataType.DWORD, enumType = 0x007A)
    public Integer getVideoSheildBits() {
        return videoSheildBits;
    }

    public void setVideoSheildBits(Integer videoSheildBits) {
        this.videoSheildBits = videoSheildBits;
    }

    @Property(index = 3, type = DataType.OBJ, lengthName = "paramLength", enumType = 0x007B)
    public PictureAlarmingParam getPictureAlarmingParam() {
        return pictureAlarmingParam;
    }

    public void setPictureAlarmingParam(PictureAlarmingParam pictureAlarmingParam) {
        this.pictureAlarmingParam = pictureAlarmingParam;
    }

    @Property(index = 3, type = DataType.OBJ, lengthName = "paramLength", enumType = 0x007C)
    public TerminalWakeUpModel getTerminalWakeUpModel() {
        return terminalWakeUpModel;
    }

    public void setTerminalWakeUpModel(TerminalWakeUpModel terminalWakeUpModel) {
        this.terminalWakeUpModel = terminalWakeUpModel;
    }

    /**
     * 苏标部分
     */
    // 高级驾驶辅助系统参数
    private AdvancedDrivingAssistance advancedDrivingAssistance;

    // 驾驶员状态监测系统参数
    private DriverConditionMonitoring driverConditionMonitoring;

    // 胎压监测系统报警
    private TirePressureMonitoring tirePressureMonitoring;

    // 盲区监测系统报警
    private BlindAreaMonitoring blindAreaMonitoring;


    public static class AdvancedDrivingAssistance {
        // 报警判断速度阈值
        private Integer alarmSpeedThreshold;
        // 报警提示音量
        private Integer alarmVolume;
        // 主动拍照策略
        private Integer activePhotoStrategy;
        // 主动定时拍照时间间隔
        private Integer activeTimePhotoInterval;
        // 主动定距拍照距离间隔
        private Integer activeDistancePhotoInterval;
        // 单次主动拍照张数
        private Integer activePhotoNum;
        // 单次主动拍照时间间隔
        private Integer activePhotoInterval;
        // 拍照分辨率
        private Integer photoResolution;
        // 视频录制分辨率
        private Integer videoResolution;
        // 报警使能
        private Integer alarmType;
        // 事件使能
        private Integer eventType;
        // 障碍物报警距离阈值
        private Integer barrierAlarmDistanceThreshold;
        // 障碍物报警分级速度阈值
        private Integer barrierAlarmClassificationThreshold;
        // 障碍物报警前后视频录制时间
        private Integer barrierAlarmVideoTime;
        // 障碍物报警拍照张数
        private Integer barrierAlarmPhotoNum;
        // 障碍物报警拍照间隔
        private Integer barrierAlarmPhotoInterval;
        // 频繁变道报警判断时间段
        private Integer frequentChannelChangeAlarmTime;
        // 频繁变道报警判断次数
        private Integer frequentChannelChangeAlarmNum;
        // 频繁变道报警分级速度阈值
        private Integer frequentChannelChangeAlarmSpeedThreshold;
        // 频繁变道报警前后视频录制时间
        private Integer frequentChannelChangeAlarmVideoTime;
        // 频繁变道报警拍照张数
        private Integer frequentChannelChangeAlarmPhotoNum;
        // 频繁变道报警拍照间隔
        private Integer frequentChannelChangeAlarmPhotoInterval;
        // 车道偏离报警分级速度阈值
        private Integer laneDepartureSpeedThreshold;
        // 车道偏离报警前后视频录制时间
        private Integer laneDepartureVideoTime;
        // 车道偏离报警拍照张数
        private Integer laneDeparturePhotoNum;
        // 车道偏离报警拍照间隔
        private Integer laneDeparturePhotoInterval;
        // 前向碰撞报警时间阈值
        private Integer forwardCollisionTimeThreshold;
        // 前向碰撞报警速度阈值
        private Integer forwardCollisionSpeedThreshold;
        // 前向碰撞报警前后视频录制时间
        private Integer forwardCollisionVideoTime;
        // 前向碰撞报警拍照张数
        private Integer forwardCollisionPhotoNum;
        // 前向碰撞报警拍照间隔
        private Integer forwardCollisionPhotoInterval;
        // 行人碰撞报警时间阈值
        private Integer pedestrianCollisionTimeThreshold;
        // 行人碰撞报警速度阈值
        private Integer pedestrianCollisionSpeedThreshold;
        // 行人碰撞报警前后视频录制时间
        private Integer pedestrianCollisionVideoTime;
        // 行人碰撞报警拍照张数
        private Integer pedestrianCollisionPhotoNum;
        // 行人碰撞报警拍照间隔
        private Integer pedestrianCollisionPhotoInterval;
        // 车距监控报警距离阈值
        private Integer vehicleDistanceSpeedThreshold;
        // 车距监控报警分级速度阈值
        private Integer vehicleDistanceClassificationThreshold;
        // 车距监控报警分级速度阈值
        private Integer vehicleDistanceVideoTime;
        // 车距过近报警拍照张数
        private Integer vehicleDistancePhotoNum;
        // 车距过近报警拍照间隔
        private Integer vehicleDistancePhotoInterval;
        // 道路标志识别拍照张数
        private Integer roadSignRecognitionPhotoNum;
        // 道路标志识别拍照间隔
        private Integer roadSignRecognitionPhotoInterval;

        @Property(index = 0, type = DataType.BYTE)
        public Integer getAlarmSpeedThreshold() {
            return alarmSpeedThreshold;
        }

        public void setAlarmSpeedThreshold(Integer alarmSpeedThreshold) {
            this.alarmSpeedThreshold = alarmSpeedThreshold;
        }

        @Property(index = 1, type = DataType.BYTE)
        public Integer getAlarmVolume() {
            return alarmVolume;
        }

        public void setAlarmVolume(Integer alarmVolume) {
            this.alarmVolume = alarmVolume;
        }

        @Property(index = 2, type = DataType.BYTE)
        public Integer getActivePhotoStrategy() {
            return activePhotoStrategy;
        }

        public void setActivePhotoStrategy(Integer activePhotoStrategy) {
            this.activePhotoStrategy = activePhotoStrategy;
        }

        @Property(index = 3, type = DataType.WORD)
        public Integer getActiveTimePhotoInterval() {
            return activeTimePhotoInterval;
        }

        public void setActiveTimePhotoInterval(Integer activeTimePhotoInterval) {
            this.activeTimePhotoInterval = activeTimePhotoInterval;
        }

        @Property(index = 5, type = DataType.WORD)
        public Integer getActiveDistancePhotoInterval() {
            return activeDistancePhotoInterval;
        }

        public void setActiveDistancePhotoInterval(Integer activeDistancePhotoInterval) {
            this.activeDistancePhotoInterval = activeDistancePhotoInterval;
        }

        @Property(index = 7, type = DataType.BYTE)
        public Integer getActivePhotoNum() {
            return activePhotoNum;
        }

        public void setActivePhotoNum(Integer activePhotoNum) {
            this.activePhotoNum = activePhotoNum;
        }

        @Property(index = 8, type = DataType.BYTE)
        public Integer getActivePhotoInterval() {
            return activePhotoInterval;
        }

        public void setActivePhotoInterval(Integer activePhotoInterval) {
            this.activePhotoInterval = activePhotoInterval;
        }

        @Property(index = 9, type = DataType.BYTE)
        public Integer getPhotoResolution() {
            return photoResolution;
        }

        public void setPhotoResolution(Integer photoResolution) {
            this.photoResolution = photoResolution;
        }

        @Property(index = 10, type = DataType.BYTE)
        public Integer getVideoResolution() {
            return videoResolution;
        }

        public void setVideoResolution(Integer videoResolution) {
            this.videoResolution = videoResolution;
        }

        @Property(index = 11, type = DataType.DWORD)
        public Integer getAlarmType() {
            return alarmType;
        }

        public void setAlarmType(Integer alarmType) {
            this.alarmType = alarmType;
        }

        @Property(index = 15, type = DataType.DWORD)
        public Integer getEventType() {
            return eventType;
        }

        public void setEventType(Integer eventType) {
            this.eventType = eventType;
        }

        @Property(index = 20, type = DataType.BYTE)
        public Integer getBarrierAlarmDistanceThreshold() {
            return barrierAlarmDistanceThreshold;
        }

        public void setBarrierAlarmDistanceThreshold(Integer barrierAlarmDistanceThreshold) {
            this.barrierAlarmDistanceThreshold = barrierAlarmDistanceThreshold;
        }

        @Property(index = 21, type = DataType.BYTE)
        public Integer getBarrierAlarmClassificationThreshold() {
            return barrierAlarmClassificationThreshold;
        }

        public void setBarrierAlarmClassificationThreshold(Integer barrierAlarmClassificationThreshold) {
            this.barrierAlarmClassificationThreshold = barrierAlarmClassificationThreshold;
        }

        @Property(index = 22, type = DataType.BYTE)
        public Integer getBarrierAlarmVideoTime() {
            return barrierAlarmVideoTime;
        }

        public void setBarrierAlarmVideoTime(Integer barrierAlarmVideoTime) {
            this.barrierAlarmVideoTime = barrierAlarmVideoTime;
        }

        @Property(index = 23, type = DataType.BYTE)
        public Integer getBarrierAlarmPhotoNum() {
            return barrierAlarmPhotoNum;
        }

        public void setBarrierAlarmPhotoNum(Integer barrierAlarmPhotoNum) {
            this.barrierAlarmPhotoNum = barrierAlarmPhotoNum;
        }

        @Property(index = 24, type = DataType.BYTE)
        public Integer getBarrierAlarmPhotoInterval() {
            return barrierAlarmPhotoInterval;
        }

        public void setBarrierAlarmPhotoInterval(Integer barrierAlarmPhotoInterval) {
            this.barrierAlarmPhotoInterval = barrierAlarmPhotoInterval;
        }

        @Property(index = 25, type = DataType.BYTE)
        public Integer getFrequentChannelChangeAlarmTime() {
            return frequentChannelChangeAlarmTime;
        }

        public void setFrequentChannelChangeAlarmTime(Integer frequentChannelChangeAlarmTime) {
            this.frequentChannelChangeAlarmTime = frequentChannelChangeAlarmTime;
        }

        @Property(index = 26, type = DataType.BYTE)
        public Integer getFrequentChannelChangeAlarmNum() {
            return frequentChannelChangeAlarmNum;
        }

        public void setFrequentChannelChangeAlarmNum(Integer frequentChannelChangeAlarmNum) {
            this.frequentChannelChangeAlarmNum = frequentChannelChangeAlarmNum;
        }

        @Property(index = 27, type = DataType.BYTE)
        public Integer getFrequentChannelChangeAlarmSpeedThreshold() {
            return frequentChannelChangeAlarmSpeedThreshold;
        }

        public void setFrequentChannelChangeAlarmSpeedThreshold(Integer frequentChannelChangeAlarmSpeedThreshold) {
            this.frequentChannelChangeAlarmSpeedThreshold = frequentChannelChangeAlarmSpeedThreshold;
        }

        @Property(index = 28, type = DataType.BYTE)
        public Integer getFrequentChannelChangeAlarmVideoTime() {
            return frequentChannelChangeAlarmVideoTime;
        }

        public void setFrequentChannelChangeAlarmVideoTime(Integer frequentChannelChangeAlarmVideoTime) {
            this.frequentChannelChangeAlarmVideoTime = frequentChannelChangeAlarmVideoTime;
        }

        @Property(index = 29, type = DataType.BYTE)
        public Integer getFrequentChannelChangeAlarmPhotoNum() {
            return frequentChannelChangeAlarmPhotoNum;
        }

        public void setFrequentChannelChangeAlarmPhotoNum(Integer frequentChannelChangeAlarmPhotoNum) {
            this.frequentChannelChangeAlarmPhotoNum = frequentChannelChangeAlarmPhotoNum;
        }

        @Property(index = 30, type = DataType.BYTE)
        public Integer getFrequentChannelChangeAlarmPhotoInterval() {
            return frequentChannelChangeAlarmPhotoInterval;
        }

        public void setFrequentChannelChangeAlarmPhotoInterval(Integer frequentChannelChangeAlarmPhotoInterval) {
            this.frequentChannelChangeAlarmPhotoInterval = frequentChannelChangeAlarmPhotoInterval;
        }

        @Property(index = 31, type = DataType.BYTE)
        public Integer getLaneDepartureSpeedThreshold() {
            return laneDepartureSpeedThreshold;
        }

        public void setLaneDepartureSpeedThreshold(Integer laneDepartureSpeedThreshold) {
            this.laneDepartureSpeedThreshold = laneDepartureSpeedThreshold;
        }

        @Property(index = 32, type = DataType.BYTE)
        public Integer getLaneDepartureVideoTime() {
            return laneDepartureVideoTime;
        }

        public void setLaneDepartureVideoTime(Integer laneDepartureVideoTime) {
            this.laneDepartureVideoTime = laneDepartureVideoTime;
        }

        @Property(index = 33, type = DataType.BYTE)
        public Integer getLaneDeparturePhotoNum() {
            return laneDeparturePhotoNum;
        }

        public void setLaneDeparturePhotoNum(Integer laneDeparturePhotoNum) {
            this.laneDeparturePhotoNum = laneDeparturePhotoNum;
        }

        @Property(index = 34, type = DataType.BYTE)
        public Integer getLaneDeparturePhotoInterval() {
            return laneDeparturePhotoInterval;
        }

        public void setLaneDeparturePhotoInterval(Integer laneDeparturePhotoInterval) {
            this.laneDeparturePhotoInterval = laneDeparturePhotoInterval;
        }

        @Property(index = 35, type = DataType.BYTE)
        public Integer getForwardCollisionTimeThreshold() {
            return forwardCollisionTimeThreshold;
        }

        public void setForwardCollisionTimeThreshold(Integer forwardCollisionTimeThreshold) {
            this.forwardCollisionTimeThreshold = forwardCollisionTimeThreshold;
        }

        @Property(index = 36, type = DataType.BYTE)
        public Integer getForwardCollisionSpeedThreshold() {
            return forwardCollisionSpeedThreshold;
        }

        public void setForwardCollisionSpeedThreshold(Integer forwardCollisionSpeedThreshold) {
            this.forwardCollisionSpeedThreshold = forwardCollisionSpeedThreshold;
        }

        @Property(index = 37, type = DataType.BYTE)
        public Integer getForwardCollisionVideoTime() {
            return forwardCollisionVideoTime;
        }

        public void setForwardCollisionVideoTime(Integer forwardCollisionVideoTime) {
            this.forwardCollisionVideoTime = forwardCollisionVideoTime;
        }

        @Property(index = 38, type = DataType.BYTE)
        public Integer getForwardCollisionPhotoNum() {
            return forwardCollisionPhotoNum;
        }

        public void setForwardCollisionPhotoNum(Integer forwardCollisionPhotoNum) {
            this.forwardCollisionPhotoNum = forwardCollisionPhotoNum;
        }

        @Property(index = 39, type = DataType.BYTE)
        public Integer getForwardCollisionPhotoInterval() {
            return forwardCollisionPhotoInterval;
        }

        public void setForwardCollisionPhotoInterval(Integer forwardCollisionPhotoInterval) {
            this.forwardCollisionPhotoInterval = forwardCollisionPhotoInterval;
        }

        @Property(index = 40, type = DataType.BYTE)
        public Integer getPedestrianCollisionTimeThreshold() {
            return pedestrianCollisionTimeThreshold;
        }

        public void setPedestrianCollisionTimeThreshold(Integer pedestrianCollisionTimeThreshold) {
            this.pedestrianCollisionTimeThreshold = pedestrianCollisionTimeThreshold;
        }

        @Property(index = 41, type = DataType.BYTE)
        public Integer getPedestrianCollisionSpeedThreshold() {
            return pedestrianCollisionSpeedThreshold;
        }

        public void setPedestrianCollisionSpeedThreshold(Integer pedestrianCollisionSpeedThreshold) {
            this.pedestrianCollisionSpeedThreshold = pedestrianCollisionSpeedThreshold;
        }

        @Property(index = 42, type = DataType.BYTE)
        public Integer getPedestrianCollisionVideoTime() {
            return pedestrianCollisionVideoTime;
        }

        public void setPedestrianCollisionVideoTime(Integer pedestrianCollisionVideoTime) {
            this.pedestrianCollisionVideoTime = pedestrianCollisionVideoTime;
        }

        @Property(index = 43, type = DataType.BYTE)
        public Integer getPedestrianCollisionPhotoNum() {
            return pedestrianCollisionPhotoNum;
        }

        public void setPedestrianCollisionPhotoNum(Integer pedestrianCollisionPhotoNum) {
            this.pedestrianCollisionPhotoNum = pedestrianCollisionPhotoNum;
        }

        @Property(index = 44, type = DataType.BYTE)
        public Integer getPedestrianCollisionPhotoInterval() {
            return pedestrianCollisionPhotoInterval;
        }

        public void setPedestrianCollisionPhotoInterval(Integer pedestrianCollisionPhotoInterval) {
            this.pedestrianCollisionPhotoInterval = pedestrianCollisionPhotoInterval;
        }

        @Property(index = 45, type = DataType.BYTE)
        public Integer getVehicleDistanceSpeedThreshold() {
            return vehicleDistanceSpeedThreshold;
        }

        public void setVehicleDistanceSpeedThreshold(Integer vehicleDistanceSpeedThreshold) {
            this.vehicleDistanceSpeedThreshold = vehicleDistanceSpeedThreshold;
        }

        @Property(index = 46, type = DataType.BYTE)
        public Integer getVehicleDistanceClassificationThreshold() {
            return vehicleDistanceClassificationThreshold;
        }

        public void setVehicleDistanceClassificationThreshold(Integer vehicleDistanceClassificationThreshold) {
            this.vehicleDistanceClassificationThreshold = vehicleDistanceClassificationThreshold;
        }

        @Property(index = 47, type = DataType.BYTE)
        public Integer getVehicleDistanceVideoTime() {
            return vehicleDistanceVideoTime;
        }

        public void setVehicleDistanceVideoTime(Integer vehicleDistanceVideoTime) {
            this.vehicleDistanceVideoTime = vehicleDistanceVideoTime;
        }

        @Property(index = 48, type = DataType.BYTE)
        public Integer getVehicleDistancePhotoNum() {
            return vehicleDistancePhotoNum;
        }

        public void setVehicleDistancePhotoNum(Integer vehicleDistancePhotoNum) {
            this.vehicleDistancePhotoNum = vehicleDistancePhotoNum;
        }

        @Property(index = 49, type = DataType.BYTE)
        public Integer getVehicleDistancePhotoInterval() {
            return vehicleDistancePhotoInterval;
        }

        public void setVehicleDistancePhotoInterval(Integer vehicleDistancePhotoInterval) {
            this.vehicleDistancePhotoInterval = vehicleDistancePhotoInterval;
        }

        @Property(index = 50, type = DataType.BYTE)
        public Integer getRoadSignRecognitionPhotoNum() {
            return roadSignRecognitionPhotoNum;
        }

        public void setRoadSignRecognitionPhotoNum(Integer roadSignRecognitionPhotoNum) {
            this.roadSignRecognitionPhotoNum = roadSignRecognitionPhotoNum;
        }

        @Property(index = 51, type = DataType.BYTE)
        public Integer getRoadSignRecognitionPhotoInterval() {
            return roadSignRecognitionPhotoInterval;
        }

        public void setRoadSignRecognitionPhotoInterval(Integer roadSignRecognitionPhotoInterval) {
            this.roadSignRecognitionPhotoInterval = roadSignRecognitionPhotoInterval;
        }
    }

    public static class DriverConditionMonitoring {
        // 报警判断速度阈值
        private Integer alarmSpeedThreshold;
        // 报警提示音量
        private Integer alarmVolume;
        // 主动拍照策略
        private Integer activePhotoStrategy;
        // 主动定时拍照时间间隔
        private Integer activeTimePhotoInterval;
        // 主动定距拍照距离间隔
        private Integer activeDistancePhotoInterval;
        // 单次主动拍照张数
        private Integer activePhotoNum;
        // 单次主动拍照时间间隔
        private Integer activePhotoInterval;
        // 拍照分辨率
        private Integer photoResolution;
        // 视频录制分辨率
        private Integer videoResolution;
        // 报警使能
        private Integer alarmType;
        // 事件使能
        private Integer eventType;
        // 吸烟报警判断时间间隔
        private Integer smokingAlarmInterval;
        // 接打电话报警判断时间间隔
        private Integer phoneCallAlarmInterval;
        // 预留字段
        private byte[] save;
        // 疲劳驾驶报警分级速度阈值
        private Integer tiredAlarmClassificationSpeedThreshold;
        // 疲劳驾驶报警前后视频录制时间
        private Integer tiredDriveVideoTime;
        // 疲劳驾驶报警拍照张数
        private Integer tiredDrivePhotoNum;
        // 疲劳驾驶报警拍照间隔时间
        private Integer tiredDrivePhotoInterval;
        //接打电话报警分级速度阈值
        private Integer phoneCallAlarmClassificationSpeedThreshold;
        // 接打电话报警前后视频录制时间
        private Integer phoneCallVideoTime;
        // 接打电话报警拍驾驶员面部特征照片张数, 拍几张
        private Integer phoneCallShotNum;
        // 接打电话报警拍驾驶员面部特征照片间隔时间
        private Integer phoneCallShotInterval;
        // 抽烟报警分级车速阈值
        private Integer smokingAlarmClassificationSpeedThreshold;
        // 抽烟报警前后视频录制时间
        private Integer smokingVideoTime;
        // 抽烟报警拍驾驶员面部特征照片张数, 拍几张
        private Integer smokingShotNum;
        // 抽烟报警拍驾驶员面部特征照片间隔时间
        private Integer smokingShotInterval;
        // 分神报警分级车速阈值
        private Integer distractionAlarmClassificationSpeedThreshold;
        // 分神报警前后视频录制时间
        private Integer distractionVideoTime;
        // 分神报警拍驾驶员面部特征照片张数, 拍几张
        private Integer distractionShotNum;
        // 分神报警拍驾驶员面部特征照片间隔时间
        private Integer distractionShotInterval;
        // 驾驶行为异常报警分级车速阈值
        private Integer exceptDrivingAlarmClassificationSpeedThreshold;
        // 驾驶行为异常报警前后视频录制时间
        private Integer exceptDrivingVideoTime;
        // 驾驶行为异常报警拍驾驶员面部特征照片张数, 拍几张
        private Integer exceptDrivingShotNum;
        // 驾驶行为异常报警拍驾驶员面部特征照片间隔时间
        private Integer exceptDrivingShotInterval;
        // 驾驶员身份识别触发
        private Integer driverIdentityRecognitionTrigge;

        @Property(index = 0, type = DataType.BYTE)
        public Integer getAlarmSpeedThreshold() {
            return alarmSpeedThreshold;
        }

        public void setAlarmSpeedThreshold(Integer alarmSpeedThreshold) {
            this.alarmSpeedThreshold = alarmSpeedThreshold;
        }

        @Property(index = 1, type = DataType.BYTE)
        public Integer getAlarmVolume() {
            return alarmVolume;
        }

        public void setAlarmVolume(Integer alarmVolume) {
            this.alarmVolume = alarmVolume;
        }

        @Property(index = 2, type = DataType.BYTE)
        public Integer getActivePhotoStrategy() {
            return activePhotoStrategy;
        }

        public void setActivePhotoStrategy(Integer activePhotoStrategy) {
            this.activePhotoStrategy = activePhotoStrategy;
        }

        @Property(index = 3, type = DataType.WORD)
        public Integer getActiveTimePhotoInterval() {
            return activeTimePhotoInterval;
        }

        public void setActiveTimePhotoInterval(Integer activeTimePhotoInterval) {
            this.activeTimePhotoInterval = activeTimePhotoInterval;
        }

        @Property(index = 5, type = DataType.WORD)
        public Integer getActiveDistancePhotoInterval() {
            return activeDistancePhotoInterval;
        }

        public void setActiveDistancePhotoInterval(Integer activeDistancePhotoInterval) {
            this.activeDistancePhotoInterval = activeDistancePhotoInterval;
        }

        @Property(index = 7, type = DataType.BYTE)
        public Integer getActivePhotoNum() {
            return activePhotoNum;
        }

        public void setActivePhotoNum(Integer activePhotoNum) {
            this.activePhotoNum = activePhotoNum;
        }

        @Property(index = 8, type = DataType.BYTE)
        public Integer getActivePhotoInterval() {
            return activePhotoInterval;
        }

        public void setActivePhotoInterval(Integer activePhotoInterval) {
            this.activePhotoInterval = activePhotoInterval;
        }

        @Property(index = 9, type = DataType.BYTE)
        public Integer getPhotoResolution() {
            return photoResolution;
        }

        public void setPhotoResolution(Integer photoResolution) {
            this.photoResolution = photoResolution;
        }

        @Property(index = 10, type = DataType.BYTE)
        public Integer getVideoResolution() {
            return videoResolution;
        }

        public void setVideoResolution(Integer videoResolution) {
            this.videoResolution = videoResolution;
        }

        @Property(index = 11, type = DataType.DWORD)
        public Integer getAlarmType() {
            return alarmType;
        }

        public void setAlarmType(Integer alarmType) {
            this.alarmType = alarmType;
        }

        @Property(index = 15, type = DataType.DWORD)
        public Integer getEventType() {
            return eventType;
        }

        public void setEventType(Integer eventType) {
            this.eventType = eventType;
        }

        @Property(index = 19, type = DataType.WORD)
        public Integer getSmokingAlarmInterval() {
            return smokingAlarmInterval;
        }

        public void setSmokingAlarmInterval(Integer smokingAlarmInterval) {
            this.smokingAlarmInterval = smokingAlarmInterval;
        }

        @Property(index = 21, type = DataType.WORD)
        public Integer getPhoneCallAlarmInterval() {
            return phoneCallAlarmInterval;
        }

        public void setPhoneCallAlarmInterval(Integer phoneCallAlarmInterval) {
            this.phoneCallAlarmInterval = phoneCallAlarmInterval;
        }

        @Property(index = 23, type = DataType.BYTES, length = 3)
        public byte[] getSave() {
            return save;
        }

        public void setSave(byte[] save) {
            this.save = save;
        }

        @Property(index = 26, type = DataType.BYTE)
        public Integer getTiredAlarmClassificationSpeedThreshold() {
            return tiredAlarmClassificationSpeedThreshold;
        }

        public void setTiredAlarmClassificationSpeedThreshold(Integer tiredAlarmClassificationSpeedThreshold) {
            this.tiredAlarmClassificationSpeedThreshold = tiredAlarmClassificationSpeedThreshold;
        }

        @Property(index = 27, type = DataType.BYTE)
        public Integer getTiredDriveVideoTime() {
            return tiredDriveVideoTime;
        }

        public void setTiredDriveVideoTime(Integer tiredDriveVideoTime) {
            this.tiredDriveVideoTime = tiredDriveVideoTime;
        }

        @Property(index = 28, type = DataType.BYTE)
        public Integer getTiredDrivePhotoNum() {
            return tiredDrivePhotoNum;
        }

        public void setTiredDrivePhotoNum(Integer tiredDrivePhotoNum) {
            this.tiredDrivePhotoNum = tiredDrivePhotoNum;
        }

        @Property(index = 29, type = DataType.BYTE)
        public Integer getTiredDrivePhotoInterval() {
            return tiredDrivePhotoInterval;
        }

        public void setTiredDrivePhotoInterval(Integer tiredDrivePhotoInterval) {
            this.tiredDrivePhotoInterval = tiredDrivePhotoInterval;
        }

        @Property(index = 30, type = DataType.BYTE)
        public Integer getPhoneCallAlarmClassificationSpeedThreshold() {
            return phoneCallAlarmClassificationSpeedThreshold;
        }

        public void setPhoneCallAlarmClassificationSpeedThreshold(Integer phoneCallAlarmClassificationSpeedThreshold) {
            this.phoneCallAlarmClassificationSpeedThreshold = phoneCallAlarmClassificationSpeedThreshold;
        }

        @Property(index = 31, type = DataType.BYTE)
        public Integer getPhoneCallVideoTime() {
            return phoneCallVideoTime;
        }

        public void setPhoneCallVideoTime(Integer phoneCallVideoTime) {
            this.phoneCallVideoTime = phoneCallVideoTime;
        }

        @Property(index = 32, type = DataType.BYTE)
        public Integer getPhoneCallShotNum() {
            return phoneCallShotNum;
        }

        public void setPhoneCallShotNum(Integer phoneCallShotNum) {
            this.phoneCallShotNum = phoneCallShotNum;
        }

        @Property(index = 33, type = DataType.BYTE)
        public Integer getPhoneCallShotInterval() {
            return phoneCallShotInterval;
        }

        public void setPhoneCallShotInterval(Integer phoneCallShotInterval) {
            this.phoneCallShotInterval = phoneCallShotInterval;
        }

        @Property(index = 34, type = DataType.BYTE)
        public Integer getSmokingAlarmClassificationSpeedThreshold() {
            return smokingAlarmClassificationSpeedThreshold;
        }

        public void setSmokingAlarmClassificationSpeedThreshold(Integer smokingAlarmClassificationSpeedThreshold) {
            this.smokingAlarmClassificationSpeedThreshold = smokingAlarmClassificationSpeedThreshold;
        }

        @Property(index = 35, type = DataType.BYTE)
        public Integer getSmokingVideoTime() {
            return smokingVideoTime;
        }

        public void setSmokingVideoTime(Integer smokingVideoTime) {
            this.smokingVideoTime = smokingVideoTime;
        }

        @Property(index = 36, type = DataType.BYTE)
        public Integer getSmokingShotNum() {
            return smokingShotNum;
        }

        public void setSmokingShotNum(Integer smokingShotNum) {
            this.smokingShotNum = smokingShotNum;
        }

        @Property(index = 37, type = DataType.BYTE)
        public Integer getSmokingShotInterval() {
            return smokingShotInterval;
        }

        public void setSmokingShotInterval(Integer smokingShotInterval) {
            this.smokingShotInterval = smokingShotInterval;
        }

        @Property(index = 38, type = DataType.BYTE)
        public Integer getDistractionAlarmClassificationSpeedThreshold() {
            return distractionAlarmClassificationSpeedThreshold;
        }

        public void setDistractionAlarmClassificationSpeedThreshold(Integer distractionAlarmClassificationSpeedThreshold) {
            this.distractionAlarmClassificationSpeedThreshold = distractionAlarmClassificationSpeedThreshold;
        }

        @Property(index = 39, type = DataType.BYTE)
        public Integer getDistractionVideoTime() {
            return distractionVideoTime;
        }

        public void setDistractionVideoTime(Integer distractionVideoTime) {
            this.distractionVideoTime = distractionVideoTime;
        }

        @Property(index = 40, type = DataType.BYTE)
        public Integer getDistractionShotNum() {
            return distractionShotNum;
        }

        public void setDistractionShotNum(Integer distractionShotNum) {
            this.distractionShotNum = distractionShotNum;
        }

        @Property(index = 41, type = DataType.BYTE)
        public Integer getDistractionShotInterval() {
            return distractionShotInterval;
        }

        public void setDistractionShotInterval(Integer distractionShotInterval) {
            this.distractionShotInterval = distractionShotInterval;
        }

        @Property(index = 42, type = DataType.BYTE)
        public Integer getExceptDrivingAlarmClassificationSpeedThreshold() {
            return exceptDrivingAlarmClassificationSpeedThreshold;
        }

        public void setExceptDrivingAlarmClassificationSpeedThreshold(Integer exceptDrivingAlarmClassificationSpeedThreshold) {
            this.exceptDrivingAlarmClassificationSpeedThreshold = exceptDrivingAlarmClassificationSpeedThreshold;
        }

        @Property(index = 43, type = DataType.BYTE)
        public Integer getExceptDrivingVideoTime() {
            return exceptDrivingVideoTime;
        }

        public void setExceptDrivingVideoTime(Integer exceptDrivingVideoTime) {
            this.exceptDrivingVideoTime = exceptDrivingVideoTime;
        }

        @Property(index = 44, type = DataType.BYTE)
        public Integer getExceptDrivingShotNum() {
            return exceptDrivingShotNum;
        }

        public void setExceptDrivingShotNum(Integer exceptDrivingShotNum) {
            this.exceptDrivingShotNum = exceptDrivingShotNum;
        }

        @Property(index = 45, type = DataType.BYTE)
        public Integer getExceptDrivingShotInterval() {
            return exceptDrivingShotInterval;
        }

        public void setExceptDrivingShotInterval(Integer exceptDrivingShotInterval) {
            this.exceptDrivingShotInterval = exceptDrivingShotInterval;
        }

        @Property(index = 46, type = DataType.BYTE)
        public Integer getDriverIdentityRecognitionTrigge() {
            return driverIdentityRecognitionTrigge;
        }

        public void setDriverIdentityRecognitionTrigge(Integer driverIdentityRecognitionTrigge) {
            this.driverIdentityRecognitionTrigge = driverIdentityRecognitionTrigge;
        }
    }

    public static class TirePressureMonitoring {
        // 轮胎规格型号
        private byte[] tyreSpecificationAndType;
        // 胎压单位
        private Integer tirePressureUnit;
        // 正常胎压值
        private Integer normalTirePressure;
        // 胎压不平衡门限
        private Integer tirePressureUnbalanceThreshold;
        // 慢漏气门限
        private Integer slowLeakageThreshold;
        // 低压阈值
        private Integer lowPressureThreshold;
        // 高压阈值
        private Integer highPressureThreshold;
        // 高温阈值
        private Integer highTemperatureThreshold;
        // 电压阈值
        private Integer voltageThreshold;
        // 定时上报时间间隔
        private Integer timingUploadInterval;

        @Property(index = 0, type = DataType.BYTES, length = 12)
        public byte[] getTyreSpecificationAndType() {
            return tyreSpecificationAndType;
        }

        public void setTyreSpecificationAndType(byte[] tyreSpecificationAndType) {
            this.tyreSpecificationAndType = tyreSpecificationAndType;
        }

        @Property(index = 12, type = DataType.WORD)
        public Integer getTirePressureUnit() {
            return tirePressureUnit;
        }

        public void setTirePressureUnit(Integer tirePressureUnit) {
            this.tirePressureUnit = tirePressureUnit;
        }

        @Property(index = 14, type = DataType.WORD)
        public Integer getNormalTirePressure() {
            return normalTirePressure;
        }

        public void setNormalTirePressure(Integer normalTirePressure) {
            this.normalTirePressure = normalTirePressure;
        }

        @Property(index = 16, type = DataType.WORD)
        public Integer getTirePressureUnbalanceThreshold() {
            return tirePressureUnbalanceThreshold;
        }

        public void setTirePressureUnbalanceThreshold(Integer tirePressureUnbalanceThreshold) {
            this.tirePressureUnbalanceThreshold = tirePressureUnbalanceThreshold;
        }

        @Property(index = 18, type = DataType.WORD)
        public Integer getSlowLeakageThreshold() {
            return slowLeakageThreshold;
        }

        public void setSlowLeakageThreshold(Integer slowLeakageThreshold) {
            this.slowLeakageThreshold = slowLeakageThreshold;
        }

        @Property(index = 20, type = DataType.WORD)
        public Integer getLowPressureThreshold() {
            return lowPressureThreshold;
        }

        public void setLowPressureThreshold(Integer lowPressureThreshold) {
            this.lowPressureThreshold = lowPressureThreshold;
        }

        @Property(index = 22, type = DataType.WORD)
        public Integer getHighPressureThreshold() {
            return highPressureThreshold;
        }

        public void setHighPressureThreshold(Integer highPressureThreshold) {
            this.highPressureThreshold = highPressureThreshold;
        }

        @Property(index = 24, type = DataType.WORD)
        public Integer getHighTemperatureThreshold() {
            return highTemperatureThreshold;
        }

        public void setHighTemperatureThreshold(Integer highTemperatureThreshold) {
            this.highTemperatureThreshold = highTemperatureThreshold;
        }

        @Property(index = 26, type = DataType.WORD)
        public Integer getVoltageThreshold() {
            return voltageThreshold;
        }

        public void setVoltageThreshold(Integer voltageThreshold) {
            this.voltageThreshold = voltageThreshold;
        }

        @Property(index = 28, type = DataType.WORD)
        public Integer getTimingUploadInterval() {
            return timingUploadInterval;
        }

        public void setTimingUploadInterval(Integer timingUploadInterval) {
            this.timingUploadInterval = timingUploadInterval;
        }
    }

    public static class BlindAreaMonitoring {
        // 后方接近报警时间阈值
        private Integer rearApproachAlarmTimeThreshold;
        // 侧后方接近报警时间阈值
        private Integer lateralRearApproachAlarmTimeThreshold;

        @Property(index = 0, type = DataType.BYTE)
        public Integer getRearApproachAlarmTimeThreshold() {
            return rearApproachAlarmTimeThreshold;
        }

        public void setRearApproachAlarmTimeThreshold(Integer rearApproachAlarmTimeThreshold) {
            this.rearApproachAlarmTimeThreshold = rearApproachAlarmTimeThreshold;
        }

        @Property(index = 1, type = DataType.BYTE)
        public Integer getLateralRearApproachAlarmTimeThreshold() {
            return lateralRearApproachAlarmTimeThreshold;
        }

        public void setLateralRearApproachAlarmTimeThreshold(Integer lateralRearApproachAlarmTimeThreshold) {
            this.lateralRearApproachAlarmTimeThreshold = lateralRearApproachAlarmTimeThreshold;
        }
    }

    @Property(index = 3, type = DataType.OBJ, lengthName = "paramLength", enumType = 0xF364)
    public AdvancedDrivingAssistance getAdvancedDrivingAssistance() {
        return advancedDrivingAssistance;
    }

    public void setAdvancedDrivingAssistance(AdvancedDrivingAssistance advancedDrivingAssistance) {
        this.advancedDrivingAssistance = advancedDrivingAssistance;
    }

    @Property(index = 3, type = DataType.OBJ, lengthName = "paramLength", enumType = 0xF365)
    public DriverConditionMonitoring getDriverConditionMonitoring() {
        return driverConditionMonitoring;
    }

    public void setDriverConditionMonitoring(DriverConditionMonitoring driverConditionMonitoring) {
        this.driverConditionMonitoring = driverConditionMonitoring;
    }

    @Property(index = 3, type = DataType.OBJ, lengthName = "paramLength", enumType = 0xF366)
    public TirePressureMonitoring getTirePressureMonitoring() {
        return tirePressureMonitoring;
    }

    public void setTirePressureMonitoring(TirePressureMonitoring tirePressureMonitoring) {
        this.tirePressureMonitoring = tirePressureMonitoring;
    }

    @Property(index = 3, type = DataType.OBJ, lengthName = "paramLength", enumType = 0xF367)
    public BlindAreaMonitoring getBlindAreaMonitoring() {
        return blindAreaMonitoring;
    }

    public void setBlindAreaMonitoring(BlindAreaMonitoring blindAreaMonitoring) {
        this.blindAreaMonitoring = blindAreaMonitoring;
    }
}

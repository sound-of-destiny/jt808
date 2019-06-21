package cn.edu.sdu.jt808.protocol.upMsg;

import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;

import java.util.ArrayList;
import java.util.Arrays;

public class ExtraLocation {

    private Integer type;
    private Integer length;

    @Property(index = 0, type = DataType.BYTE, desc = "参数ID")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Property(index = 1, type = DataType.BYTE, desc = "参数长度")
    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    // 里程
    private Integer mileage;
    // 油量
    private Integer oilQuantity;
    // 行驶记录功能获取的速度
    private Integer carSpeed;
    // 需要人工确认报警事件的 ID
    private Integer warningId;

    private SpeedingExtraData speedingExtraData;
    private LocationExtraData locationExtraData;
    private LocationInfoExtraData locationInfoExtraData;
    private Integer extraCarState;
    private Integer ioState;

    // 模拟量,bit0-15,AD0;bit16-31,AD1
    private Integer simulation;
    // 无线通信网络信号强度
    private Integer wirelessIntensity;
    // GNSS 定位卫星数
    private Integer satellitesNum;

    // 超速报警附加信息消息体数据格式
    public static class SpeedingExtraData {
        // 位置类型
        private Integer locationType;
        // 区域或路段 ID
        private String locationId;

        @Property(index = 0, type = DataType.BYTE)
        public Integer getLocationType() {
            return locationType;
        }

        public void setLocationType(Integer locationType) {
            this.locationType = locationType;
        }

        // @Property(index = 1, type = DataType.DWORD) TODO
        public String getLocationId() {
            return locationId;
        }

        public void setLocationId(String locationId) {
            this.locationId = locationId;
        }

        @Override
        public String toString() {
            return "{" +
                    " \"locationType\" : " + locationType +
                    /*", \"locationId=\" : " + locationId +*/
                    " }";
        }
    }

    // 进出区域/路线报警附加信息消息体数据格式
    public static class LocationExtraData {
        // 位置类型
        private Integer locationType;
        // 区域或线路 ID
        private String locationId;
        // 方向
        private Integer direction;

        @Property(index = 0, type = DataType.BYTE)
        public Integer getLocationType() {
            return locationType;
        }

        public void setLocationType(Integer locationType) {
            this.locationType = locationType;
        }

        @Property(index = 1, type = DataType.DWORD)
        public String getLocationId() {
            return locationId;
        }

        public void setLocationId(String locationId) {
            this.locationId = locationId;
        }

        @Property(index = 5, type = DataType.BYTE)
        public Integer getDirection() {
            return direction;
        }

        public void setDirection(Integer direction) {
            this.direction = direction;
        }

        @Override
        public String toString() {
            return "{" +
                    " \"locationType\" : " + locationType +
                    ", \"locationId=\" : " + locationId +
                    ", \"direction=\" : " + direction +
                    " }";
        }
    }

    // 路线行驶时间不足/过长报警附加信息消息体数据格式
    public static class LocationInfoExtraData {
        // 路段 ID
        private String roadId;
        // 路段行驶时间
        private Integer runTime;
        // 结果
        private Integer result;

        @Property(index =0, type = DataType.DWORD)
        public String getRoadId() {
            return roadId;
        }

        public void setRoadId(String roadId) {
            this.roadId = roadId;
        }

        @Property(index = 4, type = DataType.WORD)
        public Integer getRunTime() {
            return runTime;
        }

        public void setRunTime(Integer runTime) {
            this.runTime = runTime;
        }

        @Property(index = 6, type = DataType.BYTE)
        public Integer getResult() {
            return result;
        }

        public void setResult(Integer result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return "{" +
                    " \"roadId\" : " + roadId +
                    ", \"runTime\" : " + runTime +
                    ", \"result\" : " + result +
                    " }";
        }
    }


        // 扩展车辆信号状态位
        // 1:近光灯信号
        private boolean lowLightSignal;
        // 1:远光灯信号
        private boolean farLightSignal;
        //　1:右转向灯信号
        private boolean rightLightSignal;
        //　1:左转向灯信号
        private boolean leftLightSignal;
        //　1:制动信号
        private boolean brakingSignal;
        //　1:倒档信号
        private boolean reverseSignal;
        //　1:雾灯信号
        private boolean fogLampSignal;
        //　1:示廓灯
        private boolean outlineLamp;
        //　1:喇叭信号
        private boolean hornSignal;
        //　1:空调状态
        private boolean airCondition;
        //　1:空挡信号
        private boolean neutralSignal;
        //　1:缓速器工作
        private boolean retarderOperation;
        //　1:ABS 工作
        private boolean ABSOperation;
        //　1:加热器工作
        private boolean heaterOperation;
        //　1:离合器状态
        private boolean clutchState;

        public boolean isLowLightSignal() {
            return lowLightSignal;
        }

        public void setLowLightSignal(boolean lowLightSignal) {
            this.lowLightSignal = lowLightSignal;
        }

        public boolean isFarLightSignal() {
            return farLightSignal;
        }

        public void setFarLightSignal(boolean farLightSignal) {
            this.farLightSignal = farLightSignal;
        }

        public boolean isRightLightSignal() {
            return rightLightSignal;
        }

        public void setRightLightSignal(boolean rightLightSignal) {
            this.rightLightSignal = rightLightSignal;
        }

        public boolean isLeftLightSignal() {
            return leftLightSignal;
        }

        public void setLeftLightSignal(boolean leftLightSignal) {
            this.leftLightSignal = leftLightSignal;
        }

        public boolean isBrakingSignal() {
            return brakingSignal;
        }

        public void setBrakingSignal(boolean brakingSignal) {
            this.brakingSignal = brakingSignal;
        }

        public boolean isReverseSignal() {
            return reverseSignal;
        }

        public void setReverseSignal(boolean reverseSignal) {
            this.reverseSignal = reverseSignal;
        }

        public boolean isFogLampSignal() {
            return fogLampSignal;
        }

        public void setFogLampSignal(boolean fogLampSignal) {
            this.fogLampSignal = fogLampSignal;
        }

        public boolean isOutlineLamp() {
            return outlineLamp;
        }

        public void setOutlineLamp(boolean outlineLamp) {
            this.outlineLamp = outlineLamp;
        }

        public boolean isHornSignal() {
            return hornSignal;
        }

        public void setHornSignal(boolean hornSignal) {
            this.hornSignal = hornSignal;
        }

        public boolean isAirCondition() {
            return airCondition;
        }

        public void setAirCondition(boolean airCondition) {
            this.airCondition = airCondition;
        }

        public boolean isNeutralSignal() {
            return neutralSignal;
        }

        public void setNeutralSignal(boolean neutralSignal) {
            this.neutralSignal = neutralSignal;
        }

        public boolean isRetarderOperation() {
            return retarderOperation;
        }

        public void setRetarderOperation(boolean retarderOperation) {
            this.retarderOperation = retarderOperation;
        }

        public boolean isABSOperation() {
            return ABSOperation;
        }

        public void setABSOperation(boolean ABSOperation) {
            this.ABSOperation = ABSOperation;
        }

        public boolean isHeaterOperation() {
            return heaterOperation;
        }

        public void setHeaterOperation(boolean heaterOperation) {
            this.heaterOperation = heaterOperation;
        }

        public boolean isClutchState() {
            return clutchState;
        }

        public void setClutchState(boolean clutchState) {
            this.clutchState = clutchState;
        }


        // GNSS
        // 1:深度休眠状态
        private boolean deepDormancy;
        // 1:休眠状态
        private boolean dormancy;

        public boolean isDeepDormancy() {
            return deepDormancy;
        }

        public void setDeepDormancy(boolean deepDormancy) {
            this.deepDormancy = deepDormancy;
        }

        public boolean isDormancy() {
            return dormancy;
        }

        public void setDormancy(boolean dormancy) {
            this.dormancy = dormancy;
        }

    /**
     * 视频部分
     */
    // 视频相关报警
    private Integer videoAlarm;
    // 视频信号丢失报警
    private Integer videoLostAlarm;
    // 视频信号遮挡报警
    private Integer videoShieldAlarm;
    // 存储器故障报警
    private Integer storageAlarm;
    // 异常驾驶
    private ExceptionDriveType exceptionDriveType;

    public static class ExceptionDriveType {
        private Integer type;
        private Integer tiredDegree;

        @Property(index = 0, type = DataType.WORD)
        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        @Property(index = 2, type = DataType.BYTE)
        public Integer getTiredDegree() {
            return tiredDegree;
        }

        public void setTiredDegree(Integer tiredDegree) {
            this.tiredDegree = tiredDegree;
        }

        @Override
        public String toString() {
            return "{" +
                    " \"Etype\" : " + type +
                    ", \"tiredDegree\" : " + tiredDegree +
                    " }";
        }
    }

    /**
     * ADAS 部分
     */
    public static class AlarmFlag {
        // 终端 ID
        private byte[] terminalId;
        // 时间
        private String time;
        // 序号
        private Integer sequenceId;
        // 附件数量
        private Integer fileNum;

        @Property(index = 0, type = DataType.BYTES, length = 7)
        public byte[] getTerminalId() {
            return terminalId;
        }

        public void setTerminalId(byte[] terminalId) {
            this.terminalId = terminalId;
        }

        @Property(index = 7, type = DataType.BCD8421, length = 6)
        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Property(index = 13, type = DataType.BYTE)
        public Integer getSequenceId() {
            return sequenceId;
        }

        public void setSequenceId(Integer sequenceId) {
            this.sequenceId = sequenceId;
        }

        @Property(index = 14, type = DataType.BYTE)
        public Integer getFileNum() {
            return fileNum;
        }

        public void setFileNum(Integer fileNum) {
            this.fileNum = fileNum;
        }

        @Override
        public String toString() {
            return "{" +
                    " \"terminalId\" : " + Arrays.toString(terminalId) +
                    ", \"time\" : " + time +
                    ", \"sequenceId\" : " + sequenceId +
                    ", \"fileNum\" : " + fileNum +
                    " }";
        }
    }

    // 高级驾驶辅助系统报警
    private AdvancedDrivingAssistanceAlarm  advancedDrivingAssistanceAlarm;

    // 驾驶员状态监测系统报警
    private DriverConditionMonitoringSystemAlarm driverConditionMonitoringSystemAlarm;

    // 胎压监测系统报警
    private TirePressureMonitoringSystemAlarm tirePressureMonitoringSystemAlarm;

    // 盲区监测系统报警
    private BlindAreaMonitoringSystemAlarm blindAreaMonitoringSystemAlarm;

    public static class AdvancedDrivingAssistanceAlarm {
        // 报警 ID
        private Integer alarmId;
        // 标志状态
        private Integer flag;
        // 报警/事件类型
        private Integer alarmType;
        // 报警级别
        private Integer alarmDegre;
        // 前车车速
        private Integer forwardCarSpeed;
        // 前车/行人距离
        private Integer forwardCarDistance;
        // 偏离类型
        private Integer deviationType;
        // 道路标志识别类型
        private Integer roadSignRecognitionType;
        // 道路标志识别数据
        private Integer roadSignRecognitionData;
        // 车速
        private Integer speed;
        // 高程
        private Integer elevation;
        // 纬度
        private Integer latitude;
        // 经度
        private Integer longitude;
        // 日期时间
        private String time;
        // 车辆状态
        private Integer status;
        // 报警标识号
        private byte[] alarmFlag;

        @Property(index = 0, type = DataType.DWORD)
        public Integer getAlarmId() {
            return alarmId;
        }

        public void setAlarmId(Integer alarmId) {
            this.alarmId = alarmId;
        }

        @Property(index = 4, type = DataType.BYTE)
        public Integer getFlag() {
            return flag;
        }

        public void setFlag(Integer flag) {
            this.flag = flag;
        }

        @Property(index = 5, type = DataType.BYTE)
        public Integer getAlarmType() {
            return alarmType;
        }

        public void setAlarmType(Integer alarmType) {
            this.alarmType = alarmType;
        }

        @Property(index = 6, type = DataType.BYTE)
        public Integer getAlarmDegre() {
            return alarmDegre;
        }

        public void setAlarmDegre(Integer alarmDegre) {
            this.alarmDegre = alarmDegre;
        }

        @Property(index = 7, type = DataType.BYTE)
        public Integer getForwardCarSpeed() {
            return forwardCarSpeed;
        }

        public void setForwardCarSpeed(Integer forwardCarSpeed) {
            this.forwardCarSpeed = forwardCarSpeed;
        }

        @Property(index = 8, type = DataType.BYTE)
        public Integer getForwardCarDistance() {
            return forwardCarDistance;
        }

        public void setForwardCarDistance(Integer forwardCarDistance) {
            this.forwardCarDistance = forwardCarDistance;
        }

        @Property(index = 9, type = DataType.BYTE)
        public Integer getDeviationType() {
            return deviationType;
        }

        public void setDeviationType(Integer deviationType) {
            this.deviationType = deviationType;
        }

        @Property(index = 10, type = DataType.BYTE)
        public Integer getRoadSignRecognitionType() {
            return roadSignRecognitionType;
        }

        public void setRoadSignRecognitionType(Integer roadSignRecognitionType) {
            this.roadSignRecognitionType = roadSignRecognitionType;
        }

        @Property(index = 11, type = DataType.BYTE)
        public Integer getRoadSignRecognitionData() {
            return roadSignRecognitionData;
        }

        public void setRoadSignRecognitionData(Integer roadSignRecognitionData) {
            this.roadSignRecognitionData = roadSignRecognitionData;
        }


        @Property(index = 12, type = DataType.BYTE)
        public Integer getSpeed() {
            return speed;
        }

        public void setSpeed(Integer speed) {
            this.speed = speed;
        }

        @Property(index = 13, type = DataType.WORD)
        public Integer getElevation() {
            return elevation;
        }

        public void setElevation(Integer elevation) {
            this.elevation = elevation;
        }

        @Property(index = 15, type = DataType.DWORD)
        public Integer getLatitude() {
            return latitude;
        }

        public void setLatitude(Integer latitude) {
            this.latitude = latitude;
        }

        @Property(index = 19, type = DataType.DWORD)
        public Integer getLongitude() {
            return longitude;
        }

        public void setLongitude(Integer longitude) {
            this.longitude = longitude;
        }

        @Property(index = 23, type = DataType.BCD8421, length = 6)
        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Property(index = 29, type = DataType.WORD)
        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        @Property(index = 31, type = DataType.BYTES, length = 16)
        public byte[] getAlarmFlag() {
            return alarmFlag;
        }

        public void setAlarmFlag(byte[] alarmFlag) {
            this.alarmFlag = alarmFlag;
        }

        @Override
        public String toString() {
            return "{ " +
                    " \"alarmId\" : " + alarmId +
                    ", \"flag\" : " + flag +
                    ", \"alarmType\" : " + alarmType +
                    ", \"alarmDegre\" : " + alarmDegre +
                    ", \"forwardCarSpeed\" : " + forwardCarSpeed +
                    ", \"forwardCarDistance\" : " + forwardCarDistance +
                    ", \"deviationType\" : " + deviationType +
                    ", \"roadSignRecognitionType\" : " + roadSignRecognitionType +
                    ", \"roadSignRecognitionData\" : " + roadSignRecognitionData +
                    ", \"speed\" : " + speed +
                    ", \"elevation\" : " + elevation +
                    ", \"latitude\" : " + latitude +
                    ", \"longitude\" : " + longitude +
                    ", \"time\" : " + time +
                    ", \"status\" : " + status +
                    ", \"alarmFlag\" : " + new String(alarmFlag) +
                    " }";
        }
    }

    public static class DriverConditionMonitoringSystemAlarm {
        // 报警 ID
        private Integer alarmId;
        // 标志状态
        private Integer flag;
        // 报警/事件类型
        private Integer alarmType;
        // 报警级别
        private Integer alarmDegre;
        // 疲劳程度
        private Integer tireDegre;
        // 预留
        private Integer save;
        // 车速
        private Integer speed;
        // 高程
        private Integer elevation;
        // 纬度
        private Integer latitude;
        // 经度
        private Integer longitude;
        // 日期时间
        private String time;
        // 车辆状态
        private Integer status;
        // 报警标识号
        private byte[] alarmFlag;

        @Property(index = 0, type = DataType.DWORD)
        public Integer getAlarmId() {
            return alarmId;
        }

        public void setAlarmId(Integer alarmId) {
            this.alarmId = alarmId;
        }

        @Property(index = 4, type = DataType.BYTE)
        public Integer getFlag() {
            return flag;
        }

        public void setFlag(Integer flag) {
            this.flag = flag;
        }

        @Property(index = 5, type = DataType.BYTE)
        public Integer getAlarmType() {
            return alarmType;
        }

        public void setAlarmType(Integer alarmType) {
            this.alarmType = alarmType;
        }

        @Property(index = 6, type = DataType.BYTE)
        public Integer getAlarmDegre() {
            return alarmDegre;
        }

        public void setAlarmDegre(Integer alarmDegre) {
            this.alarmDegre = alarmDegre;
        }

        @Property(index = 7, type = DataType.BYTE)
        public Integer getTireDegre() {
            return tireDegre;
        }

        public void setTireDegre(Integer tireDegre) {
            this.tireDegre = tireDegre;
        }

        @Property(index = 8, type = DataType.DWORD)
        public Integer getSave() {
            return save;
        }

        public void setSave(Integer save) {
            this.save = save;
        }

        @Property(index = 12, type = DataType.BYTE)
        public Integer getSpeed() {
            return speed;
        }

        public void setSpeed(Integer speed) {
            this.speed = speed;
        }

        @Property(index = 13, type = DataType.WORD)
        public Integer getElevation() {
            return elevation;
        }

        public void setElevation(Integer elevation) {
            this.elevation = elevation;
        }

        @Property(index = 15, type = DataType.DWORD)
        public Integer getLatitude() {
            return latitude;
        }

        public void setLatitude(Integer latitude) {
            this.latitude = latitude;
        }

        @Property(index = 19, type = DataType.DWORD)
        public Integer getLongitude() {
            return longitude;
        }

        public void setLongitude(Integer longitude) {
            this.longitude = longitude;
        }

        @Property(index = 23, type = DataType.BCD8421, length = 6)
        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Property(index = 29, type = DataType.WORD)
        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        @Property(index = 31, type = DataType.BYTES, length = 16)
        public byte[] getAlarmFlag() {
            return alarmFlag;
        }

        public void setAlarmFlag(byte[] alarmFlag) {
            this.alarmFlag = alarmFlag;
        }

        @Override
        public String toString() {
            return "{" +
                    " \"alarmId\" : " + alarmId +
                    ", \"flag\" : " + flag +
                    ", \"alarmType\" : " + alarmType +
                    ", \"alarmDegre\" : " + alarmDegre +
                    ", \"tireDegre\" : " + tireDegre +
                    ", \"save\" : " + save +
                    ", \"speed\" : " + speed +
                    ", \"elevation\" : " + elevation +
                    ", \"latitude\" : " + latitude +
                    ", \"longitude\" : " + longitude +
                    ", \"time\" : " + time +
                    ", \"status\" : " + status +
                    ", \"alarmFlag\" : " + new String(alarmFlag) +
                    " }";
        }
    }

    public static class TirePressureMonitoringSystemAlarm {
        // 报警 ID
        private Integer alarmId;
        // 标志状态
        private Integer flag;
        // 车速
        private Integer speed;
        // 高程
        private Integer elevation;
        // 纬度
        private Integer latitude;
        // 经度
        private Integer longitude;
        // 日期时间
        private String time;
        // 车辆状态
        private Integer status;
        // 报警标识号
        private byte[] alarmFlag;
        // 报警/事件列表总数
        private Integer alarmEventNum;
        // 报警/事件信息列表
        private ArrayList<AlarmEvent> alarmEvents;

        public static class AlarmEvent {
            // 胎压报警位置
            private Integer tirePressureLocation;
            // 报警/事件类型
            private Integer alarmEventType;
            // 胎压
            private Integer tirePressure;
            // 胎温
            private Integer tireTemperature;
            // 电池电量
            private Integer battery;

            @Property(index = 0, type = DataType.BYTE)
            public Integer getTirePressureLocation() {
                return tirePressureLocation;
            }

            public void setTirePressureLocation(Integer tirePressureLocation) {
                this.tirePressureLocation = tirePressureLocation;
            }

            @Property(index = 1, type = DataType.WORD)
            public Integer getAlarmEventType() {
                return alarmEventType;
            }

            public void setAlarmEventType(Integer alarmEventType) {
                this.alarmEventType = alarmEventType;
            }

            @Property(index = 3, type = DataType.WORD)
            public Integer getTirePressure() {
                return tirePressure;
            }

            public void setTirePressure(Integer tirePressure) {
                this.tirePressure = tirePressure;
            }

            @Property(index = 5, type = DataType.WORD)
            public Integer getTireTemperature() {
                return tireTemperature;
            }

            public void setTireTemperature(Integer tireTemperature) {
                this.tireTemperature = tireTemperature;
            }

            @Property(index = 7, type = DataType.WORD)
            public Integer getBattery() {
                return battery;
            }

            public void setBattery(Integer battery) {
                this.battery = battery;
            }

            @Override
            public String toString() {
                return "{" +
                        " \"tirePressureLocation\" : " + tirePressureLocation +
                        ", \"alarmEventType\" : " + alarmEventType +
                        ", \"tirePressure\" : " + tirePressure +
                        ", \"tireTemperature\" : " + tireTemperature +
                        ", \"battery\" : " + battery +
                        " }";
            }
        }

        @Property(index = 0, type = DataType.DWORD)
        public Integer getAlarmId() {
            return alarmId;
        }

        public void setAlarmId(Integer alarmId) {
            this.alarmId = alarmId;
        }

        @Property(index = 4, type = DataType.BYTE)
        public Integer getFlag() {
            return flag;
        }

        public void setFlag(Integer flag) {
            this.flag = flag;
        }

        @Property(index = 5, type = DataType.BYTE)
        public Integer getSpeed() {
            return speed;
        }

        public void setSpeed(Integer speed) {
            this.speed = speed;
        }

        @Property(index = 6, type = DataType.WORD)
        public Integer getElevation() {
            return elevation;
        }

        public void setElevation(Integer elevation) {
            this.elevation = elevation;
        }

        @Property(index = 8, type = DataType.DWORD)
        public Integer getLatitude() {
            return latitude;
        }

        public void setLatitude(Integer latitude) {
            this.latitude = latitude;
        }

        @Property(index = 12, type = DataType.DWORD)
        public Integer getLongitude() {
            return longitude;
        }

        public void setLongitude(Integer longitude) {
            this.longitude = longitude;
        }

        @Property(index = 16, type = DataType.BCD8421, length = 6)
        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Property(index = 22, type = DataType.WORD)
        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        @Property(index = 24, type = DataType.BYTES, length = 16)
        public byte[] getAlarmFlag() {
            return alarmFlag;
        }

        public void setAlarmFlag(byte[] alarmFlag) {
            this.alarmFlag = alarmFlag;
        }

        @Property(index = 39, type = DataType.BYTE)
        public Integer getAlarmEventNum() {
            return alarmEventNum;
        }

        public void setAlarmEventNum(Integer alarmEventNum) {
            this.alarmEventNum = alarmEventNum;
        }

        @Property(index = 40, type = DataType.OBJ)
        public ArrayList<AlarmEvent> getAlarmEvents() {
            return alarmEvents;
        }

        public void setAlarmEvents(ArrayList<AlarmEvent> alarmEvents) {
            this.alarmEvents = alarmEvents;
        }

        @Override
        public String toString() {
            return "{" +
                    " \"alarmId\" : " + alarmId +
                    ", \"flag\" : " + flag +
                    ", \"speed\" : " + speed +
                    ", \"elevation\" : " + elevation +
                    ", \"latitude\" : " + latitude +
                    ", \"longitude\" : " + longitude +
                    ", \"time\" : " + time +
                    ", \"status\" : " + status +
                    ", \"alarmFlag\" : " + new String(alarmFlag) +
                    ", \"alarmEventNum\" : " + alarmEventNum +
                    ", \"alarmEvents\" : " + alarmEvents.toString() +
                    " }";
        }
    }

    public static class BlindAreaMonitoringSystemAlarm {
        // 报警 ID
        private Integer alarmId;
        // 标志状态
        private Integer flag;
        // 报警/事件类型
        private Integer alarmType;
        // 车速
        private Integer speed;
        // 高程
        private Integer elevation;
        // 纬度
        private Integer latitude;
        // 经度
        private Integer longitude;
        // 日期时间
        private String time;
        // 车辆状态
        private Integer status;
        // 报警标识号
        private byte[] alarmFlag;

        @Property(index = 0, type = DataType.DWORD)
        public Integer getAlarmId() {
            return alarmId;
        }

        public void setAlarmId(Integer alarmId) {
            this.alarmId = alarmId;
        }

        @Property(index = 4, type = DataType.BYTE)
        public Integer getFlag() {
            return flag;
        }

        public void setFlag(Integer flag) {
            this.flag = flag;
        }

        @Property(index = 5, type = DataType.BYTE)
        public Integer getAlarmType() {
            return alarmType;
        }

        public void setAlarmType(Integer alarmType) {
            this.alarmType = alarmType;
        }

        @Property(index = 6, type = DataType.BYTE)
        public Integer getSpeed() {
            return speed;
        }

        public void setSpeed(Integer speed) {
            this.speed = speed;
        }

        @Property(index = 7, type = DataType.WORD)
        public Integer getElevation() {
            return elevation;
        }

        public void setElevation(Integer elevation) {
            this.elevation = elevation;
        }

        @Property(index = 9, type = DataType.DWORD)
        public Integer getLatitude() {
            return latitude;
        }

        public void setLatitude(Integer latitude) {
            this.latitude = latitude;
        }

        @Property(index = 13, type = DataType.DWORD)
        public Integer getLongitude() {
            return longitude;
        }

        public void setLongitude(Integer longitude) {
            this.longitude = longitude;
        }

        @Property(index = 17, type = DataType.BCD8421, length = 6)
        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Property(index = 23, type = DataType.WORD)
        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        @Property(index = 25, type = DataType.BYTES, length = 16)
        public byte[] getAlarmFlag() {
            return alarmFlag;
        }

        public void setAlarmFlag(byte[] alarmFlag) {
            this.alarmFlag = alarmFlag;
        }

        @Override
        public String toString() {
            return "{" +
                    " \"alarmId\" : " + alarmId +
                    ", \"flag\" : " + flag +
                    ", \"alarmType\" : " + alarmType +
                    ", \"speed\" : " + speed +
                    ", \"elevation\" : " + elevation +
                    ", \"latitude\" : " + latitude +
                    ", \"longitude\" : " + longitude +
                    ", \"time\" : " + time +
                    ", \"status\" : " + status +
                    ", \"alarmFlag\" : " + new String(alarmFlag) +
                    " }";
        }
    }



    @Property(index = 2, type = DataType.DWORD, enumType = 0x01)
    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    @Property(index = 2, type = DataType.WORD, enumType = 0x02)
    public Integer getOilQuantity() {
        return oilQuantity;
    }

    public void setOilQuantity(Integer oilQuantity) {
        this.oilQuantity = oilQuantity;
    }

    @Property(index = 2, type = DataType.WORD, enumType = 0x03)
    public Integer getCarSpeed() {
        return carSpeed;
    }

    public void setCarSpeed(Integer carSpeed) {
        this.carSpeed = carSpeed;
    }

    @Property(index = 2, type = DataType.WORD, enumType = 0x04)
    public Integer getWarningId() {
        return warningId;
    }

    public void setWarningId(Integer warningId) {
        this.warningId = warningId;
    }

    @Property(index = 2, type = DataType.OBJ, lengthName = "length", enumType = 0x11)
    public SpeedingExtraData getSpeedingExtraData() {
        return speedingExtraData;
    }

    public void setSpeedingExtraData(SpeedingExtraData speedingExtraData) {
        this.speedingExtraData = speedingExtraData;
    }

    @Property(index = 2, type = DataType.OBJ, length = 6, enumType = 0x12)
    public LocationExtraData getLocationExtraData() {
        return locationExtraData;
    }

    public void setLocationExtraData(LocationExtraData locationExtraData) {
        this.locationExtraData = locationExtraData;
    }

    @Property(index = 2, type = DataType.OBJ, length = 7, enumType = 0x13)
    public LocationInfoExtraData getLocationInfoExtraData() {
        return locationInfoExtraData;
    }

    public void setLocationInfoExtraData(LocationInfoExtraData locationInfoExtraData) {
        this.locationInfoExtraData = locationInfoExtraData;
    }

    @Property(index = 2, type = DataType.DWORD, enumType = 0x25)
    public Integer getExtraCarState() {
        return extraCarState;
    }

    public void setExtraCarState(Integer extraCarState) {
        this.extraCarState = extraCarState;

        // 1:近光灯信号
        this.lowLightSignal = ((extraCarState) & 0x01) == 1;
        // 1:远光灯信号
        this.farLightSignal = ((extraCarState >>> 1) & 0x01) == 1;
        //　1:右转向灯信号
        this.rightLightSignal = ((extraCarState >>> 2) & 0x01) == 1;
        //　1:左转向灯信号
        this.leftLightSignal = ((extraCarState >>> 3) & 0x01) == 1;
        //　1:制动信号
        this.brakingSignal = ((extraCarState >>> 4) & 0x01) == 1;
        //　1:倒档信号
        this.reverseSignal = ((extraCarState >>> 5) & 0x01) == 1;
        //　1:雾灯信号
        this.fogLampSignal = ((extraCarState >>> 6) & 0x01) == 1;
        //　1:示廓灯
        this.outlineLamp = ((extraCarState >>> 7) & 0x01) == 1;
        //　1:喇叭信号
        this.hornSignal = ((extraCarState >>> 8) & 0x01) == 1;
        //　1:空调状态
        this.airCondition = ((extraCarState >>> 9) & 0x01) == 1;
        //　1:空挡信号
        this.neutralSignal = ((extraCarState >>> 10) & 0x01) == 1;
        //　1:缓速器工作
        this.retarderOperation = ((extraCarState >>> 11) & 0x01) == 1;
        //　1:ABS 工作
        this.ABSOperation = ((extraCarState >>> 12) & 0x01) == 1;
        //　1:加热器工作
        this.heaterOperation = ((extraCarState >>> 13) & 0x01) == 1;
        //　1:离合器状态
        this.clutchState = ((extraCarState >>> 14) & 0x01) == 1;
    }

    @Property(index = 2, type = DataType.WORD, enumType = 0x2A)
    public Integer getIoState() {
        return ioState;
    }

    public void setIoState(Integer ioState) {
        this.ioState = ioState;

        // 1:深度休眠状态
        this.deepDormancy = ((ioState >>> 15) & 0x01) == 1;
        // 1:休眠状态
        this.dormancy = ((ioState >>> 14) & 0x01) == 1;
    }

    @Property(index = 2, type = DataType.DWORD, enumType = 0x2B)
    public Integer getSimulation() {
        return simulation;
    }

    public void setSimulation(Integer simulation) {
        this.simulation = simulation;
    }

    @Property(index = 2, type = DataType.BYTE, enumType = 0x30)
    public Integer getWirelessIntensity() {
        return wirelessIntensity;
    }

    public void setWirelessIntensity(Integer wirelessIntensity) {
        this.wirelessIntensity = wirelessIntensity;
    }

    @Property(index = 2, type = DataType.BYTE, enumType = 0x31)
    public Integer getSatellitesNum() {
        return satellitesNum;
    }

    public void setSatellitesNum(Integer satellitesNum) {
        this.satellitesNum = satellitesNum;
    }

    @Property(index = 2, type = DataType.DWORD, enumType = 0x14)
    public Integer getVideoAlarm() {
        return videoAlarm;
    }

    public void setVideoAlarm(Integer videoAlarm) {
        this.videoAlarm = videoAlarm;
    }

    @Property(index = 2, type = DataType.DWORD, enumType = 0x15)
    public Integer getVideoLostAlarm() {
        return videoLostAlarm;
    }

    public void setVideoLostAlarm(Integer videoLostAlarm) {
        this.videoLostAlarm = videoLostAlarm;
    }

    @Property(index = 2, type = DataType.DWORD, enumType = 0x16)
    public Integer getVideoShieldAlarm() {
        return videoShieldAlarm;
    }

    public void setVideoShieldAlarm(Integer videoShieldAlarm) {
        this.videoShieldAlarm = videoShieldAlarm;
    }

    @Property(index = 2, type = DataType.WORD, enumType = 0x17)
    public Integer getStorageAlarm() {
        return storageAlarm;
    }

    public void setStorageAlarm(Integer storageAlarm) {
        this.storageAlarm = storageAlarm;
    }

    @Property(index = 2, type = DataType.OBJ, length = 3, enumType = 0x18)
    public ExceptionDriveType getExceptionDriveType() {
        return exceptionDriveType;
    }

    public void setExceptionDriveType(ExceptionDriveType exceptionDriveType) {
        this.exceptionDriveType = exceptionDriveType;
    }

    @Property(index = 2, type = DataType.OBJ, lengthName = "length", enumType = 0x64)
    public AdvancedDrivingAssistanceAlarm getAdvancedDrivingAssistanceAlarm() {
        return advancedDrivingAssistanceAlarm;
    }

    public void setAdvancedDrivingAssistanceAlarm(AdvancedDrivingAssistanceAlarm advancedDrivingAssistanceAlarm) {
        this.advancedDrivingAssistanceAlarm = advancedDrivingAssistanceAlarm;
    }

    @Property(index = 2, type = DataType.OBJ, lengthName = "length", enumType = 0x65)
    public DriverConditionMonitoringSystemAlarm getDriverConditionMonitoringSystemAlarm() {
        return driverConditionMonitoringSystemAlarm;
    }

    public void setDriverConditionMonitoringSystemAlarm(DriverConditionMonitoringSystemAlarm driverConditionMonitoringSystemAlarm) {
        this.driverConditionMonitoringSystemAlarm = driverConditionMonitoringSystemAlarm;
    }

    @Property(index = 2, type = DataType.OBJ, lengthName = "length", enumType = 0x66)
    public TirePressureMonitoringSystemAlarm getTirePressureMonitoringSystemAlarm() {
        return tirePressureMonitoringSystemAlarm;
    }

    public void setTirePressureMonitoringSystemAlarm(TirePressureMonitoringSystemAlarm tirePressureMonitoringSystemAlarm) {
        this.tirePressureMonitoringSystemAlarm = tirePressureMonitoringSystemAlarm;
    }

    @Property(index = 2, type = DataType.OBJ, lengthName = "length", enumType = 0x67)
    public BlindAreaMonitoringSystemAlarm getBlindAreaMonitoringSystemAlarm() {
        return blindAreaMonitoringSystemAlarm;
    }

    public void setBlindAreaMonitoringSystemAlarm(BlindAreaMonitoringSystemAlarm blindAreaMonitoringSystemAlarm) {
        this.blindAreaMonitoringSystemAlarm = blindAreaMonitoringSystemAlarm;
    }


    @Override
    public String toString() {
        switch (type) {
            case 0x01:
                return ", \"mileage\" : " + mileage;
            case 0x02:
                return ", \"oilQuantity\" : " + oilQuantity;
            case 0x03:
                return ", \"carSpeed\" : " + carSpeed;
            case 0x04:
                return ", \"warningId\" : " + warningId;
            case 0x11:
                return ", \"speedingExtraData\" : " + speedingExtraData;
            case 0x12:
                return ", \"locationExtraData\" : " + locationExtraData;
            case 0x13:
                return ", \"locationInfoExtraData\" : " + locationInfoExtraData;
            case 0x25:
                return ", \"lowLightSignal\" : " + lowLightSignal + ", \"farLightSignal\" : "
                        + farLightSignal + ", \"rightLightSignal\" : " + rightLightSignal + ", \"leftLightSignal\" : "
                        + leftLightSignal + ", \"brakingSignal\" : " + brakingSignal + ", \"reverseSignal\" : " + reverseSignal
                        + ", \"fogLampSignal\" : " + fogLampSignal + ", \"outlineLamp\" : " + outlineLamp + ", \"hornSignal\" : "
                        + hornSignal + ", \"airCondition\" : " + airCondition + ", \"neutralSignal\" : " + neutralSignal
                        + ", \"retarderOperation\" : " + retarderOperation + ", \"ABSOperation\" : " + ABSOperation
                        + ", \"heaterOperation\" : " + heaterOperation + ", \"clutchState\" : " + clutchState;
            case 0x2A:
                return ", \"deepDormancy\" : " + deepDormancy + ", \"dormancy\" : " + dormancy;
            case 0x2B:
                return ", \"simulation\" : " + simulation;
            case 0x30:
                return ", \"wirelessIntensity\" : " + wirelessIntensity;
            case 0x31:
                return ", \"satellitesNum\" : " + satellitesNum;
            case 0x14:
                return ", \"videoAlarm\" : " + videoAlarm;
            case 0x15:
                return ", \"videoLostAlarm\" : " + videoLostAlarm;
            case 0x16:
                return ", \"videoShieldAlarm\" : " + videoShieldAlarm;
            case 0x17:
                return ", \"storageAlarm\" : " + storageAlarm;
            case 0x18:
                return ", \"exceptionDriveType\" : " + exceptionDriveType.toString();
            case 0x64:
                return ", \"advancedDrivingAssistanceAlarm\" : " + advancedDrivingAssistanceAlarm.toString();
            case 0x65:
                return ", \"driverConditionMonitoringSystemAlarm\" : " + driverConditionMonitoringSystemAlarm.toString();
            case 0x66:
                return ", \"tirePressureMonitoringSystemAlarm\" : " + tirePressureMonitoringSystemAlarm.toString();
            case 0x67:
                return ", \"blindAreaMonitoringSystemAlarm\" : " + blindAreaMonitoringSystemAlarm.toString();

        }
        return "";
    }
}

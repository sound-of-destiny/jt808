package cn.edu.sdu.jt808.protocol.upMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.protocol.Header;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;

import java.util.List;

/**
 *
 * 位置信息汇报消息
 *
 */

@MsgType(MessageId.msg_id_terminal_location)
public class Location extends PackageData<Header> {

    //报警标志 byte[0-3]
    private Integer warningFlag;

    //状态 byte[4-7]
    private Integer status;

    //纬度 byte[8-11]
    private Integer latitude;

    //经度 byte[12-15]
    private Integer longitude;

    //高程 byte[16-17]
    private Integer elevation;

    //速度 byte[18-19]
    private Integer speed;

    //方向 byte[20-21]
    private Integer direction;

    //时间(BCD[6] YY-MM-DD-hh-mm-ss) byte[22-27]
    private String time;

    // 位置附加信息项
    private List<ExtraLocation> extraLocations;



    @Property(index = 0, type = DataType.DWORD, desc = "报警标志")
    public Integer getWarningFlag() {
        return warningFlag;
    }

    public void setWarningFlag(Integer warningFlag) {
        this.warningFlag = warningFlag;

        this.flag = ((warningFlag >>> 31) & 0x01) == 1;
        this.overSpeeding = ((warningFlag >>> 30) & 0x01) == 1;
        this.overTired = ((warningFlag >>> 29) & 0x01) == 1;
        this.dangerous = ((warningFlag >>> 28) & 0x01) == 1;
        this.GNSSFault = ((warningFlag >>> 27) & 0x01) == 1;
        this.GNSSAntennaFault = ((warningFlag >>> 26) & 0x01) == 1;
        this.GNSSAntennaShortCircuit = ((warningFlag >>> 25) & 0x01) == 1;
        this.terminalMainPowerUnderVoltage = ((warningFlag >>> 24) & 0x01) == 1;
        this.terminalMainPowerFailure = ((warningFlag >>> 23) & 0x01) == 1;
        this.terminalLCDFault = ((warningFlag >>> 22) & 0x01) == 1;
        this.TTSFault = ((warningFlag >>> 21) & 0x01) == 1;
        this.cameraFault = ((warningFlag >>> 20) & 0x01) == 1;
        this.ICCardFault = ((warningFlag >>> 19) & 0x01) == 1;
        this.speeding = ((warningFlag >>> 18) & 0x01) == 1;
        this.tired = ((warningFlag >>> 14) & 0x01) == 1;
        this.driveTimeout = ((warningFlag >>> 13) & 0x01) == 1;
        this.parkingOvertime = ((warningFlag >>> 12) & 0x01) == 1;
        this.throughArea = ((warningFlag >>> 11) & 0x01) == 1;
        this.throughRoad = ((warningFlag >>> 10) & 0x01) == 1;
        this.roadTimeout = ((warningFlag >>> 9) & 0x01) == 1;
        this.roadFault = ((warningFlag >>> 8) & 0x01) == 1;
        this.VSSFault = ((warningFlag >>> 7) & 0x01) == 1;
        this.vehicleOilException = ((warningFlag >>> 6) & 0x01) == 1;
        this.vehicleTheft = ((warningFlag >>> 5) & 0x01) == 1;
        this.vehicleIllegalIgnition = ((warningFlag >>> 4) & 0x01) == 1;
        this.vehicleIllegalShift = ((warningFlag >>> 3) & 0x01) == 1;
        this.collisionWarning = ((warningFlag >>> 2) & 0x01) == 1;
        this.rolloverWarning = ((warningFlag >>> 1) & 0x01) == 1;
        this.illegalOpenDoor = ((warningFlag) & 0x01) == 1;

    }

    @Property(index = 4, type = DataType.DWORD, desc = "状态")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;

        this.ACC = ((status >>> 31) & 0x01) == 1;
        this.isLocation = ((status >>> 30) & 0x01) == 1;
        this.hasLatitude = ((status >>> 29) & 0x01) == 1;
        this.hasLongitude = ((status >>> 28) & 0x01) == 1;
        this.isRunning = ((status >>> 27) & 0x01) == 1;
        this.encrypt = ((status >>> 26) & 0x01) == 1;
        this.goodsStatus =  (status >>> 31) & 0x03;
        this.vehicleOil = ((status >>> 22) & 0x01) == 1;
        this.vehicleCircut = ((status >>>20) & 0x01) == 1;
        this.doorLock = ((status >>> 19) & 0x01) == 1;
        this.frontDoorOpen = ((status >>> 18) & 0x01) == 1;
        this.middleDoorOpen = ((status >>> 17) & 0x01) == 1;
        this.endDoorOpen = ((status >>> 16) & 0x01) == 1;
        this.driverDoorOpen = ((status >>> 15) & 0x01) == 1;
        this.otherDoorOpen = ((status >>> 14) & 0x01) == 1;
        this.GPS = ((status >>> 13) & 0x01) == 1;
        this.beidou = ((status >>> 12) & 0x01) == 1;
        this.GLONASS = ((status >>> 11) & 0x01) == 1;
        this.Galileo = ((status >>> 10) & 0x01) == 1;
    }

    @Property(index = 8, type = DataType.DWORD, desc = "纬度")
    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    @Property(index = 12, type = DataType.DWORD, desc = "经度")
    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    @Property(index = 16, type = DataType.WORD, desc = "海拔")
    public Integer getElevation() {
        return elevation;
    }

    public void setElevation(Integer elevation) {
        this.elevation = elevation;
    }

    @Property(index = 18, type = DataType.WORD, desc = "速度")
    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    @Property(index = 20, type = DataType.WORD, desc = "方向")
    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    @Property(index = 22, type = DataType.BCD8421, length = 6, desc = "时间")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Property(index = 28, type = DataType.LIST, desc = "位置附加信息")
    public List<ExtraLocation> getExtraLocations() {
        return extraLocations;
    }

    public void setExtraLocations(List<ExtraLocation> extraLocations) {
        this.extraLocations = extraLocations;
    }

    @Override
    public String toString() {
        return  " \"waringflag\" : " + flag + ", \"overSpeeding\" : " + overSpeeding + ", \"overTired\" : "
                + overTired + ", \"dangeous\" : " + dangerous + ", \"GNSSFault\" : "
                + GNSSFault + ", \"GNSSAntennaFault\" : " + GNSSAntennaFault + ", \"GNSSAntennaShortCircuit\" : "
                + GNSSAntennaShortCircuit + ", \"terminalMainPowerUndervoltage\" : " + terminalMainPowerUnderVoltage
                + ", \"terminalMainPowerFailure\" : " + terminalMainPowerFailure + ", \"TerminalLCDFault\" : "
                + terminalLCDFault + ", \"TTSFault\" : " + TTSFault + ", \"cameraFault\" : " + cameraFault
                + ", \"ICCardFault\" : " + ICCardFault + ", \"speeding\" : " + speeding + ", \"tired\" : "
                + tired + ", \"driveTimeout\" : " + driveTimeout + ", \"parkingOvertime\" : " + parkingOvertime
                + ", \"throughArea\" : " + throughArea + ", \"throughRoad\" : " + throughRoad
                + ", \"roadTimeout\" : " + roadTimeout + ", \"roadFault\" : " + roadFault + ", \"VSSFault\" : "
                + VSSFault + ", \"vehicleOilException\" : " + vehicleOilException + ", \"vehicleTheft\" : "
                + vehicleTheft + ", \"vehicleIllegalIgnition\" : " + vehicleIllegalIgnition + ", \"vehicleIllegalShift\" : "
                + vehicleIllegalShift + ", \"collisionWarning\" : " + collisionWarning + ", \"rolloverWarning\" : "
                + rolloverWarning + ", \"illegalOpenDoor\" : " + illegalOpenDoor + ", \"ACC\" : " + ACC + ", \"isLocation\" : "
                + isLocation + ", \"latitude\" : " + latitude + ", \"longitude\" : " + longitude + ", \"isRunning\" : "
                + isRunning + ", \"encrypt\" : " + encrypt + ", \"goodsStatus\" : "
                + goodsStatus + ", \"vehicleOil\" : " + vehicleOil + ", \"vehicleCircut\" : "
                + vehicleCircut + ", \"doorLock\" : " + doorLock + ", \"frontDoorOpen\" : "
                + frontDoorOpen + ", \"middleDoorOpen\" : " + middleDoorOpen + ", \"endDoorOpen\" : "
                + endDoorOpen + ", \"driverDoorOpen\" : " + driverDoorOpen + ", \"otherDoorOpen\" : "
                + otherDoorOpen + ", \"GPS\" : " + GPS + ", \"beidou\" : " + beidou + ", \"GLONASS\" : "
                + GLONASS + ", \"Galileo\" : " + Galileo + ", \"latitude\" : "
                + latitude + ", \"longitude\" : " + longitude + ", \"elevation\" : " + elevation
                + ", \"speed\" : " + speed + ", \"direction\" : " + direction + ", \"time\" : \"" + time
                + "\" ";
    }


    // 0:紧急报警,触动报警开关后触发
    private boolean flag;
    // 1:超速报警
    private boolean overSpeeding;
    // 2:疲劳驾驶
    private boolean overTired;
    // 3:危险预警
    private boolean dangerous;
    // 4:GNSS 模块发生故障
    private boolean GNSSFault;
    // 5:GNSS 天线未接或被剪断
    private boolean GNSSAntennaFault;
    // 6:GNSS 天线短路
    private boolean GNSSAntennaShortCircuit;
    // 7:终端主电源欠压
    private boolean terminalMainPowerUnderVoltage;
    // 8:终端主电源掉电
    private boolean terminalMainPowerFailure;
    // 9:终端 LCD 或显示器故障
    private boolean terminalLCDFault;
    // 10:TTS 模块故障
    private boolean TTSFault;
    // 11:摄像头故障
    private boolean cameraFault;
    // 12:道路运输证 IC 卡模块故障
    private boolean ICCardFault;
    // 13:超速预警
    private boolean speeding;
    // 14:疲劳驾驶预警
    private boolean tired;
    // 18:当天累计驾驶超时
    private boolean driveTimeout;
    // 19:超时停车
    private boolean parkingOvertime;
    // 20:进出区域
    private boolean throughArea;
    // 21:进出路线
    private boolean throughRoad;
    // 22:路段行驶时间不足/过长
    private boolean roadTimeout;
    // 23:路线偏离报警
    private boolean roadFault;
    // 24:车辆 VSS 故障
    private boolean VSSFault;
    // 25:车辆油量异常
    private boolean vehicleOilException;
    // 26:车辆被盗(通过车辆防盗器)
    private boolean vehicleTheft;
    // 27:车辆非法点火
    private boolean vehicleIllegalIgnition;
    // 28:车辆非法位移
    private boolean vehicleIllegalShift;
    // 29:碰撞预警
    private boolean collisionWarning;
    // 30:侧翻预警
    private boolean rolloverWarning;
    // 31:非法开门报警(终端未设置区域时,不判断非法开门)
    private boolean illegalOpenDoor;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isOverSpeeding() {
        return overSpeeding;
    }

    public void setOverSpeeding(boolean overSpeeding) {
        this.overSpeeding = overSpeeding;
    }

    public boolean isOverTired() {
        return overTired;
    }

    public void setOverTired(boolean overTired) {
        this.overTired = overTired;
    }

    public boolean isDangerous() {
        return dangerous;
    }

    public void setDangerous(boolean dangerous) {
        this.dangerous = dangerous;
    }

    public boolean isGNSSFault() {
        return GNSSFault;
    }

    public void setGNSSFault(boolean GNSSFault) {
        this.GNSSFault = GNSSFault;
    }

    public boolean isGNSSAntennaFault() {
        return GNSSAntennaFault;
    }

    public void setGNSSAntennaFault(boolean GNSSAntennaFault) {
        this.GNSSAntennaFault = GNSSAntennaFault;
    }

    public boolean isGNSSAntennaShortCircuit() {
        return GNSSAntennaShortCircuit;
    }

    public void setGNSSAntennaShortCircuit(boolean GNSSAntennaShortCircuit) {
        this.GNSSAntennaShortCircuit = GNSSAntennaShortCircuit;
    }

    public boolean isTerminalMainPowerUnderVoltage() {
        return terminalMainPowerUnderVoltage;
    }

    public void setTerminalMainPowerUnderVoltage(boolean terminalMainPowerUnderVoltage) {
        this.terminalMainPowerUnderVoltage = terminalMainPowerUnderVoltage;
    }

    public boolean isTerminalMainPowerFailure() {
        return terminalMainPowerFailure;
    }

    public void setTerminalMainPowerFailure(boolean terminalMainPowerFailure) {
        this.terminalMainPowerFailure = terminalMainPowerFailure;
    }

    public boolean isTerminalLCDFault() {
        return terminalLCDFault;
    }

    public void setTerminalLCDFault(boolean terminalLCDFault) {
        this.terminalLCDFault = terminalLCDFault;
    }

    public boolean isTTSFault() {
        return TTSFault;
    }

    public void setTTSFault(boolean TTSFault) {
        this.TTSFault = TTSFault;
    }

    public boolean isCameraFault() {
        return cameraFault;
    }

    public void setCameraFault(boolean cameraFault) {
        this.cameraFault = cameraFault;
    }

    public boolean isICCardFault() {
        return ICCardFault;
    }

    public void setICCardFault(boolean ICCardFault) {
        this.ICCardFault = ICCardFault;
    }

    public boolean isSpeeding() {
        return speeding;
    }

    public void setSpeeding(boolean speeding) {
        this.speeding = speeding;
    }

    public boolean isTired() {
        return tired;
    }

    public void setTired(boolean tired) {
        this.tired = tired;
    }

    public boolean isDriveTimeout() {
        return driveTimeout;
    }

    public void setDriveTimeout(boolean driveTimeout) {
        this.driveTimeout = driveTimeout;
    }

    public boolean isParkingOvertime() {
        return parkingOvertime;
    }

    public void setParkingOvertime(boolean parkingOvertime) {
        this.parkingOvertime = parkingOvertime;
    }

    public boolean isThroughArea() {
        return throughArea;
    }

    public void setThroughArea(boolean throughArea) {
        this.throughArea = throughArea;
    }

    public boolean isThroughRoad() {
        return throughRoad;
    }

    public void setThroughRoad(boolean throughRoad) {
        this.throughRoad = throughRoad;
    }

    public boolean isRoadTimeout() {
        return roadTimeout;
    }

    public void setRoadTimeout(boolean roadTimeout) {
        this.roadTimeout = roadTimeout;
    }

    public boolean isRoadFault() {
        return roadFault;
    }

    public void setRoadFault(boolean roadFault) {
        this.roadFault = roadFault;
    }

    public boolean isVSSFault() {
        return VSSFault;
    }

    public void setVSSFault(boolean VSSFault) {
        this.VSSFault = VSSFault;
    }

    public boolean isVehicleOilException() {
        return vehicleOilException;
    }

    public void setVehicleOilException(boolean vehicleOilException) {
        this.vehicleOilException = vehicleOilException;
    }

    public boolean isVehicleTheft() {
        return vehicleTheft;
    }

    public void setVehicleTheft(boolean vehicleTheft) {
        this.vehicleTheft = vehicleTheft;
    }

    public boolean isVehicleIllegalIgnition() {
        return vehicleIllegalIgnition;
    }

    public void setVehicleIllegalIgnition(boolean vehicleIllegalIgnition) {
        this.vehicleIllegalIgnition = vehicleIllegalIgnition;
    }

    public boolean isVehicleIllegalShift() {
        return vehicleIllegalShift;
    }

    public void setVehicleIllegalShift(boolean vehicleIllegalShift) {
        this.vehicleIllegalShift = vehicleIllegalShift;
    }

    public boolean isCollisionWarning() {
        return collisionWarning;
    }

    public void setCollisionWarning(boolean collisionWarning) {
        this.collisionWarning = collisionWarning;
    }

    public boolean isRolloverWarning() {
        return rolloverWarning;
    }

    public void setRolloverWarning(boolean rolloverWarning) {
        this.rolloverWarning = rolloverWarning;
    }

    public boolean isIllegalOpenDoor() {
        return illegalOpenDoor;
    }

    public void setIllegalOpenDoor(boolean illegalOpenDoor) {
        this.illegalOpenDoor = illegalOpenDoor;
    }

    // 0:ACC 关;1: ACC 开
    private boolean ACC;
    // 0:未定位;1:定位
    private boolean isLocation;
    // 0:北纬;1:南纬
    private boolean hasLatitude;
    // 0:东经;1:西经
    private boolean hasLongitude;
    // 0:运营状态;1:停运状态
    private boolean isRunning;
    // 0:经纬度未经保密插件加密;1:经纬度已经保密插件加密
    private boolean encrypt;
    // 00:空车;01:半载;10:保留;11:满载 (可用于客车的空、重车及货车的空载、满载状态表示,人工输入或传感器获取)
    private int goodsStatus;
    // 0:车辆油路正常;1:车辆油路断开
    private boolean vehicleOil;
    // 0:车辆电路正常;1:车辆电路断开
    private boolean vehicleCircut;
    // 0:车门解锁;1:车门加锁
    private boolean doorLock;
    // 0:门关; 1:门开(前门)
    private boolean frontDoorOpen;
    // 0:门关; 1:门开(中门)
    private boolean middleDoorOpen;
    // 0:门关; 1:门开(后门)
    private boolean endDoorOpen;
    // 0:门关; 1:门开(驾驶席门)
    private boolean driverDoorOpen;
    // 0:门关; 1:门开(自定义)
    private boolean otherDoorOpen;
    // 0:未使用 GPS 卫星进行定位;1:使用 GPS 卫星进行定位
    private boolean GPS;
    // 0:未使用北斗卫星进行定位;1:使用北斗卫星进行定位
    private boolean beidou;
    // 0:未使用 GLONASS 卫星进行定位;1:使用 GLONASS 卫星进行定位
    private boolean GLONASS;
    // 0:未使用 Galileo 卫星进行定位;1:使用 Galileo 卫星进行定位
    private boolean Galileo;

    public boolean isACC() {
        return ACC;
    }

    public void setACC(boolean ACC) {
        this.ACC = ACC;
    }

    public boolean isLocation() {
        return isLocation;
    }

    public void setLocation(boolean location) {
        isLocation = location;
    }

    public boolean isHasLatitude() {
        return hasLatitude;
    }

    public void setHasLatitude(boolean hasLatitude) {
        this.hasLatitude = hasLatitude;
    }

    public boolean isHasLongitude() {
        return hasLongitude;
    }

    public void setHasLongitude(boolean hasLongitude) {
        this.hasLongitude = hasLongitude;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public boolean isEncrypt() {
        return encrypt;
    }

    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
    }

    public int getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(int goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public boolean isVehicleOil() {
        return vehicleOil;
    }

    public void setVehicleOil(boolean vehicleOil) {
        this.vehicleOil = vehicleOil;
    }

    public boolean isVehicleCircut() {
        return vehicleCircut;
    }

    public void setVehicleCircut(boolean vehicleCircut) {
        this.vehicleCircut = vehicleCircut;
    }

    public boolean isDoorLock() {
        return doorLock;
    }

    public void setDoorLock(boolean doorLock) {
        this.doorLock = doorLock;
    }

    public boolean isFrontDoorOpen() {
        return frontDoorOpen;
    }

    public void setFrontDoorOpen(boolean frontDoorOpen) {
        this.frontDoorOpen = frontDoorOpen;
    }

    public boolean isMiddleDoorOpen() {
        return middleDoorOpen;
    }

    public void setMiddleDoorOpen(boolean middleDoorOpen) {
        this.middleDoorOpen = middleDoorOpen;
    }

    public boolean isEndDoorOpen() {
        return endDoorOpen;
    }

    public void setEndDoorOpen(boolean endDoorOpen) {
        this.endDoorOpen = endDoorOpen;
    }

    public boolean isDriverDoorOpen() {
        return driverDoorOpen;
    }

    public void setDriverDoorOpen(boolean driverDoorOpen) {
        this.driverDoorOpen = driverDoorOpen;
    }

    public boolean isOtherDoorOpen() {
        return otherDoorOpen;
    }

    public void setOtherDoorOpen(boolean otherDoorOpen) {
        this.otherDoorOpen = otherDoorOpen;
    }

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
}

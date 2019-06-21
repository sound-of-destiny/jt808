package cn.edu.sdu.jt808.mapping;

import cn.edu.sdu.jt808.jtframework.annotation.Endpoint;
import cn.edu.sdu.jt808.jtframework.annotation.Mapping;
import cn.edu.sdu.jt808.jtframework.codec.ProtoBufCodec;
import cn.edu.sdu.jt808.jtframework.manager.MessageManager;
import cn.edu.sdu.jt808.jtframework.manager.PhotoManager;
import cn.edu.sdu.jt808.jtframework.message.PackageData;
import cn.edu.sdu.jt808.jtframework.message.PhotoFuture;
import cn.edu.sdu.jt808.protobuf.ServerData;
import cn.edu.sdu.jt808.protocol.CommonResponse;
import cn.edu.sdu.jt808.protocol.Header;
import cn.edu.sdu.jt808.protocol.RSAPack;
import cn.edu.sdu.jt808.protocol.Session;
import cn.edu.sdu.jt808.protocol.downMsg.AlarmFileUpload;
import cn.edu.sdu.jt808.protocol.downMsg.RegisterResponse;
import cn.edu.sdu.jt808.protocol.upMsg.*;
import cn.edu.sdu.jt808.server.manager.SessionManager;
import cn.edu.sdu.jt808.service.codec.JT808MessageEncoder;
import cn.edu.sdu.jt808.utils.JT808ProtocolUtil;
import cn.edu.sdu.jt808.utils.JedisPoolUtil;
import cn.edu.sdu.jt808.utils.MQUtil;
import com.google.gson.Gson;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

import java.nio.charset.Charset;
import java.util.UUID;

import static cn.edu.sdu.jt808.commons.MessageId.*;

@Slf4j
@Endpoint
public class JT808EndPoint {

    private JT808MessageEncoder encoder = new JT808MessageEncoder(Charset.forName("GBK"));
    private MessageManager messageManager = MessageManager.INSTANCE;
    private PhotoManager photoManager = PhotoManager.INSTANCE;
    private SessionManager sessionManager = SessionManager.getInstance();

    private final static String JT808 = "jt808";
    private final static String LOCATION = "location";
    private final static String DIGIT_WAYBILL = "digitWaybill";
    private final static String DRIVER_IDENTITY = "driverIdentity";
    private final static String PHOTO = "jt808_photo";

    @Mapping(types = msg_id_terminal_common_resp, desc = "终端通用应答")
    public void commonResponse(CommonResponse packageData) {
        Header header = packageData.getHeader();
        String terminalPhone = header.getTerminalPhone();
        Integer replyId = packageData.getReplyFlowId();
        ServerData.Protocol.Builder protocol = ServerData.Protocol.newBuilder();
        protocol.setProtoType(msg_id_terminal_common_resp);
        protocol.setTerminalPhone(terminalPhone);
        ServerData.CommonResponse.Builder builder = ServerData.CommonResponse.newBuilder();
        try {
            ServerData.CommonResponse data = (ServerData.CommonResponse)
                    ProtoBufCodec.javaBeanToProtoBean(packageData, builder);
            protocol.setCommonResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        messageManager.put(terminalPhone + replyId, protocol);
    }

    @Mapping(types = msg_id_terminal_heart_beat, desc = "终端心跳")
    public CommonResponse heartBeat(HeartBeat packageData) {
        Header header = packageData.getHeader();
        Header resultHeader = new Header(cmd_common_resp,
                sessionManager.currentFlowId(), header.getTerminalPhone());
        return new CommonResponse(resultHeader, msg_id_terminal_heart_beat, header.getFlowId(), CommonResponse.success);
    }

    @Mapping(types = msg_id_terminal_register, desc = "终端注册")
    public RegisterResponse terminalRegister(Register packageData) {
        Header header = packageData.getHeader();
        Header resultHeader = new Header(cmd_terminal_register_resp,
                sessionManager.currentFlowId(), header.getTerminalPhone());

        String authenticationCode = UUID.randomUUID().toString();

        RegisterResponse registerResponse = new RegisterResponse(resultHeader);

        Integer provinceId = packageData.getProvinceId();
        Integer cityId =  packageData.getCityId();
        String manufacturerId = packageData.getManufacturerId().trim();
        String terminalType = packageData.getTerminalType().trim();
        String terminalId = packageData.getTerminalId().trim();
        Integer licensePlateColor = packageData.getLicensePlateColor();
        String licensePlate = packageData.getLicensePlate().trim();
        /*try {
            Connection connection = JT808Mysql.connect_145();
            Statement statement = connection.createStatement();
            String sql = "select * from jt808server_register_msg where licensePlate = \'" + licensePlate + "\'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                registerResponse.setReplyCode(RegisterResponse.car_already_registered);
            } else {
                String sql1 = "select * from jt808server.jt808server_register_msg where terminalId = \'" + terminalId + "\'";
                ResultSet resultSet1 = statement.executeQuery(sql1);
                if (resultSet1.next()) {
                    registerResponse.setReplyCode(RegisterResponse.terminal_already_registered);
                } else {
                    String sql2 = "select * from jt808server.vehicle_info where plateNum = \'" + licensePlate + "\'";
                    ResultSet resultSet2 = statement.executeQuery(sql2);
                    if (!resultSet2.next()) {
                        registerResponse.setReplyCode(RegisterResponse.car_not_found);
                    } else {
                        String sql3= "select * from jt808server.terminal_info where terminalId = \'" + terminalId + "\'";
                        ResultSet resultSet3 = statement.executeQuery(sql3);
                        if (!resultSet3.next()) {
                            registerResponse.setReplyCode(RegisterResponse.terminal_not_found);
                        } else {
                            String sql4 = String.format("insert into jt808server.jt808server_register_msg (authenticationCode, provinceId, cityId, " +
                                            "manufacturerId, terminalType, terminalId, licensePlateColor, licensePlate) values ('%s', %d, %d, '%s', '%s', '%s', %d, '%s')",
                                    authenticationCode, provinceId, cityId, manufacturerId, terminalType, terminalId, licensePlateColor, licensePlate);
                            statement.execute(sql4);
                            registerResponse.setReplyCode(RegisterResponse.success);
                            registerResponse.setReplyToken(authenticationCode);
                        }
                    }
                }
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            log.error("数据库错误", e);
        }*/
        registerResponse.setReplyCode(RegisterResponse.success);
        registerResponse.setReplyToken(authenticationCode);
        registerResponse.setReplyFlowId(header.getFlowId());
        return registerResponse;
    }

    @Mapping(types = msg_id_terminal_log_out, desc = "终端注销")
    public CommonResponse terminalLogOut(Unregister packageData, Session session) {
        Header header = packageData.getHeader();
        Header resultHeader = new Header(cmd_common_resp,
                sessionManager.currentFlowId(), header.getTerminalPhone());
        // TODO 终端注销处理
        return new CommonResponse(resultHeader, msg_id_terminal_log_out, header.getFlowId(), CommonResponse.success);
    }

    @Mapping(types = msg_id_terminal_authentication, desc = "终端鉴权")
    public CommonResponse authentication(Authentication packageData, Session session) {
        Header header = packageData.getHeader();
        Header resultHeader = new Header(cmd_common_resp,
                sessionManager.currentFlowId(), header.getTerminalPhone());
        JT808ProtocolUtil.updateSession(session, header.getTerminalPhone(), packageData.getAuthCode());
        // TODO 终端鉴权

        return new CommonResponse(resultHeader, msg_id_terminal_authentication, header.getFlowId(), CommonResponse.success);
    }

    @Mapping(types = msg_id_terminal_param_query_resp, desc = "查询终端参数应答")
    public void paramQuery(ParamQueryResponse packageData) {
        String terminalPhone = packageData.getHeader().getTerminalPhone();
        Integer replyId = packageData.getReplyFlowId();
        ServerData.Protocol.Builder protocol = ServerData.Protocol.newBuilder();
        protocol.setProtoType(msg_id_terminal_param_query_resp);
        protocol.setTerminalPhone(terminalPhone);
        ServerData.ParamQueryResponse.Builder builder = ServerData.ParamQueryResponse.newBuilder();
        try {
            ServerData.ParamQueryResponse data = (ServerData.ParamQueryResponse)
                    ProtoBufCodec.javaBeanToProtoBean(packageData, builder);
            protocol.setParamQueryResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        messageManager.put(terminalPhone + replyId, protocol);
    }

    @Mapping(types = msg_id_terminal_attribute_query_resp, desc = "查询终端属性应答")
    public void attributeQuery(AttributeQueryResponse packageData) {
        String terminalPhone = packageData.getHeader().getTerminalPhone();
        ServerData.Protocol.Builder protocol = ServerData.Protocol.newBuilder();
        protocol.setProtoType(msg_id_terminal_attribute_query_resp);
        protocol.setTerminalPhone(terminalPhone);
        ServerData.AttributeQueryResponse.Builder builder = ServerData.AttributeQueryResponse.newBuilder();
        try {
            ServerData.AttributeQueryResponse data = (ServerData.AttributeQueryResponse)
                    ProtoBufCodec.javaBeanToProtoBean(packageData, builder);
            protocol.setAttributeQueryResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        messageManager.put(terminalPhone + msg_id_terminal_attribute_query_resp, protocol);
    }

    @Mapping(types = msg_id_terminal_upgrade_result, desc = "终端升级结果通知")
    public CommonResponse upgradeResult(UpgradeResponse packageData) {
        Header header = packageData.getHeader();
        Header resultHeader = new Header(cmd_common_resp,
                sessionManager.currentFlowId(), header.getTerminalPhone());

        // TODO
        return new CommonResponse(resultHeader, msg_id_terminal_upgrade_result, header.getFlowId(), CommonResponse.success);
    }

    private void sendAlarmFileUploadToTerminal(String terminalPhone, Session session, byte[] alarmFlag) {
        AlarmFileUpload alarmFileUpload = new AlarmFileUpload();
        alarmFileUpload.setHostLength(15);
        alarmFileUpload.setHost("202.194.014.073");
        alarmFileUpload.setTcpPort(10005);
        alarmFileUpload.setUdpPort(0);
        alarmFileUpload.setAlarmFlag(alarmFlag);
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
        alarmFileUpload.setAlarmCode(UUID.randomUUID().toString().replace("-", "").getBytes());
        Header newHeader = new Header(cmd_alarm_file_upload, sessionManager.currentFlowId(), terminalPhone);
        alarmFileUpload.setHeader(newHeader);
        ByteBuf buf = encoder.encode(alarmFileUpload);
        ByteBuf allResultBuf = Unpooled.wrappedBuffer(Unpooled.wrappedBuffer(
                new byte[]{ 0x7e }), buf, Unpooled.wrappedBuffer(new byte[]{ 0x7e }));
        session.getChannel().writeAndFlush(allResultBuf.retain());
    }

    @Mapping(types = msg_id_terminal_location, desc = "位置信息汇报")
    public CommonResponse location(Location packageData, Session session) {

        Header header = packageData.getHeader();
        String terminalPhone = header.getTerminalPhone();
        Header resultHeader = new Header(cmd_common_resp,
                sessionManager.currentFlowId(), terminalPhone);
        ServerData.Protocol.Builder protocol = ServerData.Protocol.newBuilder();
        protocol.setProtoType(msg_id_terminal_attribute_query_resp);
        protocol.setTerminalPhone(terminalPhone);

        // TODO ADAS 报警处理
        packageData.getExtraLocations().forEach(extraLocation -> {

            if (extraLocation.getType() == 0x64) {
                sendAlarmFileUploadToTerminal(terminalPhone, session,
                        extraLocation.getAdvancedDrivingAssistanceAlarm().getAlarmFlag());
            }
            if (extraLocation.getType() == 0x65) {
                sendAlarmFileUploadToTerminal(terminalPhone, session,
                        extraLocation.getDriverConditionMonitoringSystemAlarm().getAlarmFlag());
            }
            if (extraLocation.getType() == 0x66) {
                sendAlarmFileUploadToTerminal(terminalPhone, session,
                        extraLocation.getTirePressureMonitoringSystemAlarm().getAlarmFlag());
            }
            if (extraLocation.getType() == 0x67) {
                sendAlarmFileUploadToTerminal(terminalPhone, session,
                        extraLocation.getBlindAreaMonitoringSystemAlarm().getAlarmFlag());
            }

        });

        try (Jedis jedis = JedisPoolUtil.getInstance().getJedisPool().getResource()) {
            ServerData.Location.Builder builder = ServerData.Location.newBuilder();
            ServerData.Location data = (ServerData.Location)
                    ProtoBufCodec.javaBeanToProtoBean(packageData, builder);
            protocol.setLocation(data);

            if (data != null) jedis.set(("location" + terminalPhone).getBytes(), data.toByteArray());

        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuilder data = new StringBuilder("{ \"terminalPhone\" : " + terminalPhone + "," + packageData.toString());
        for (ExtraLocation extraLocation : packageData.getExtraLocations()) {
            data.append(extraLocation.toString());
        }
        data.append(" }");
        MQUtil.topic(JT808, LOCATION, data.toString().getBytes(Charset.forName("utf-8")));

        return new CommonResponse(resultHeader, msg_id_terminal_location, header.getFlowId(), CommonResponse.success);
    }

    @Mapping(types = {msg_id_terminal_location_query_resp, msg_id_car_control_resp}, desc = "位置信息查询应答/34.车辆控制应答")
    public void locationReply(LocationReply packageData) {
        String terminalPhone = packageData.getHeader().getTerminalPhone();
        Integer replyId = packageData.getReplyFlowId();
        ServerData.Protocol.Builder protocol = ServerData.Protocol.newBuilder();
        protocol.setProtoType(packageData.getHeader().getType());
        protocol.setTerminalPhone(terminalPhone);
        ServerData.Location.Builder builder = ServerData.Location.newBuilder();
        try {
            ServerData.Location data = (ServerData.Location)
                    ProtoBufCodec.javaBeanToProtoBean(packageData, builder);
            protocol.setLocation(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        messageManager.put(terminalPhone + replyId, protocol);
    }

    @Mapping(types = msg_id_event_report, desc = "事件报告")
    public CommonResponse eventReport(EventReport packageData) {
        Header header = packageData.getHeader();
        Header resultHeader = new Header(cmd_common_resp,
                sessionManager.currentFlowId(), header.getTerminalPhone());

        return new CommonResponse(resultHeader, msg_id_event_report, header.getFlowId(), CommonResponse.success);
    }

    @Mapping(types = msg_id_ask_answer, desc = "提问应答")
    public CommonResponse askAnswer(QuestionMsgResponse packageData) {
        Header header = packageData.getHeader();
        Header resultHeader = new Header(cmd_common_resp,
                sessionManager.currentFlowId(), header.getTerminalPhone());
        return new CommonResponse(resultHeader, msg_id_ask_answer, header.getFlowId(), CommonResponse.success);
    }

    @Mapping(types = msg_id_message_request_cancel, desc = "信息点播/取消")
    public CommonResponse messageRequestCancel(MessageSubOperate packageData) {
        Header header = packageData.getHeader();
        Header resultHeader = new Header(cmd_common_resp,
                sessionManager.currentFlowId(), header.getTerminalPhone());
        return new CommonResponse(resultHeader, msg_id_message_request_cancel, header.getFlowId(), CommonResponse.success);
    }

    @Mapping(types = msg_id_recorder_data_upload, desc = "行驶记录仪数据上传")
    public CommonResponse recorderDataUpload(PackageData<Header> packageData) {
        Header header = packageData.getHeader();
        Header resultHeader = new Header(cmd_common_resp,
                sessionManager.currentFlowId(), header.getTerminalPhone());

        // TODO
        return new CommonResponse(resultHeader, msg_id_recorder_data_upload, header.getFlowId(), CommonResponse.success);
    }

    @Mapping(types = msg_id_digital_data_upload, desc = "电子运单上报")
    public CommonResponse digitalDataUpload(DigitWaybill packageData) {
        Header header = packageData.getHeader();
        String terminalPhone = header.getTerminalPhone();
        Header resultHeader = new Header(cmd_common_resp,
                sessionManager.currentFlowId(), terminalPhone);
        ServerData.Protocol.Builder protocol = ServerData.Protocol.newBuilder();
        protocol.setProtoType(msg_id_digital_data_upload);
        protocol.setTerminalPhone(terminalPhone);
        ServerData.DigitWaybill.Builder builder = ServerData.DigitWaybill.newBuilder();
        try {
            ServerData.DigitWaybill data = (ServerData.DigitWaybill)
                    ProtoBufCodec.javaBeanToProtoBean(packageData, builder);
            protocol.setDigitWaybill(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MQUtil.topic(JT808, DIGIT_WAYBILL, protocol.build().toByteArray());
        return new CommonResponse(resultHeader, msg_id_digital_data_upload, header.getFlowId(), CommonResponse.success);
    }

    @Mapping(types = msg_id_Identity_information_upload, desc = "驾驶员身份信息采集上报")
    public CommonResponse driverIdentityInformationUpload(DriverIdentity packageData) {
        Header header = packageData.getHeader();
        String terminalPhone = header.getTerminalPhone();
        Header resultHeader = new Header(cmd_common_resp,
                sessionManager.currentFlowId(), terminalPhone);
        ServerData.Protocol.Builder protocol = ServerData.Protocol.newBuilder();
        protocol.setProtoType(msg_id_Identity_information_upload);
        protocol.setTerminalPhone(terminalPhone);
        ServerData.DriverIdentity.Builder builder = ServerData.DriverIdentity.newBuilder();
        try (Jedis jedis = JedisPoolUtil.getInstance().getJedisPool().getResource()) {
            ServerData.DriverIdentity data = (ServerData.DriverIdentity)
                    ProtoBufCodec.javaBeanToProtoBean(packageData, builder);
            protocol.setDriverIdentity(data);
            if (data != null) jedis.set(("identity" + terminalPhone).getBytes(), data.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO test
        Gson gson = new Gson();
        MQUtil.topic(JT808, DRIVER_IDENTITY, gson.toJson(packageData).getBytes(Charset.forName("GBK")));
        messageManager.put(header.getTerminalPhone() + msg_id_Identity_information_upload, packageData);
        return new CommonResponse(resultHeader, msg_id_digital_data_upload, header.getFlowId(), CommonResponse.success);
    }

    @Mapping(types = msg_id_bulk_location_upload, desc = "定位数据批量上传")
    public CommonResponse bulkLocationUpload(PackageData<Header> packageData) {
        Header header = packageData.getHeader();
        Header resultHeader = new Header(cmd_common_resp,
                sessionManager.currentFlowId(), header.getTerminalPhone());
        // TODO
        return new CommonResponse(resultHeader, msg_id_digital_data_upload, header.getFlowId(), CommonResponse.success);
    }

    @Mapping(types = msg_id_CAN_data_upload, desc = "CAN总线数据上传")
    public CommonResponse CANDataUpload(CANBusReport packageData) {
        Header header = packageData.getHeader();
        Header resultHeader = new Header(cmd_common_resp,
                sessionManager.currentFlowId(), header.getTerminalPhone());
        return new CommonResponse(resultHeader, msg_id_CAN_data_upload, header.getFlowId(), CommonResponse.success);
    }

    @Mapping(types = msg_id_media_event_upload, desc = "多媒体事件信息上传")
    public CommonResponse mediaEventUpload(MediaEvent packageData) {
        Header header = packageData.getHeader();
        Header resultHeader = new Header(cmd_common_resp,
                sessionManager.currentFlowId(), header.getTerminalPhone());
        return new CommonResponse(resultHeader, msg_id_media_event_upload, header.getFlowId(), CommonResponse.success);
    }

    @Mapping(types = msg_id_media_upload, desc = "多媒体数据上传")
    public MediaDataResponse mediaUpload(MediaData packageData) {
        Header header = packageData.getHeader();
        if (header.getSubPackageSeq() == 1) {
            Header resultHeader = new Header(cmd_media_upload_resp,
                    sessionManager.currentFlowId(), header.getTerminalPhone());
            MediaDataResponse mediaDataResponse = new MediaDataResponse(resultHeader);
            mediaDataResponse.setMediaId(packageData.getMediaId());
            mediaDataResponse.setPackageTotal(0);
            new Thread(() -> {
                String terminalPhone = header.getTerminalPhone();
                PhotoFuture photoFuture = photoManager.receive(terminalPhone, header.getTotalSubPackage());
                photoManager.put(terminalPhone, packageData.getData());
                try {
                    byte[] res = (byte[]) photoFuture.get();
                    packageData.setData(res);
                    ServerData.Protocol.Builder protocol = ServerData.Protocol.newBuilder();
                    protocol.setProtoType(msg_id_media_upload);
                    protocol.setTerminalPhone(terminalPhone);
                    ServerData.MediaData.Builder builder = ServerData.MediaData.newBuilder();
                    try {
                        ServerData.MediaData data = (ServerData.MediaData)
                                ProtoBufCodec.javaBeanToProtoBean(packageData, builder);
                        protocol.setMediaData(data);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    MQUtil.toQueue(PHOTO, protocol.build().toByteArray());
                    photoManager.remove(terminalPhone);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
            return mediaDataResponse;
        } else {
            photoManager.put(header.getTerminalPhone(), packageData.getData());
        }
        return null;
    }

    @Mapping(types = msg_id_camera_photo_response, desc = "摄像头立即拍摄命令应答")
    public void cameraPhotoResponse(CameraPhotoResponse packageData) {
        Header header = packageData.getHeader();
        String mobileNumber = header.getTerminalPhone();
        Integer replyId = packageData.getReplyFlowId();
        ServerData.Protocol.Builder protocol = ServerData.Protocol.newBuilder();
        protocol.setProtoType(msg_id_camera_photo_response);
        protocol.setTerminalPhone(header.getTerminalPhone());
        ServerData.CameraPhotoResponse.Builder builder = ServerData.CameraPhotoResponse.newBuilder();
        try {
            ServerData.CameraPhotoResponse data = (ServerData.CameraPhotoResponse)
                    ProtoBufCodec.javaBeanToProtoBean(packageData, builder);
            protocol.setCameraPhotoResponse(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        messageManager.put(mobileNumber + replyId, protocol);
    }

    @Mapping(types = msg_id_saved_media_response, desc = "存储多媒体数据检索应答")
    public void savedMediaResponse(MediaDataQueryResponse packageData) {
        Header header = packageData.getHeader();
        String mobileNumber = header.getTerminalPhone();
        Integer replyId = packageData.getReplyFlowId();
        messageManager.put(mobileNumber + replyId, packageData);
    }

    @Mapping(types = msg_id_data_upload, desc = "数据上行透传")
    public CommonResponse passThrough(PassThroughUpload packageData) {
        Header header = packageData.getHeader();
        Header resultHeader = new Header(cmd_common_resp,
                sessionManager.currentFlowId(), header.getTerminalPhone());

        log.info(packageData.toString());

        return new CommonResponse(resultHeader, msg_id_data_upload, header.getFlowId(), CommonResponse.success);
    }

    @Mapping(types = msg_id_data_zip_upload, desc = "数据压缩上报")
    public CommonResponse gzipPack(GZIPPack packageData) {
        Header header = packageData.getHeader();
        Header resultHeader = new Header(cmd_common_resp,
                sessionManager.currentFlowId(), header.getTerminalPhone());
        return new CommonResponse(resultHeader, msg_id_data_zip_upload, header.getFlowId(), CommonResponse.success);
    }

    @Mapping(types = msg_id_terminal_RSA, desc = "终端RSA公钥")
    public void terminalRSA(RSAPack packageData) {
        Header header = packageData.getHeader();
        String mobileNumber = header.getTerminalPhone();
        messageManager.put(mobileNumber + msg_id_terminal_RSA, packageData);
    }


}

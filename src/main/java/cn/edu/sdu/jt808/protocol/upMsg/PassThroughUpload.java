package cn.edu.sdu.jt808.protocol.upMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;
import cn.edu.sdu.jt808.protocol.Header;

import java.util.Arrays;
import java.util.List;

@MsgType(MessageId.msg_id_data_upload)
public class PassThroughUpload extends PackageData<Header> {

    // GNSS模块详细定位数据
    public static final int GNSSLocation = 0x00;
    // 道路运输证IC卡信息上传消息为64Byte，下传消息为24Byte。道路运输证IC卡认证透传超时时间为30s。超时后，不重发
    public static final int ICCardInfo = 0x0B;
    // 串口1透传消息
    public static final int SerialPortOne = 0x41;
    // 串口2透传消息
    public static final int SerialPortTow = 0x42;
    // 状态查询 外设状态信息:外设工作状态、设备报警信息
    public static final int StateQuery = 0xF7;
    // 信息查询 外设传感器的基本信息:公司信息、 产品代码、 版本号、 外设 ID、 客户代码
    public static final int InfomationQuery = 0xF8;


    private Integer type;
    private Integer total;
    private List<PeripheralStateMsg> peripheralStateMsgs;
    private List<PeripheralSystemMsg> peripheralSystemMsgs;

    public PassThroughUpload() {
    }

    public PassThroughUpload(Integer type) {
        this.type = type;
    }

    @Property(index = 0, type = DataType.BYTE, desc = "透传消息类型")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Property(index = 1, type = DataType.BYTE, desc = "消息列表总数")
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Property(index = 2, type = DataType.LIST, enumType = 0xF7, desc = "消息列表")
    public List<PeripheralStateMsg> getPeripheralStateMsgs() {
        return peripheralStateMsgs;
    }

    public void setPeripheralStateMsgs(List<PeripheralStateMsg> peripheralStateMsgs) {
        this.peripheralStateMsgs = peripheralStateMsgs;
    }

    @Property(index = 2, type = DataType.LIST, enumType = 0xF8, desc = "消息列表")
    public List<PeripheralSystemMsg> getPeripheralSystemMsgs() {
        return peripheralSystemMsgs;
    }

    public void setPeripheralSystemMsgs(List<PeripheralSystemMsg> peripheralSystemMsgs) {
        this.peripheralSystemMsgs = peripheralSystemMsgs;
    }

    @Override
    public String toString() {
        return "PassThroughUpload{" +
                "type=" + type +
                ", total=" + total +
                ", peripheralStateMsgs=" + peripheralStateMsgs +
                ", peripheralSystemMsgs=" + peripheralSystemMsgs +
                '}';
    }

    public static class PeripheralStateMsg {
        // 外设 ID
        private Integer type;
        // 消息长度
        private Integer messageLength;
        // 外设状态信息
        private PeripheralState peripheralState;


        @Property(index = 0, type = DataType.BYTE, desc = "外设 ID")
        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        @Property(index = 1, type = DataType.BYTE, desc = "消息长度")
        public Integer getMessageLength() {
            return messageLength;
        }

        public void setMessageLength(Integer messageLength) {
            this.messageLength = messageLength;
        }


        @Property(index = 2, type = DataType.OBJ, desc = "消息0xF7")
        public PeripheralState getPeripheralState() {
            return peripheralState;
        }

        public void setPeripheralState(PeripheralState peripheralState) {
            this.peripheralState = peripheralState;
        }

        @Override
        public String toString() {
            return "PeripheralMsg{" +
                    "type=" + type +
                    ", messageLength=" + messageLength +
                    ", peripheralState=" + peripheralState +
                    '}';
        }

        public static class PeripheralState {
            // 工作状态
            private Integer workState;
            // 报警状态
            private Integer alarmState;

            @Property(index = 0, type = DataType.BYTE, desc = "工作状态")
            public Integer getWorkState() {
                return workState;
            }

            public void setWorkState(Integer workState) {
                this.workState = workState;
            }

            @Property(index = 1, type = DataType.DWORD, desc = "报警状态")
            public Integer getAlarmState() {
                return alarmState;
            }

            public void setAlarmState(Integer alarmState) {
                this.alarmState = alarmState;
            }

            @Override
            public String toString() {
                return "PeripheralState{" +
                        "workState=" + workState +
                        ", alarmState=" + alarmState +
                        '}';
            }
        }
    }

    public static class PeripheralSystemMsg {
        // 外设 ID
        private Integer type;
        // 消息长度
        private Integer messageLength;
        // 外设系统信息
        private PeripheralSystem peripheralSystem;

        @Property(index = 0, type = DataType.BYTE, desc = "外设 ID")
        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        @Property(index = 1, type = DataType.BYTE, desc = "消息长度")
        public Integer getMessageLength() {
            return messageLength;
        }

        public void setMessageLength(Integer messageLength) {
            this.messageLength = messageLength;
        }


        @Property(index = 2, type = DataType.OBJ, desc = "消息0xF8")
        public PeripheralSystem getPeripheralSystem() {
            return peripheralSystem;
        }

        public void setPeripheralSystem(PeripheralSystem peripheralSystem) {
            this.peripheralSystem = peripheralSystem;
        }

        @Override
        public String toString() {
            return "PeripheralMsg{" +
                    "type=" + type +
                    ", messageLength=" + messageLength +
                    ", peripheralSystem=" + peripheralSystem +
                    '}';
        }

        public static class PeripheralSystem {
            // 公司名称长度
            private Integer companyNameLength;
            // 公司名称
            private byte[] companyName;
            // 产品型号长度
            private Integer productCodeLength;
            // 产品型号
            private byte[] productCode;
            // 硬件版本号长度
            private Integer firewareVersionLength;
            // 硬件版本号
            private byte[] firewareVersion;
            // 软件版本号长度
            private Integer softwareVersionLength;
            // 硬件版本号
            private byte[] softwareVersion;
            // 设备 ID 长度
            private Integer equipmentIdLength;
            // 设备 ID
            private byte[] equipmentId;
            // 客户代码长度
            private Integer customerCodeLength;
            // 客户代码
            private byte[] customerCode;

            @Property(index = 0, type = DataType.BYTE, desc = "公司名称长度")
            public Integer getCompanyNameLength() {
                return companyNameLength;
            }

            public void setCompanyNameLength(Integer companyNameLength) {
                this.companyNameLength = companyNameLength;
            }

            @Property(index = 1, type = DataType.BYTES, lengthName = "companyNameLength", desc = "公司名称")
            public byte[] getCompanyName() {
                return companyName;
            }

            public void setCompanyName(byte[] companyName) {
                this.companyName = companyName;
            }

            @Property(index = 1, type = DataType.BYTE, desc = "产品型号长度")
            public Integer getProductCodeLength() {
                return productCodeLength;
            }

            public void setProductCodeLength(Integer productCodeLength) {
                this.productCodeLength = productCodeLength;
            }

            @Property(index = 2, type = DataType.BYTES, lengthName = "productCodeLength", desc = "产品型号")
            public byte[] getProductCode() {
                return productCode;
            }

            public void setProductCode(byte[] productCode) {
                this.productCode = productCode;
            }

            @Property(index = 2, type = DataType.BYTE, desc = "硬件版本号长度")
            public Integer getFirewareVersionLength() {
                return firewareVersionLength;
            }

            public void setFirewareVersionLength(Integer firewareVersionLength) {
                this.firewareVersionLength = firewareVersionLength;
            }

            @Property(index = 3, type = DataType.BYTES, lengthName = "firewareVersionLength", desc = "硬件版本号")
            public byte[] getFirewareVersion() {
                return firewareVersion;
            }

            public void setFirewareVersion(byte[] firewareVersion) {
                this.firewareVersion = firewareVersion;
            }

            @Property(index = 3, type = DataType.BYTE, desc = "软件版本号长度")
            public Integer getSoftwareVersionLength() {
                return softwareVersionLength;
            }

            public void setSoftwareVersionLength(Integer softwareVersionLength) {
                this.softwareVersionLength = softwareVersionLength;
            }

            @Property(index = 4, type = DataType.BYTES, lengthName = "softwareVersionLength", desc = "软件版本号")
            public byte[] getSoftwareVersion() {
                return softwareVersion;
            }

            public void setSoftwareVersion(byte[] softwareVersion) {
                this.softwareVersion = softwareVersion;
            }

            @Property(index = 4, type = DataType.BYTE, desc = "设备 ID 长度")
            public Integer getEquipmentIdLength() {
                return equipmentIdLength;
            }

            public void setEquipmentIdLength(Integer equipmentIdLength) {
                this.equipmentIdLength = equipmentIdLength;
            }

            @Property(index = 5, type = DataType.BYTES, lengthName = "equipmentIdLength", desc = "设备 ID")
            public byte[] getEquipmentId() {
                return equipmentId;
            }

            public void setEquipmentId(byte[] equipmentId) {
                this.equipmentId = equipmentId;
            }

            @Property(index = 5, type = DataType.BYTE, desc = "客户代码长度")
            public Integer getCustomerCodeLength() {
                return customerCodeLength;
            }

            public void setCustomerCodeLength(Integer customerCodeLength) {
                this.customerCodeLength = customerCodeLength;
            }

            @Property(index = 6, type = DataType.BYTES, lengthName = "customerCodeLength", desc = "客户代码")
            public byte[] getCustomerCode() {
                return customerCode;
            }

            public void setCustomerCode(byte[] customerCode) {
                this.customerCode = customerCode;
            }

            @Override
            public String toString() {
                return "PeripheralSystem{" +
                        "companyNameLength=" + companyNameLength +
                        ", companyName=" + Arrays.toString(companyName) +
                        ", productCodeLength=" + productCodeLength +
                        ", productCode=" + Arrays.toString(productCode) +
                        ", firewareVersionLength=" + firewareVersionLength +
                        ", firewareVersion=" + Arrays.toString(firewareVersion) +
                        ", softwareVersionLength=" + softwareVersionLength +
                        ", softwareVersion=" + Arrays.toString(softwareVersion) +
                        ", equipmentIdLength=" + equipmentIdLength +
                        ", equipmentId=" + Arrays.toString(equipmentId) +
                        ", customerCodeLength=" + customerCodeLength +
                        ", customerCode=" + Arrays.toString(customerCode) +
                        '}';
            }
        }
    }
}
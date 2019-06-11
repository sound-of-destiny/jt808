import cn.edu.sdu.jt808.jtframework.commons.DataType;

public enum LocationExtraId {

    C0x01(0x01, DataType.DWORD, "0x01: 里程"),
    C0x02(0x02, DataType.WORD, "0x02: 油量"),
    C0x03(0x03, DataType.WORD, "0x03: 行驶记录功能获取的速度"),
    C0x04(0x04, DataType.WORD, "0x04: 需要人工确认报警事件的 ID"),

    C0x11(0x11, DataType.BYTES, "0x11: 超速报警附加信息消息体数据格式"),
    C0x12(0x12, DataType.BYTES, "0x12: 进出区域/路线报警附加信息消息体数据格式"),
    C0x13(0x13, DataType.BYTES, "0x13: 路线行驶时间不足/过长报警附加信息消息体数据格式"),

    C0x25(0x25, DataType.DWORD, "0x25: 扩展车辆信号状态位"),
    C0x2A(0x2A, DataType.WORD, "0x2A: IO状态位"),
    C0x2B(0x2B, DataType.DWORD, "0x2B: 模拟量"),
    C0x30(0x30, DataType.BYTE, "0x30: 无线通信网络信号强度"),
    C0x31(0x31, DataType.BYTE, "0x31: GNSS 定位卫星数");

    public final int value;
    public final DataType type;
    public final String desc;

    LocationExtraId(int value, DataType type, String desc) {
        this.value = value;
        this.type = type;
        this.desc = desc;
    }

}

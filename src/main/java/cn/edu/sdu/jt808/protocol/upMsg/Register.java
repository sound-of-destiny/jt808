package cn.edu.sdu.jt808.protocol.upMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.protocol.Header;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;

/**
 *
 * 终端注册消息
 *
 */
@MsgType(MessageId.msg_id_terminal_register)
public class Register extends PackageData<Header> {

	// 省域ID(WORD),设备安装车辆所在的省域，省域ID采用GB/T2260中规定的行政区划代码6位中前两位
	// 0保留，由平台取默认值
	private Integer provinceId;
	// 市县域ID(WORD) 设备安装车辆所在的市域或县域,市县域ID采用GB/T2260中规定的行 政区划代码6位中后四位
	// 0保留，由平台取默认值
	private Integer cityId;
	// 制造商ID(BYTE[5]) 5 个字节，终端制造商编码
	private String manufacturerId;
	// 终端型号(BYTE[8]) 八个字节， 此终端型号 由制造商自行定义 位数不足八位的，补空格。
	private String terminalType;
	// 终端ID(BYTE[7]) 七个字节， 由大写字母 和数字组成， 此终端 ID由制造 商自行定义
	private String terminalId;
	/**
	 *
	 * 车牌颜色(BYTE) 车牌颜色，按照 JT/T415-2006 的 5.4.12 未上牌时，取值为0<br>
	 * 0===未上车牌<br>
	 * 1===蓝色<br>
	 * 2===黄色<br>
	 * 3===黑色<br>
	 * 4===白色<br>
	 * 9===其他
	 */
	private Integer licensePlateColor;
	// 车牌(STRING) 公安交 通管理部门颁 发的机动车号牌
	private String licensePlate;


	@Property(index = 0, type = DataType.WORD, desc = "省域ID")
	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	@Property(index = 2, type = DataType.WORD, desc = "市县域ID")
	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@Property(index = 4, type = DataType.STRING, length = 5, pad = 32, desc = "制造商ID")
	public String getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(String manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	@Property(index = 9, type = DataType.STRING, length = 8, pad = 32, desc = "终端型号")
	public String getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

	@Property(index = 17, type = DataType.STRING, length = 7, desc = "终端ID")
	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	@Property(index = 24, type = DataType.BYTE, desc = "车牌颜色")
	public Integer getLicensePlateColor() {
		return licensePlateColor;
	}

	public void setLicensePlateColor(Integer licensePlate) {
		this.licensePlateColor = licensePlate;
	}

	@Property(index = 25, type = DataType.STRING, desc = "车牌")
	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Override
	public String toString() {
		return "[provinceId=" + provinceId + ", cityId=" + cityId + ", manufacturerId="
				+ manufacturerId + ", terminalType=" + terminalType + ", terminalId=" + terminalId
				+ ", licensePlateColor=" + licensePlateColor + ", licensePlate=" + licensePlate + "]";
	}

}

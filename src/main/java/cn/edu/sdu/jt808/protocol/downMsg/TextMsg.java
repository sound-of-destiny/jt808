package cn.edu.sdu.jt808.protocol.downMsg;

import cn.edu.sdu.jt808.commons.MessageId;
import cn.edu.sdu.jt808.protocol.Header;
import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.message.PackageData;

@MsgType(MessageId.cmd_text_download)
public class TextMsg extends PackageData<Header> {

    private Integer sign;

    private int[] signs;

    private String content;

    @Property(index = 0, type = DataType.BYTE, desc = "标志")
    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public int[] getSigns() {
        return signs;
    }

    public void setSigns(int[] signs) {
        int sign = 0;
        for (int b : signs) {
            sign |= 1 << b;
        }
        this.sign = sign;
        this.signs = signs;
    }

    @Property(index = 1, type = DataType.STRING, desc = "文本信息")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
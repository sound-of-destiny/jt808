package cn.edu.sdu.jt808.jtframework.codec;

import cn.edu.sdu.jt808.jtframework.codec.checkSum.out.OutSign;
import cn.edu.sdu.jt808.jtframework.codec.codec.out.Encoder;
import cn.edu.sdu.jt808.jtframework.codec.transfer.out.Transfer;
import cn.edu.sdu.jt808.jtframework.message.AbstractHeader;
import cn.edu.sdu.jt808.jtframework.message.PackageData;
import io.netty.buffer.ByteBuf;

public abstract class MessageEncoder<T extends AbstractHeader> {

    public MessageEncoder() {}

    protected OutSign outSign;
    protected Transfer transfer;
    protected Encoder encoder;

    /**
     * 转义
     */
    public ByteBuf escape(ByteBuf buf) {
        return transfer.escape(buf);
    }

    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }

    /**
     * checksum
     */
    public ByteBuf sign(ByteBuf buf) {
        return outSign.sign(buf);
    }

    public void setOutSign(OutSign outSign) {
        this.outSign = outSign;
    }

    public ByteBuf encode(PackageData<T> body) {
        ByteBuf buf = encoder.encode(body);
        buf = sign(buf);
        buf = escape(buf);
        return buf;
    }
}

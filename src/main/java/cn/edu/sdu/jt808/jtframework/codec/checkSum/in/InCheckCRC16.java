package cn.edu.sdu.jt808.jtframework.codec.checkSum.in;

import cn.edu.sdu.jt808.jtframework.commons.codec.CRC16;
import io.netty.buffer.ByteBuf;

public class InCheckCRC16 implements InCheck {

    @Override
    public boolean check(ByteBuf buf) {
        int len = buf.readableBytes();
        short checkCode = buf.getShort(len - 2);
        buf = buf.slice(0, len - 2);
        byte[] data = new byte[len - 2];
        buf.readBytes(data);
        return checkCode != CRC16.doCRC(data);
    }
}

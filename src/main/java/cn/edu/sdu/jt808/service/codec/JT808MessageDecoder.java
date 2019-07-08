package cn.edu.sdu.jt808.service.codec;

import cn.edu.sdu.jt808.jtframework.codec.MessageDecoder;
import cn.edu.sdu.jt808.jtframework.codec.checkSum.in.InCheckXOR;
import cn.edu.sdu.jt808.jtframework.codec.codec.in.DecoderJT;
import cn.edu.sdu.jt808.jtframework.codec.transfer.in.UnTransferJT;
import io.netty.buffer.ByteBuf;

public class JT808MessageDecoder extends MessageDecoder {

    public JT808MessageDecoder() {
        inCheck = new InCheckXOR();
        decoder = new DecoderJT();
        unTransfer = new UnTransferJT();
    }

    @Override
    public int getMsgId(ByteBuf buf) {
        return buf.getUnsignedShort(0);
    }
}

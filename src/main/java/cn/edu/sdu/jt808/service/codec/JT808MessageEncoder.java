package cn.edu.sdu.jt808.service.codec;

import cn.edu.sdu.jt808.jtframework.codec.MessageEncoder;
import cn.edu.sdu.jt808.jtframework.codec.checkSum.out.OutSignXOR;
import cn.edu.sdu.jt808.jtframework.codec.codec.out.EncoderJT;
import cn.edu.sdu.jt808.jtframework.codec.transfer.out.TransferJT;
import cn.edu.sdu.jt808.protocol.Header;

public class JT808MessageEncoder extends MessageEncoder<Header> {

    public JT808MessageEncoder() {
        outSign = new OutSignXOR();
        transfer = new TransferJT();
        encoder = new EncoderJT();
    }
}

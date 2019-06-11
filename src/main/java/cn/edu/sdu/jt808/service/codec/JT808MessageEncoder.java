package cn.edu.sdu.jt808.service.codec;

import cn.edu.sdu.jt808.protocol.Header;
import cn.edu.sdu.jt808.jtframework.codec.MessageEncoder;
import cn.edu.sdu.jt808.jtframework.commons.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class JT808MessageEncoder extends MessageEncoder<Header> {

    public JT808MessageEncoder(Charset charset) {
        super(charset);
    }

    @Override
    public ByteBuf escape(ByteBuf buf) {
        int low = buf.readerIndex();
        int high = buf.writerIndex();

        int mark = buf.forEachByte(low, high, value -> !(value == 0x7d || value == 0x7e));

        if (mark == -1)
            return buf;

        List<ByteBuf> bufList = new ArrayList<>(5);

        int len;
        do {

            len = mark + 1 - low;
            ByteBuf[] slice = slice(buf, low, len);
            bufList.add(slice[0]);
            bufList.add(slice[1]);
            low += len;

            mark = buf.forEachByte(low, high - low, value -> !(value == 0x7d || value == 0x7e));
        } while (mark > 0);

        bufList.add(buf.slice(low, high - low));

        ByteBuf[] bufs = bufList.toArray(new ByteBuf[0]);

        return Unpooled.wrappedBuffer(bufs);
    }

    private ByteBuf[] slice(ByteBuf byteBuf, int index, int length) {
        byte first = byteBuf.getByte(index + length - 1);

        ByteBuf[] bufs = new ByteBuf[2];
        bufs[0] = byteBuf.slice(index, length);

        if (first == 0x7d)
            // 0x01 不做处理 p47
            bufs[1] = Unpooled.wrappedBuffer(new byte[]{0x01});
        else {
            byteBuf.setByte(index + length - 1, 0x7d);
            bufs[1] = Unpooled.wrappedBuffer(new byte[]{0x02});
        }

        return bufs;
    }

    @Override
    public ByteBuf sign(ByteBuf buf) {
        byte checkCode = ByteBufUtils.xor(buf);
        buf.writeByte(checkCode);
        return buf;
    }
}

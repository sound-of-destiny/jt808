package cn.edu.sdu.jt808.jtframework.codec.transfer.in;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;

import java.util.ArrayList;
import java.util.List;

public class UnTransferJT implements UnTransfer {

    @Override
    public ByteBuf unEscape(ByteBuf buf) {
        int low = buf.readerIndex();
        int high = buf.writerIndex();

        int mark = buf.indexOf(low, high, (byte) 0x7d);
        if (mark == -1)
            return buf;

        List<ByteBuf> bufList = new ArrayList<>();

        int len;
        do {

            len = mark + 2 - low;
            bufList.add(slice(buf, low, len));
            low += len;

            mark = buf.indexOf(low, high, (byte) 0x7d);
        } while (mark > 0);

        bufList.add(buf.slice(low, high - low));

        return new CompositeByteBuf(UnpooledByteBufAllocator.DEFAULT, false, bufList.size(), bufList);
    }

    private ByteBuf slice(ByteBuf byteBuf, int index, int length) {
        byte second = byteBuf.getByte(index + length - 1);
        if (second == 0x02)
            byteBuf.setByte(index + length - 2, 0x7e);

        // 0x01 不做处理 p47
        // if (second == 0x01) {
        // }
        return byteBuf.slice(index, length - 1);
    }
}

package cn.edu.sdu.jt808.service.codec;

import cn.edu.sdu.jt808.jtframework.codec.MessageDecoder;
import cn.edu.sdu.jt808.jtframework.commons.BeanUtils;
import cn.edu.sdu.jt808.jtframework.commons.ByteBufUtils;
import cn.edu.sdu.jt808.jtframework.exception.CheckSumErrorException;
import cn.edu.sdu.jt808.jtframework.exception.PropertyNameErrorException;
import cn.edu.sdu.jt808.jtframework.message.PackageData;
import cn.edu.sdu.jt808.protocol.Header;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class JT808MessageDecoder extends MessageDecoder {

    public JT808MessageDecoder(Charset charset) {
        super(charset);
    }

    @Override
    public int getMsgId(ByteBuf buf) {
        return buf.getUnsignedShort(0);
    }

    public <T extends PackageData> T decode(ByteBuf buf, Class<T> bodyClass) {
        buf = unEscape(buf);
        if (check(buf)) throw new CheckSumErrorException("checksum error");
        Header header = doDecode(buf, Header.class);
        if (header.isHasSubPackage() && header.getSubPackageSeq() != 1) {
            T result = BeanUtils.newInstance(bodyClass);
            byte[] data = new byte[buf.readableBytes()];
            buf.readBytes(data);
            try {
                Field f = bodyClass.getDeclaredField("data");
                f.setAccessible(true);
                f.set(result, data);
            } catch (Exception e) {
                throw new PropertyNameErrorException("please set the property data");
            }
            result.setHeader(header);
            return result;
        }
        ByteBuf bodyBuf = buf.slice(header.getHeaderLength(), header.getMsgBodyLength());
        T packageData = doDecode(bodyBuf, bodyClass);
        packageData.setHeader(header);
        return packageData;
    }

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

    @Override
    public boolean check(ByteBuf buf) {
        byte checkCode = buf.getByte(buf.readableBytes() - 1);
        buf = buf.slice(0, buf.readableBytes() - 1);
        byte calculatedCheckCode = ByteBufUtils.xor(buf);

        return checkCode != calculatedCheckCode;
    }
}

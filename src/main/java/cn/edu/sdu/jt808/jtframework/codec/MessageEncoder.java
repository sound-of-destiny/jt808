package cn.edu.sdu.jt808.jtframework.codec;

import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.BCD8421Operator;
import cn.edu.sdu.jt808.jtframework.commons.BeanUtils;
import cn.edu.sdu.jt808.jtframework.message.AbstractHeader;
import cn.edu.sdu.jt808.jtframework.message.PackageData;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

public abstract class MessageEncoder<T extends AbstractHeader> extends AbstractMessageCodec {

    public MessageEncoder(Charset charset) {
        super(charset);
    }

    /**
     * 转义
     */
    public abstract ByteBuf escape(ByteBuf buf);

    /**
     * checksum
     */
    public abstract ByteBuf sign(ByteBuf buf);

    public ByteBuf encode(PackageData<T> body) {
        ByteBuf bodyBuf = encode(Unpooled.directBuffer(256), body);
        AbstractHeader header = body.getHeader();
        header.setMsgBodyLength(bodyBuf.readableBytes());
        ByteBuf headerBuf = encode(Unpooled.directBuffer(16), header);
        ByteBuf buf = Unpooled.wrappedBuffer(headerBuf, bodyBuf);
        buf = sign(buf);
        buf = escape(buf);
        return buf;
    }

    private ByteBuf encode(ByteBuf buf, Object body) {
        PropertyDescriptor[] pds = getPropertyDescriptor(body.getClass());
        Arrays.asList(pds).forEach(pd -> {
            Method readMethod = pd.getReadMethod();
            Object value = BeanUtils.getValue(body, readMethod);
            if (value != null) {
                Property prop = readMethod.getDeclaredAnnotation(Property.class);
                write(buf, prop, value);
            }
        });
        return buf;
    }

    private void write(ByteBuf buf, Property prop, Object value) {
        int length = prop.length();
        byte pad = prop.pad();

        switch (prop.type()) {
            case BYTE:
                buf.writeByte((int) value);
                break;
            case WORD:
                buf.writeShort((int) value);
                break;
            case DWORD:
                if (value instanceof Long)
                    buf.writeInt(((Long) value).intValue());
                else
                    buf.writeInt((int) value);
                break;
            case BYTES:
                buf.writeBytes((byte[]) value);
                break;
            case BCD8421:
                buf.writeBytes(BCD8421Operator.leftPad(BCD8421Operator.string2Bcd((String) value), length, pad));
                break;
            case STRING:
                byte[] strBytes = ((String) value).getBytes(charset);
                if (length > 0)
                    strBytes = BCD8421Operator.leftPad(strBytes, length, pad);
                buf.writeBytes(strBytes);
                break;
            case OBJ:
                encode(buf, value);
                break;
            case LIST:
                List list = (List) value;
                for (Object o : list)
                    encode(buf, o);
                break;
        }
    }
}

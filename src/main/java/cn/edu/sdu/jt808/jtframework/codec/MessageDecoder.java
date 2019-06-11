package cn.edu.sdu.jt808.jtframework.codec;

import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.BCD8421Operator;
import cn.edu.sdu.jt808.jtframework.commons.BeanUtils;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.exception.CheckSumErrorException;
import cn.edu.sdu.jt808.jtframework.exception.EnumTypeErrorException;
import cn.edu.sdu.jt808.jtframework.message.AbstractHeader;
import cn.edu.sdu.jt808.jtframework.message.PackageData;
import io.netty.buffer.ByteBuf;

import java.beans.PropertyDescriptor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public abstract class MessageDecoder extends AbstractMessageCodec {

    public MessageDecoder(Charset charset) {
        super(charset);
    }
    /**
     * 获取消息类型
     */
    public abstract int getMsgId(ByteBuf buf);

    /**
     * 反转义
     */
    public abstract ByteBuf unEscape(ByteBuf buf);

    /**
     * 校验
     */
    public abstract boolean check(ByteBuf buf);

    /**
     * 解析
     */
    public <T extends PackageData> T decode(ByteBuf buf, Class<? extends AbstractHeader> headerClass, Class<T> bodyClass) {
        buf = unEscape(buf);
        if (check(buf)) throw new CheckSumErrorException("checksum error");
        AbstractHeader header = doDecode(buf, headerClass);
        ByteBuf bodyBuf = buf.slice(header.getHeaderLength(), header.getMsgBodyLength());
        T packageData = doDecode(bodyBuf, bodyClass);
        packageData.setHeader(header);
        return packageData;
    }

    protected <T> T doDecode(ByteBuf buf, Class<T> targetClass) {
        T result = BeanUtils.newInstance(targetClass);
        PropertyDescriptor[] pds = getPropertyDescriptor(targetClass);
        for(PropertyDescriptor pd : pds) {
            Property prop = pd.getReadMethod().getDeclaredAnnotation(Property.class);
            if (prop.enumType() != -1) {
                try {
                    int type = (int) targetClass.getMethod("getType").invoke(result);
                    if (type != prop.enumType()) continue;
                } catch (Exception e) {
                    throw new EnumTypeErrorException("is not type");
                }
            }
            int length = getLength(result, prop);
            if (buf.isReadable(length)) {
                if (length == -1) length = buf.readableBytes();
                Object value = null;
                try {
                    value = read(buf, prop, length, pd);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                BeanUtils.setValue(result, pd.getWriteMethod(), value);
            }
        }

        return result;
    }

    protected Object read(ByteBuf buf, Property prop, int length, PropertyDescriptor pd){
        DataType type = prop.type();
        switch (type) {
            case BYTE:
                return (int) buf.readUnsignedByte();
            case WORD:
                return buf.readUnsignedShort();
            case DWORD:
                if (pd.getPropertyType().isAssignableFrom(Long.class))
                    return buf.readUnsignedInt();
                return (int) buf.readUnsignedInt();
            case LONG:
                return buf.readLong();
            case STRING:
                return buf.readCharSequence(length, charset).toString().trim();
            case OBJ:
                return doDecode(buf.readSlice(length), pd.getPropertyType());
            case LIST:
                List list = new ArrayList<>();
                Type clazz = ((ParameterizedType) pd.getReadMethod().getGenericReturnType()).getActualTypeArguments()[0];
                ByteBuf slice = buf.readSlice(length);
                while (slice.isReadable()) {
                    list.add(doDecode(slice, (Class<?>) clazz));
                }
                return list;
            case BCD8421:
                byte[] BCDBytes = new byte[length];
                buf.readBytes(BCDBytes);
                return BCD8421Operator.bcd2String(BCDBytes).trim();
            case BYTES:
                byte[] bytes = new byte[length];
                buf.readBytes(bytes);
                return bytes;
            default:
                return null;
        }
    }

}

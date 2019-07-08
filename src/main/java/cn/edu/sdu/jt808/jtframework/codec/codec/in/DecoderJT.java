package cn.edu.sdu.jt808.jtframework.codec.codec.in;

import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.codec.AbstractMessageCodec;
import cn.edu.sdu.jt808.jtframework.commons.BCD8421Operator;
import cn.edu.sdu.jt808.jtframework.commons.BeanUtils;
import cn.edu.sdu.jt808.jtframework.commons.DataType;
import cn.edu.sdu.jt808.jtframework.exception.EnumTypeErrorException;
import cn.edu.sdu.jt808.jtframework.exception.PropertyNameErrorException;
import cn.edu.sdu.jt808.jtframework.message.AbstractHeader;
import cn.edu.sdu.jt808.jtframework.message.PackageData;
import cn.edu.sdu.jt808.protocol.Header;
import io.netty.buffer.ByteBuf;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class DecoderJT extends AbstractMessageCodec implements Decoder  {
    @Override
    public <T extends PackageData> T decode(ByteBuf buf, Class<? extends AbstractHeader> headerClass, Class<T> bodyClass) {
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

    private Object read(ByteBuf buf, Property prop, int length, PropertyDescriptor pd) {
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
                return buf.readCharSequence(length, Charset.forName("GBK")).toString().trim();
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

package cn.edu.sdu.jt808.jtframework.codec.codec.in;

import cn.edu.sdu.jt808.jtframework.message.AbstractHeader;
import cn.edu.sdu.jt808.jtframework.message.PackageData;
import io.netty.buffer.ByteBuf;

public interface Decoder {
    <T extends PackageData> T decode(ByteBuf buf, Class<? extends AbstractHeader> headerClass, Class<T> bodyClass);
}

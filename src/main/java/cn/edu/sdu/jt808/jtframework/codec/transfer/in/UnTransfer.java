package cn.edu.sdu.jt808.jtframework.codec.transfer.in;

import io.netty.buffer.ByteBuf;

public interface UnTransfer {
    ByteBuf unEscape(ByteBuf buf);
}

package cn.edu.sdu.jt808.jtframework.commons;

public enum DataType {

    //无符号单字节整型（8位）
    BYTE(1),
    //无符号双字节整型（16位）
    WORD(2),
    //无符号四字节整型（32位）
    DWORD(4),
    //无符号八字节整型（64位）
    LONG(8),
    //N字节
    BYTES(-1),
    //8421码，N字节
    BCD8421(-1),
    //字符串，若无数据置空
    STRING(-1),
    //对象
    OBJ(-1),
    //列表
    LIST(-1);

    public int length;

    DataType(int length) {
        this.length = length;
    }

}
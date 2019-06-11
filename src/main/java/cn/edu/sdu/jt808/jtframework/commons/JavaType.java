package cn.edu.sdu.jt808.jtframework.commons;

public enum JavaType {
    INT(0),
    LONG(0L),
    FLOAT(0F),
    DOUBLE(0D),
    STRING(""),
    BYTE(0b0),
    MESSAGE(null);

    JavaType(final Object defaultDefault) {
        this.defaultDefault = defaultDefault;
    }

    private final Object defaultDefault;
}

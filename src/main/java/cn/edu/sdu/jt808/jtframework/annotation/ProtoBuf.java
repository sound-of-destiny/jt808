package cn.edu.sdu.jt808.jtframework.annotation;

import cn.edu.sdu.jt808.jtframework.commons.JavaType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ProtoBuf {

    JavaType type();
}

package cn.edu.sdu.jt808.jtframework.annotation;

import cn.edu.sdu.jt808.jtframework.commons.DataType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Property {

    int index() default -1;

    String[] indexOfName() default "";

    int length() default -1;

    String lengthName() default "";

    DataType type() default DataType.BYTE;

    int enumType() default -1;

    byte pad() default 0;

    String desc() default "";
}

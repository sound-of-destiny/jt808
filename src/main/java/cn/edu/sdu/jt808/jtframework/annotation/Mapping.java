package cn.edu.sdu.jt808.jtframework.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Mapping {

    int[] types();

    String desc() default "";

}
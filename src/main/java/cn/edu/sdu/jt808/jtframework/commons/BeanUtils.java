package cn.edu.sdu.jt808.jtframework.commons;

import cn.edu.sdu.jt808.jtframework.commons.lru.Cache;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class BeanUtils {

    private static Cache<Class<?>, BeanInfo> beanInfoCache = new Cache<>(32);

    public static BeanInfo getBeanInfo(Class<?> key) {
        return beanInfoCache.get(key, () -> {   // 生成新的 value
           BeanInfo beanInfo = Introspector.getBeanInfo(key);
           Introspector.flushCaches();          // TODO
           return beanInfo;
        });
    }

    public static <T> T newInstance(Class<T> target) {
        try {
            return target.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Object getValue(Object obj, String name, Object defValue) {
        Object value = getValue(obj, name);
        if (value != null)
            return value;
        return defValue;
    }

    public static void setValue(Object obj, Method setter, Object value) {

        if (setter != null) {
            if (value != null) {
                if (!setter.getParameterTypes()[0].isAssignableFrom(value.getClass())) {
                    return;
                }
            }

            try {
                setter.invoke(obj, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Object getValue(Object obj, String name) {
        if (obj == null)
            return null;

        BeanInfo beanInfo = getBeanInfo(obj.getClass());
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds)
            if (name.equals(pd.getName()))
                return getValue(obj, pd.getReadMethod());
        return null;
    }

    public static Object getValue(Object obj, Method getter) {
        if (getter != null)
            try {
                return getter.invoke(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return null;
    }
}

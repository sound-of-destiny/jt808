package cn.edu.sdu.jt808.jtframework.codec;

import cn.edu.sdu.jt808.jtframework.annotation.Property;
import cn.edu.sdu.jt808.jtframework.commons.BeanUtils;
import cn.edu.sdu.jt808.jtframework.commons.lru.Cache;

import java.beans.BeanInfo;
import java.beans.PropertyDescriptor;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractMessageCodec {

    protected Charset charset;

    public AbstractMessageCodec(Charset charset) {
        this.charset = charset;
    }

    private final Cache<Class<?>, PropertyDescriptor[]> propertyDescriptorCache = new Cache<>(32);

    public PropertyDescriptor[] getPropertyDescriptor(Class<?> key) {
        return propertyDescriptorCache.get(key, () -> {
            BeanInfo beanInfo = BeanUtils.getBeanInfo(key);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            List<PropertyDescriptor> result = new ArrayList<>();

            for (PropertyDescriptor pd : pds)
                if (pd.getReadMethod().isAnnotationPresent(Property.class))
                    result.add(pd);
            result.sort(Comparator.comparingInt(pd -> pd.getReadMethod().getAnnotation(Property.class).index()));
            return result.toArray(new PropertyDescriptor[0]);
        });
    }

    public static int getLength(Object obj, Property prop) {
        int length = prop.length();
        if (length == -1)
            if ("".equals(prop.lengthName()))
                length = prop.type().length;
            else
                length = (int) BeanUtils.getValue(obj, prop.lengthName(), 0);
        return length;
    }

    public static int getIndex(Object obj, Property prop) {
        int index = prop.index();
        for (String name : prop.indexOfName())
            if (!"".equals(name))
                index += (int) BeanUtils.getValue(obj, name, 0);
        return index;
    }

}

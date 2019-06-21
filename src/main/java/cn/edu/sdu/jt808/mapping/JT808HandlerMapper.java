package cn.edu.sdu.jt808.mapping;

import cn.edu.sdu.jt808.jtframework.annotation.Endpoint;
import cn.edu.sdu.jt808.jtframework.annotation.Mapping;
import cn.edu.sdu.jt808.jtframework.commons.BeanUtils;
import cn.edu.sdu.jt808.jtframework.commons.ClassUtils;
import cn.edu.sdu.jt808.jtframework.commons.lru.LRUMap;
import cn.edu.sdu.jt808.jtframework.mapping.Handler;
import cn.edu.sdu.jt808.jtframework.mapping.HandlerMapper;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JT808HandlerMapper implements HandlerMapper {

    private Map<Integer, Handler> handlerMap = new LRUMap<>(64);

    public JT808HandlerMapper(String... packageNames) {
        for (String packageName : packageNames) {
            addPackage(packageName);
        }
    }

    private void addPackage(String packageName) {
        List<Class<?>> handlerClassList = ClassUtils.getClassList(packageName, Endpoint.class);

        for (Class<?> handlerClass : handlerClassList) {
            Method[] methods = handlerClass.getDeclaredMethods();
            Arrays.asList(methods).forEach(method -> {
                if (method.isAnnotationPresent(Mapping.class)) {
                    Mapping annotation = method.getAnnotation(Mapping.class);
                    String desc = annotation.desc();
                    int[] types = annotation.types();
                    Handler value = new Handler(BeanUtils.newInstance(handlerClass), method, desc);
                    for (int type : types) {
                        handlerMap.put(type, value);
                    }
                }
            });
        }
    }

    public Handler getHandler(Integer key) {
        return handlerMap.get(key);
    }

}
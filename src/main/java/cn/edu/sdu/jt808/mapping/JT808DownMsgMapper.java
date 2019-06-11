package cn.edu.sdu.jt808.mapping;

import cn.edu.sdu.jt808.jtframework.annotation.MsgType;
import cn.edu.sdu.jt808.jtframework.commons.ClassUtils;
import cn.edu.sdu.jt808.jtframework.commons.lru.LRUMap;

import java.util.List;
import java.util.Map;

public class JT808DownMsgMapper {

    private Map<Integer, Class<?>> downMsgMap = new LRUMap<>(64);

    public JT808DownMsgMapper(String... packageNames) {
        for (String packageName : packageNames) {
            addPackage(packageName);
        }
    }

    private void addPackage(String packageName) {
        List<Class<?>> downMsgClassList = ClassUtils.getClassList(packageName, MsgType.class);
        for (Class<?> handlerClass : downMsgClassList) {
            MsgType msgType = handlerClass.getAnnotation(MsgType.class);
            int type = msgType.value()[0];
            downMsgMap.put(type, handlerClass);
        }
    }

    public Class<?> getDownMsg(Integer key) {
        return downMsgMap.get(key);
    }
}

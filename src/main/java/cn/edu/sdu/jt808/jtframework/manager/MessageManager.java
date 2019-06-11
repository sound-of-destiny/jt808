package cn.edu.sdu.jt808.jtframework.manager;

import cn.edu.sdu.jt808.jtframework.message.SyncFuture;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum MessageManager {

    INSTANCE;

    private Map<String, SyncFuture> map = new ConcurrentHashMap<>();


    public synchronized SyncFuture receive(String key) {
        SyncFuture future = new SyncFuture();
        map.put(key, future);
        return future;
    }

    public synchronized void remove(String key) {
        map.remove(key);
    }

    public synchronized void put(String key, Object value) {
        if (key == null) return;
        SyncFuture syncFuture = map.get(key);
        if (syncFuture == null)
            return;
        syncFuture.setResponse(value);
    }

}

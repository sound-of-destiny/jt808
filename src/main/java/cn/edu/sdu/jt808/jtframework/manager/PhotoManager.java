package cn.edu.sdu.jt808.jtframework.manager;

import cn.edu.sdu.jt808.jtframework.message.PhotoFuture;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum PhotoManager {
    INSTANCE;

    private Map<String, PhotoFuture> map = new ConcurrentHashMap<>();


    public synchronized PhotoFuture receive(String key, int a) {
        PhotoFuture future = new PhotoFuture(a);
        map.put(key, future);
        return future;
    }

    public synchronized void remove(String key) {
        map.remove(key);
    }

    public synchronized void put(String key, Object value) {
        PhotoFuture photoFuture = map.get(key);
        if (photoFuture == null)
            return;
        photoFuture.setResponse(value);
    }

}

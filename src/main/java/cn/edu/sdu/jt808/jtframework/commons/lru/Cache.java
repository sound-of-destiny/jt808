package cn.edu.sdu.jt808.jtframework.commons.lru;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用读写锁可使类线程同步
 * @param <K>
 * @param <V>
 */
public class Cache<K, V> {

    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    private Lock readLock = rwl.readLock();
    private Lock writeLock = rwl.writeLock();

    private Map<K, V> cache;

    public Cache() {
        this.cache = new LRUMap<>(16);
    }

    public Cache(int initCapacity) {
        this.cache = new LRUMap<>(initCapacity);
    }

    public V get(K key, Callable<? extends V> loader) {
        readLock.lock();
        V value = cache.get(key);
        try {
            if (value == null) {
                readLock.unlock();
                writeLock.lock();
                value = cache.get(key);
                if (value == null) {
                    try {
                        value = loader.call();
                        cache.put(key, value);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                writeLock.unlock();
                readLock.lock();
            }
        } finally {
            readLock.unlock();
        }
        return value;
    }
}

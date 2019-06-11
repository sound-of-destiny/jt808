package cn.edu.sdu.jt808.jtframework.commons.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 模仿自 mysql.jdbc.util LRUCache
 *
 * @param <K>
 * @param <V>
 */
// TODO 将 LinkedHashMap 改为
public class LRUMap<K, V> extends LinkedHashMap<K, V> {

    private int maxElements;

    public LRUMap(int maxSize) {
        super(maxSize, 0.75F, true);
        this.maxElements = maxSize;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > this.maxElements;
    }
}

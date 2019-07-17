package cn.edu.sdu.jt808.jtframework.monitor;

import java.util.concurrent.atomic.AtomicLong;

public interface Observer {
    void update(AtomicLong count, AtomicLong countSuccess);
}

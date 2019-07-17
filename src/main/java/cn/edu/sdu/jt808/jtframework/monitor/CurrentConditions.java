package cn.edu.sdu.jt808.jtframework.monitor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class CurrentConditions implements Observer {

    private AtomicLong count;
    private AtomicLong countSuccess;

    @Override
    public void update(AtomicLong count, AtomicLong countSuccess) {
        this.count = count;
        this.countSuccess = countSuccess;
        display();
    }

    public void display() {
        log.info("发送指令数　{}, 指令成功数 {}", count.get(), countSuccess.get());
    }
}

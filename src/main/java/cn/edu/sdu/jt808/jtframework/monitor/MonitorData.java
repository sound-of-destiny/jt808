package cn.edu.sdu.jt808.jtframework.monitor;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class MonitorData implements Subject {

    private AtomicLong count = new AtomicLong(0);
    private AtomicLong countSuccess = new AtomicLong(0);

    public AtomicLong getCount() {
        return count;
    }

    public AtomicLong getCountSuccess() {
        return countSuccess;
    }

    public ArrayList<Observer> mObserver;

    public MonitorData() {
        mObserver = new ArrayList<>();
    }

    public void dataChange() {
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        mObserver.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        mObserver.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : mObserver) {
            o.update(count, countSuccess);
        }
    }
}

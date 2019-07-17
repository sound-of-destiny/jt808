package cn.edu.sdu.jt808.jtframework.monitor;

public interface Subject {

    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}

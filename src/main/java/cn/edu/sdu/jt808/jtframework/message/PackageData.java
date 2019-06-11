package cn.edu.sdu.jt808.jtframework.message;

public class PackageData<T extends AbstractHeader> {

    protected T header;

    public PackageData() {
    }

    public PackageData(T header) {
        this.header = header;
    }

    public T getHeader() {
        return header;
    }

    public void setHeader(T header) {
        this.header = header;
    }

}
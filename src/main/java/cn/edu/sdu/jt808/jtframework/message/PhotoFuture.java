package cn.edu.sdu.jt808.jtframework.message;

import java.util.concurrent.*;

public class PhotoFuture<T> implements Future<T> {

    private CountDownLatch cdl;

    // 需要响应线程设置的响应结果
    private T response;

    // Future的请求时间，用于计算Future是否超时
    private long beginTime = System.currentTimeMillis();

    public PhotoFuture(int a) {
        cdl = new CountDownLatch(a);
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return response != null;
    }

    @Override
    public T get() throws InterruptedException, ExecutionException {
        cdl.await();
        return this.response;
    }

    @Override
    public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        if (cdl.await(timeout, unit)) {
            return this.response;
        }
        return null;
    }

    // 用于设置响应结果，并且做countDown操作，通知请求线程
    public void setResponse(T response) {
        byte[] next = (byte[]) response;
        byte[] old = (byte[]) this.response;
        if (old == null) old = new byte[]{};
        int length = old.length + next.length;
        byte[] tmp = new byte[length];
        System.arraycopy(old, 0, tmp, 0, old.length);
        System.arraycopy(next, 0, tmp, old.length, next.length);
        this.response = (T) tmp;
        cdl.countDown();
    }

    public long getBeginTime() {
        return beginTime;
    }
}

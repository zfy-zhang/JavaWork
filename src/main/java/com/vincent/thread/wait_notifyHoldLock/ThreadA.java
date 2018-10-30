package com.vincent.thread.wait_notifyHoldLock;

/**
 * Created with IDEA
 * author:vincent
 * Date:2018/10/30
 */
public class ThreadA extends Thread {

    private Object lock;

    public ThreadA(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(lock);
    }
}

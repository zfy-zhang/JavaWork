package com.vincent.thread.wait_notifyHoldLock;

/**
 * Created with IDEA
 * author:vincent
 * Date:2018/10/30
 */
public class Test {

    public static void main(String[] args) {

        Object lock = new Object();

        ThreadA a = new ThreadA(lock);
        a.start();

        NotifyThread notifyThread = new NotifyThread(lock);
        notifyThread.start();

        SynNotifyMethodThread c = new SynNotifyMethodThread(lock);
        c.start();

    }
}

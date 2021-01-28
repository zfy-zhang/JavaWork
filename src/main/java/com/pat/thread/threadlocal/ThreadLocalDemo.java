package com.pat.thread.threadlocal;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/19
 * @Modify
 * @since
 */
public class ThreadLocalDemo {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    static void set(String str) {
        threadLocal.set(str + ":" + Thread.currentThread().getId());
    }

    static String get() {
        return threadLocal.get();
    }

    static void print(String str) {
        System.out.println(str + ":" + threadLocal.get());
        threadLocal.remove();
    }


    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                set("threadOne");
                print("threadOne");
                System.out.println("threadOne remove after" + ":" + get());
            }
        });

        Thread threadTow = new Thread(new Runnable() {
            @Override
            public void run() {
                set("threadTow");
                print("threadTow");
                System.out.println("threadTow remove after" + ":" + get());
            }
        });

        threadOne.start();
        threadTow.start();
    }
}

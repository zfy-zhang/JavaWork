package com.pat.concurency;

/**
 * @Description: 关于可见性测试代码
 * @Author 不才人
 * @Create Date 2020/5/18 11:16 上午
 * @Modify
 */
public class VisibilityDemo {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        int calc = calc();
        System.out.println(calc);
    }

    private void add() {
        for (int i = 0; i< 10000; i++) {
            count ++;
        }
    }

    private static int calc() throws InterruptedException {
        final VisibilityDemo visibilityDemo = new VisibilityDemo();
        Thread t1 = new Thread(() -> {
            visibilityDemo.add();
        });

        Thread t2 = new Thread(() -> {
            visibilityDemo.add();
        });

        // 启动线程
        t1.start();
        t2.start();

        // 等待线程执行结束
        t1.join();
        t2.join();

        return count;
    }
}

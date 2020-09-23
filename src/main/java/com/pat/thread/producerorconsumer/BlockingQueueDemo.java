package com.pat.thread.producerorconsumer;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/8/13
 * @Modify
 * @since
 */
public class BlockingQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<Object> queues = new ArrayBlockingQueue<>(10);
        Runnable producer = () -> {
            while (true) {
                try {
                    queues.put(new Object());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();

        Runnable consumer = () -> {
            while (true) {
                try {
                    queues.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread().start();
        new Thread().start();
    }
}

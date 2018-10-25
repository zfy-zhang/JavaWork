package com.vincent.base.random;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created with IDEA
 * author:vincent
 * Date:2018/10/25
 */
public class GoodCase {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println(ThreadLocalRandom.current().nextInt());
                System.out.println(ThreadLocalRandom.current().nextInt());
                System.out.println(ThreadLocalRandom.current().nextInt());
            }).start();
        }
    }

}

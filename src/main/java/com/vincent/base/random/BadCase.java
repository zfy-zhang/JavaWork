package com.vincent.base.random;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created with IDEA
 * author:vincent
 * Date:2018/10/25
 */
public class BadCase {

    public static void main(String[] args) {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        for (int i = 0; i< 10; i++) {
            new Thread(() -> {
                System.out.println(rand.nextInt());
            }).start();
        }
    }
}

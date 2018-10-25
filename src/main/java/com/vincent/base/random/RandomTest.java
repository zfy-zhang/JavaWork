package com.vincent.base.random;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created with IDEA
 * author:vincent
 * Date:2018/10/25
 */
public class RandomTest {

    public static void main(String[] args) {
        System.out.println(ThreadLocalRandom.current().nextInt());
        System.out.println(ThreadLocalRandom.current().nextInt());
        System.out.println(ThreadLocalRandom.current().nextInt(10));
    }
}

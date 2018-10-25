package com.vincent.base.random;

import java.util.Random;

/**
 * Created with IDEA
 * author:vincent
 * Date:2018/10/25
 */
public class RandomDemo {

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt());
        System.out.println(random.nextInt(20000));
    }
}

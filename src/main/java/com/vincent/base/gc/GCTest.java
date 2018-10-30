package com.vincent.base.gc;

/**
 * Created with IDEA
 * author:vincent
 * Date:2018/10/30
 */
public class GCTest {

    public static void main(String[] args) {
        byte[] allocation1, allocation2,allocation3,allocation4,allocation5;
        allocation1 = new byte[309000*1024];
        allocation2 = new byte[900*1024];
        allocation3 = new byte[1000*1024];
        allocation4 = new byte[1000*1024];
        allocation5 = new byte[1000*1024];
    }

}

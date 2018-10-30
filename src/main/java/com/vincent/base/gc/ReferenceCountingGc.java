package com.vincent.base.gc;

/**
 * Created with IDEA
 * author:vincent
 * Date:2018/10/30
 */
public class ReferenceCountingGc {

    Object instance = null;
    public static void main(String[] args) {
        ReferenceCountingGc objA = new ReferenceCountingGc();
        ReferenceCountingGc objB = new ReferenceCountingGc();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;

    }
}

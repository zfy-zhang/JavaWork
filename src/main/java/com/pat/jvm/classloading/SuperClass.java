package com.pat.jvm.classloading;

/**
 * @Description
 * @Author 不才人
 * @Create Date 2020/6/15 2:52 下午
 * @Modify
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init！");
    }
    public static int value = 123;
}

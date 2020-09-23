package com.pat.jvm.classloading;

/**
 * @Description
 * @Author 不才人
 * @Create Date 2020/6/15 3:09 下午
 * @Modify
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init！");
    }
}

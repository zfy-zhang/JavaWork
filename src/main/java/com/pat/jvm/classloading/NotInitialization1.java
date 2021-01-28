package com.pat.jvm.classloading;

import java.util.ArrayList;

/**
 * @Description
 * @Author 不才人
 * @Create Date 2020/6/15 3:10 下午
 * @Modify
 */
public class NotInitialization1 {

    public static void main(String[] args) {
        SuperClass[] sca = new SuperClass[10];
    }
}

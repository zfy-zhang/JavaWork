package com.pat.jvm.classloading;

/**
 * @Description
 * @Author 不才人
 * @Create Date 2020/6/15 3:10 下午
 * @Modify
 */
public class NotInitialization {
//    public static void main(String[] args) {
//        System.out.println(SubClass.value);
//    }
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
    }
}

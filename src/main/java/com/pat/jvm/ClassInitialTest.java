package com.pat.jvm;

/**
 * @Description
 * @Author 不才人
 * @Create Date 2020/6/8 9:54 上午
 * @Modify
 */
public class ClassInitialTest {

    private static int num = 1;

    static {
        num = 2;
    }
    public static void main(String[] args) {
        System.out.println(ClassInitialTest.num);
    }
}

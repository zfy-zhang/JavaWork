package com.pat.jvm;

/**
 * @Description
 * @Author 不才人
 * @Create Date 2020/6/9 12:37 下午
 * @Modify
 */
public class StringTest {
    public static void main(String[] args) {
//        String s = new String(new char[]{'1'});
        String s = new String("1");
//        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("2") + new String("2");
        s3.intern();
        String s4 = "22";
        System.out.println(s3 == s4);
    }
}

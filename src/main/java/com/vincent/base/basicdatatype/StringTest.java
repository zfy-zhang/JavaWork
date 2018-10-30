package com.vincent.base.basicdatatype;

import org.junit.Test;

/**
 * Created with IDEA
 * author:vincent
 * Date:2018/10/30
 */
public class StringTest {

    /**
     *     直接使用双引号声明出来的String对象会直接存储在常量池中。
     *     如果不是用双引号声明的String对象，可以使用String提供的intern方String.intern() 是一个Native方法，
     *     它的作用是：如果运行时常量池中已经包含一个等于此String对象内容的字符串，则返回常量池中该字符串的引用；
     *     如果没有，则在常量池中创建与此 String 内容相同的字符串，并返回常量池中创建的字符串的引用。
     */
    @Test
    public void testString() {

        String s1 = new String("计算机");
        String s2 = s1.intern();
        String s3 = "计算机";
        System.out.println(s2);//计算机
        System.out.println(s1 ==s2);
        System.out.println(s3 ==s2);
    }

    @Test
    public void testStringAppend() {
        String str1 = "str";
        String str2 = "ing";
        String str3 = "str" + "ing";//常量池中的对象
        String str4 = str1 + str2; //在堆上创建的新的对象
        String str5 = "string";//常量池中的对象
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false
    }

    /**
     *解释：
     * 先有字符串"abc"放入常量池，然后 new 了一份字符串"abc"放入Java堆(字符串常量"abc"在编译期就已经确定放入常量池，
     * 而 Java 堆上的"abc"是在运行期初始化阶段才确定)，然后 Java 栈的 str1 指向Java堆上的"abc"。
     */
    @Test
    public void testNewString() {
        String s1 = new String("abc");// 堆内存的地值值
        String s2 = "abc";
        System.out.println(s1 == s2);// 输出false,因为一个是堆内存，一个是常量池的内存，故两者是不同的。
        System.out.println(s1.equals(s2));// 输出true
    }

}

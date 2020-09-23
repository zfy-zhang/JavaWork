package com.pat.reflect;

import java.lang.reflect.Field;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/8/15
 * @Modify
 * @since
 */
public class StringReflectionDemo {

    /**
     * java 1.5 开始，反射可以修改对象的属性，即使呗final修饰
     * @param args
     */
    public static void main(String[] args) throws Exception {

        String value = "Hello World";
        String otherValue = "不才人";

        System.out.println("修改前的值：" + value);
        Field valueField = String.class.getDeclaredField("value");
        valueField.setAccessible(true);

        valueField.set(value, otherValue.toCharArray());

        System.out.println("修改后的值：" + value);

    }
}

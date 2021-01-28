package com.pat.classloader;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Description: 打印 String 类的所有方法信息
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public class StringClassDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("java.lang.String");

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            String mod = Modifier.toString(method.getModifiers());
            System.out.print(mod + " " + method.getName() + " (");
            Class<?>[]  ps = method.getParameterTypes();
            if (ps.length == 0) System.out.print(')');
            for (int i = 0; i < ps.length; i++) {
                char end = i==ps.length - 1 ? ')' : ',';
                System.out.print(ps[i].getSimpleName() + end);
            }
            System.out.println();
        }
    }
}

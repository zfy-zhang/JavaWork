package com.pat.jvm.classloading;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: 类加载器与 instanceof 关键字演示
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/11/18
 * @Modify
 * @since
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = classLoader.loadClass("com.pat.jvm.classloading.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.pat.jvm.classloading.ClassLoaderTest);
    }
}

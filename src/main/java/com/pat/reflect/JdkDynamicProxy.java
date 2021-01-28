package com.pat.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/11/23
 * @Modify
 * @since
 */
public class JdkDynamicProxy implements InvocationHandler {

    private final Service service = new ServiceImpl();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(service, args);
        System.out.println("After invoking");
        return null;
    }

    public static void main(String[] args) {
        Class<?> clazz = ServiceImpl.class;
        Service proxy = (Service) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] {Service.class}, new JdkDynamicProxy());
        proxy.process();
    }
}

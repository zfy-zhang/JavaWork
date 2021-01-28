package com.pat.reflect;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/11/23
 * @Modify
 * @since
 */
public class CGLIBDynamicProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before invoke".concat(method.getName()));
        methodProxy.invokeSuper(object, args);
//        methodProxy.invoke(object, args);
        System.out.println("After invoke".concat(method.getName()));
        return null;
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ServiceImpl.class);
        enhancer.setCallback(new CGLIBDynamicProxy());
        ServiceImpl service = (ServiceImpl) enhancer.create();
        service.process();
    }
}

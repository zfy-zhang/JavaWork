package com.pat.design.di;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/9/23
 * @Modify
 * @since
 */
public class NoSuchBeanDefinitionException extends RuntimeException {
    public NoSuchBeanDefinitionException(String message) {
        super(message);
    }
}

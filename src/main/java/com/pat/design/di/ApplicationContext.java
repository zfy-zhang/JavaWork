package com.pat.design.di;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/9/23
 * @Modify
 * @since
 */
public interface ApplicationContext {
    Object getBean(String beanId);
}

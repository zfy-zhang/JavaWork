package com.pat.design.di;

import java.io.InputStream;
import java.util.List;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/9/23
 * @Modify
 * @since
 */
public interface BeanConfigParser {
    List<BeanDefinition> parse(InputStream inputStream);
}

package com.pat.event;

import java.util.EventListener;

/**
 * @Description: 应用事件监听器
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 * @param <E> ApplicationEvent 以及它的子类型
 */
public interface ApplicationEventListener<E extends ApplicationEvent> extends EventListener {

    /**
     * 处理事件
     * @param event
     */
    void onEvent(E event);
}

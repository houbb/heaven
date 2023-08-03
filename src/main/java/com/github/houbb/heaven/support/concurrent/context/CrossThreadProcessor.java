package com.github.houbb.heaven.support.concurrent.context;

import java.util.Map;

/**
 * 跨线程处理类
 *
 * @since 0.3.0
 */
public interface CrossThreadProcessor {

    /**
     * 初始化上下文
     * @param contextMap 上下文
     */
    void initContext(Map<String, Object> contextMap);

    /**
     * 执行之前
     * @param contextMap 上下文
     */
    void beforeExecute(Map<String, Object> contextMap);

    /**
     * 执行之后
     * @param contextMap 上下文
     */
    void afterExecute(Map<String, Object> contextMap);

}


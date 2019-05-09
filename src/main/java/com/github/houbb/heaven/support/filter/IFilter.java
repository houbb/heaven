package com.github.houbb.heaven.support.filter;

/**
 * 过滤接口
 * @author binbin.hou
 * @since 0.0.1
 */
public interface IFilter<T> {

    /**
     * 过滤
     * @param t 元素
     * @return 结果
     */
    boolean filter(final T t);

}

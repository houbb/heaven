package com.github.houbb.heaven.support.condition;

/**
 * 条件接口
 * 迁移到
 * @author binbin.hou
 * @since 0.0.6
 */
public interface ICondition<T> {

    /**
     * 满足条件
     * @param t 元素
     * @return 结果
     */
    boolean condition(final T t);

}

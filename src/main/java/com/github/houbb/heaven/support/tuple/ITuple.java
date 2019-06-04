package com.github.houbb.heaven.support.tuple;

import java.util.List;

/**
 * 元组抽象接口
 * （1）实现 {@link Iterable}，则可以使用 foreach 语法。
 * @author binbin.hou
 * @since 0.1.9
 */
public interface ITuple extends List<Object> {

    /**
     * 转换为列表
     * @return 列表
     */
    List<Object> toList();

}

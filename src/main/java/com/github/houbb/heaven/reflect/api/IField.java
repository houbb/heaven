package com.github.houbb.heaven.reflect.api;

import com.github.houbb.heaven.util.util.Optional;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

/**
 * java 字段相关信息
 * @author binbin.hou
 * @since 0.1.5
 */
public interface IField extends IMember {

    /**
     * 原始字段信息
     * @return 原始字段信息
     */
    Field field();

    /**
     * 设置值
     * @param value 值
     * @return this
     */
    IField value(final Object value);

    /**
     * 当前字段的值
     * @return 字段的值
     */
    Object value();

    /**
     * 注解列表
     * @return 注解列表
     */
    List<Annotation> annotations();

    /**
     * 根据注解类型获取对应的 Optional
     * @param type 类型
     * @return optional 信息
     */
    Optional<Annotation> annotationOpt(final Class type);

    /**
     * 根据注解类型获取对应的
     * @param type 类型
     * @return optional 信息
     */
    Annotation annotation(final Class type);

}

package com.github.houbb.heaven.annotation.env;

import java.lang.annotation.*;

/**
 * 开发环境
 * 1. 表示当前方法禁止用于生产环境，仅可用于开发测试。
 * @author binbin.hou
 * @since 0.1.10
 */
@Inherited
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Dev {
}

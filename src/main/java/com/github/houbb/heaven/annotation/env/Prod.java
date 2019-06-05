package com.github.houbb.heaven.annotation.env;

import java.lang.annotation.*;

/**
 * 开发环境
 * 1. 表示当前方法性能安全性各方面达标，可以用于生产环境。
 * @author binbin.hou
 * @since 0.1.10
 */
@Inherited
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Prod {
}

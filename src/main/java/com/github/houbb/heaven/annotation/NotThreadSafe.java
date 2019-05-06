package com.github.houbb.heaven.annotation;

import java.lang.annotation.*;

/**
 * 线程不安全安全注解
 * @author binbin.hou
 * @since 0.0.5
 */
@Documented
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotThreadSafe {
}

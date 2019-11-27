package com.github.houbb.heaven.annotation.reflect;

/**
 * 主要针对 jdk7 及其以前的参数名称获取比较困难，采取的一种妥协方案。
 * <p> project: heaven-Param </p>
 * <p> create on 2019/11/27 21:09 </p>
 *
 * @author Administrator
 * @since 0.1.51
 */
public @interface Param {

    /**
     * 参数名称
     * @return 参数名称
     * @since 0.1.51
     */
    String value();

}

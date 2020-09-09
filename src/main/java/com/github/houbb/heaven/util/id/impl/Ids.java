package com.github.houbb.heaven.util.id.impl;

/**
 * Id 工具類
 * @author binbin.hou
 * @since 0.1.37
 */
@Deprecated
public final class Ids {

    private Ids(){}

    /**
     * uuid32
     * @return string
     * @since 0.1.37
     */
    public static String uuid32() {
        return UUID32.getInstance().genId();
    }

}

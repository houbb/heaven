package com.github.houbb.heaven.util.id.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.id.Id;

/**
 * 恒定 id 返回
 * @author binbin.hou
 * @since 0.1.12
 */
@ThreadSafe
public class ConstId implements Id {

    /**
     * 恒定标识
     */
    private final String id;

    public ConstId(String id) {
        this.id = id;
    }

    @Override
    public String genId() {
        return id;
    }

}

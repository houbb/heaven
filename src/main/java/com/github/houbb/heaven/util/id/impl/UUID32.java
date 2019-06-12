package com.github.houbb.heaven.util.id.impl;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.constant.PunctuationConst;
import com.github.houbb.heaven.util.id.Id;

import java.util.UUID;

/**
 * UUID 返回
 * 默认和 uuid 保持一致，使用 32 位的 uuid
 * @author binbin.hou
 * @since 0.1.12
 */
@ThreadSafe
public class UUID32 implements Id {

    @Override
    public String genId() {
        return UUID.randomUUID().toString()
                .replaceAll(PunctuationConst.MIDDLE_LINE, PunctuationConst.EMPTY);
    }

    public static void main(String[] args) {
        System.out.println(new UUID32().genId().length());
    }

}

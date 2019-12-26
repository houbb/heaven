package com.github.houbb.heaven.support.cache.impl;

import com.github.houbb.heaven.annotation.NotThreadSafe;
import com.github.houbb.heaven.reflect.api.IField;
import com.github.houbb.heaven.reflect.util.Classes;

import java.util.List;

/**
 * 多个字段的缓存
 * @author binbin.hou
 * @since 0.1.5
 */
@NotThreadSafe
public class DefaultFieldListCache extends AbstractCache<Class, List<IField>> {

    @Override
    protected List<IField> buildValue(Class key) {
        return Classes.getFields(key);
    }

}

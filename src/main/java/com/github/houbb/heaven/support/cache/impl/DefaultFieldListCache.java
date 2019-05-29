package com.github.houbb.heaven.support.cache.impl;

import com.github.houbb.heaven.annotation.NotThreadSafe;
import com.github.houbb.heaven.reflect.api.IField;
import com.github.houbb.heaven.support.cache.ICache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 多个字段的缓存
 * @author binbin.hou
 * @since 0.1.5
 */
@NotThreadSafe
public class DefaultFieldListCache implements ICache<Class, List<IField>> {

    /**
     * 存放信息的 map
     */
    private static final Map<Class, List<IField>> MAP = new ConcurrentHashMap<>();

    @Override
    public List<IField> get(Class key) {
        return MAP.get(key);
    }

    @Override
    public void set(Class key, List<IField> value) {
        MAP.put(key, value);
    }

}

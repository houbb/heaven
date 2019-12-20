package com.github.houbb.heaven.support.cache.impl;

import com.github.houbb.heaven.support.cache.ICache;
import com.github.houbb.heaven.util.lang.ObjectUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 抽象 cache 实现
 * @author binbin.hou
 * @since 0.1.63
 */
public abstract class AbstractCache<K, V> implements ICache<K, V> {

    /**
     * cache 实例
     * @since 0.1.63
     */
    private final Map<K, V> cache = new ConcurrentHashMap<>();

    /**
     * 构建值
     * @param key key
     * @return 结果
     * @since 0.1.63
     */
    protected abstract V buildValue(final K key);

    @Override
    public V get(K key) {
        V result = cache.get(key);
        if(ObjectUtil.isNotNull(result)) {
            return result;
        }

        // 构建
        result = buildValue(key);

        // 设置
        set(key, result);

        return result;
    }

    @Override
    public void set(K key, V value) {
        cache.put(key, value);
    }

}

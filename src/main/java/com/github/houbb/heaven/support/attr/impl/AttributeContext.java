package com.github.houbb.heaven.support.attr.impl;

import com.github.houbb.heaven.support.attr.IAttributeContext;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.util.Optional;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 属性上下文上下文
 *
 * @author binbin.hou
 * @since 0.1.41
 */
public class AttributeContext implements IAttributeContext {

    /**
     * 上下文
     * @since 0.1.41
     */
    private Map<String, Object> context;

    public AttributeContext() {
        this.context = new ConcurrentHashMap<>();
    }

    /**
     * 设置属性
     * @param key key
     * @param value 值
     * @return this
     * @since 0.1.41
     */
    @Override
    public AttributeContext putAttr(final String key, final Object value) {
        context.put(key, value);
        return this;
    }

    /**
     * 获取配置属性
     * @return 目标对象
     * @since 0.1.41
     */
    @Override
    public Object getAttr(final String key) {
        return context.get(key);
    }

    @Override
    public Optional<Object> getAttrOptional(String key) {
        Object object = getAttr(key);
        return Optional.ofNullable(object);
    }

    @Override
    public String getAttrString(String key) {
        Object object = getAttr(key);
        return ObjectUtil.objectToString(object);
    }

    @Override
    public Boolean getAttrBoolean(String key) {
        Optional<Object> objectOptional = getAttrOptional(key);
        return objectOptional.getCastOrNull(Boolean.class);
    }

    @Override
    public Character getAttrCharacter(String key) {
        Optional<Object> objectOptional = getAttrOptional(key);
        return objectOptional.getCastOrNull(Character.class);
    }

    @Override
    public Byte getAttrByte(String key) {
        Optional<Object> objectOptional = getAttrOptional(key);
        return objectOptional.getCastOrNull(Byte.class);
    }

    @Override
    public Short getAttrShort(String key) {
        Optional<Object> objectOptional = getAttrOptional(key);
        return objectOptional.getCastOrNull(Short.class);
    }

    @Override
    public Integer getAttrInteger(String key) {
        Optional<Object> objectOptional = getAttrOptional(key);
        return objectOptional.getCastOrNull(Integer.class);
    }

    @Override
    public Float getAttrFloat(String key) {
        Optional<Object> objectOptional = getAttrOptional(key);
        return objectOptional.getCastOrNull(Float.class);
    }

    @Override
    public Double getAttrDouble(String key) {
        Optional<Object> objectOptional = getAttrOptional(key);
        return objectOptional.getCastOrNull(Double.class);
    }

    @Override
    public Long getAttrLong(String key) {
        Optional<Object> objectOptional = getAttrOptional(key);
        return objectOptional.getCastOrNull(Long.class);
    }

}

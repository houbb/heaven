package com.github.houbb.heaven.support.cache.impl;

import com.github.houbb.heaven.support.cache.ICache;
import com.github.houbb.heaven.util.lang.reflect.ClassUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p> project: heaven-ClassFieldListCache </p>
 * <p> create on 2019/12/16 23:22 </p>
 *
 * @author Administrator
 * @since 0.1.61
 */
public class ClassFieldListCache implements ICache<Class, List<Field>> {

    private static final ClassFieldListCache INSTANCE = new ClassFieldListCache();

    private static final Map<Class, List<Field>> MAP = new ConcurrentHashMap<>();

    public static ClassFieldListCache getInstance(){
        return INSTANCE;
    }

    @Override
    public List<Field> get(Class key) {
        List<Field> fieldList = MAP.get(key);
        if(CollectionUtil.isNotEmpty(fieldList)) {
            return fieldList;
        }

        fieldList = ClassUtil.getAllFieldList(key);
        MAP.put(key, fieldList);
        return fieldList;
    }

    @Override
    public void set(Class key, List<Field> value) {
        MAP.put(key, value);
    }

}

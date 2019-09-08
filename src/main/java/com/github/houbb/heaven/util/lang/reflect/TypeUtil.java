package com.github.houbb.heaven.util.lang.reflect;

import com.github.houbb.heaven.response.exception.CommonRuntimeException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Type 工具类
 * @author binbin.hou
 * @since 0.1.26
 * @see ClassGenericUtil 泛型工具类
 * @see ClassUtil 类
 * @see ClassTypeUtil 类型工具类
 */
public final class TypeUtil {

    private TypeUtil(){}

    /**
     * 创建集合
     * @param type 类型
     * @return 集合
     * @since 0.1.26
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Collection createCollection(Type type) {
        return createCollection(type, 8);
    }

    /**
     * 创建集合
     * @param type 类型
     * @param size 集合大小
     * @return 集合
     * @since 0.1.26
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Collection createCollection(Type type,
                                              final int size) {
        Class<?> rawClass = getRawClass(type);
        Collection list;
        if(rawClass == AbstractCollection.class
                || rawClass == Collection.class){
            list = new ArrayList(size);
        } else if(rawClass.isAssignableFrom(HashSet.class)){
            list = new HashSet(size);
        } else if(rawClass.isAssignableFrom(LinkedHashSet.class)){
            list = new LinkedHashSet(size);
        } else if(rawClass.isAssignableFrom(TreeSet.class)){
            list = new TreeSet();
        } else if(rawClass.isAssignableFrom(ArrayList.class)){
            list = new ArrayList(size);
        } else if(rawClass.isAssignableFrom(EnumSet.class)){
            Type itemType = getGenericType(type);
            list = EnumSet.noneOf((Class<Enum>) itemType);
        } else if(rawClass.isAssignableFrom(Queue.class)){
            list = new LinkedList();
        } else{
            try{
                list = (Collection) rawClass.newInstance();
            } catch(Exception e){
                throw new CommonRuntimeException(e);
            }
        }
        return list;
    }

    /**
     * 获取对应的 raw 类型
     * @param type 类型
     * @return 结果
     * @since 0.1.26
     */
    private static Class<?> getRawClass(Type type){
        if(type instanceof Class<?>){
            return (Class<?>) type;
        } else if(type instanceof ParameterizedType){
            return getRawClass(((ParameterizedType) type).getRawType());
        } else{
            throw new UnsupportedOperationException();
        }
    }

    /**
     * 获取泛型类型
     * @param type 类型
     * @return 元素类型
     * @since 0.1.26
     */
    public static Class getGenericType(final Type type) {
        Type itemType;
        if(type instanceof ParameterizedType){
            itemType = ((ParameterizedType) type).getActualTypeArguments()[0];
        } else{
            itemType = Object.class;
        }

        return (Class) itemType;
    }

}

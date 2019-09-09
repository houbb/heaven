package com.github.houbb.heaven.util.lang.reflect;

import com.github.houbb.heaven.response.exception.CommonRuntimeException;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
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

    /**
     * 获取集合元素类型
     * @param collectionType 集合类型
     * @return 类型
     * @since 0.1.26
     */
    public static Type getCollectionItemType(Type collectionType) {
        if (collectionType instanceof ParameterizedType) {
            return getCollectionItemType((ParameterizedType) collectionType);
        }
        if (collectionType instanceof Class<?>) {
            return getCollectionItemType((Class<?>) collectionType);
        }
        return Object.class;
    }

    /**
     * 获取集合元素类型
     * @param clazz 类型
     * @return 结果
     * @since 0.1.26
     */
    private static Type getCollectionItemType(Class<?> clazz) {
        return clazz.getName().startsWith("java.")
                ? Object.class
                : getCollectionItemType(getCollectionSuperType(clazz));
    }

    private static Type getCollectionItemType(ParameterizedType parameterizedType) {
        Type rawType = parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (rawType == Collection.class) {
            return getWildcardTypeUpperBounds(actualTypeArguments[0]);
        }
        Class<?> rawClass = (Class<?>) rawType;
        Map<TypeVariable, Type> actualTypeMap = createActualTypeMap(rawClass.getTypeParameters(), actualTypeArguments);
        Type superType = getCollectionSuperType(rawClass);
        if (superType instanceof ParameterizedType) {
            Class<?> superClass = getRawClass(superType);
            Type[] superClassTypeParameters = ((ParameterizedType) superType).getActualTypeArguments();
            return superClassTypeParameters.length > 0
                    ? getCollectionItemType(makeParameterizedType(superClass, superClassTypeParameters, actualTypeMap))
                    : getCollectionItemType(superClass);
        }
        return getCollectionItemType((Class<?>) superType);
    }

    private static Type getWildcardTypeUpperBounds(Type type) {
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            Type[] upperBounds = wildcardType.getUpperBounds();
            return upperBounds.length > 0 ? upperBounds[0] : Object.class;
        }
        return type;
    }

    private static Map<TypeVariable, Type> createActualTypeMap(TypeVariable[] typeParameters, Type[] actualTypeArguments) {
        int length = typeParameters.length;
        Map<TypeVariable, Type> actualTypeMap = new HashMap<TypeVariable, Type>(length);
        for (int i = 0; i < length; i++) {
            actualTypeMap.put(typeParameters[i], actualTypeArguments[i]);
        }
        return actualTypeMap;
    }

    private static Type getCollectionSuperType(Class<?> clazz) {
        Type assignable = null;
        for (Type type : clazz.getGenericInterfaces()) {
            Class<?> rawClass = getRawClass(type);
            if (rawClass == Collection.class) {
                return type;
            }
            if (Collection.class.isAssignableFrom(rawClass)) {
                assignable = type;
            }
        }
        return assignable == null ? clazz.getGenericSuperclass() : assignable;
    }

    private static ParameterizedType makeParameterizedType(Class<?> rawClass, Type[] typeParameters, Map<TypeVariable, Type> actualTypeMap) {
        int length = typeParameters.length;
        Type[] actualTypeArguments = new Type[length];
        for (int i = 0; i < length; i++) {
            actualTypeArguments[i] = getActualType(typeParameters[i], actualTypeMap);
        }
        return new ParameterizedTypeImpl(actualTypeArguments, null, rawClass);
    }

    private static Type getActualType(Type typeParameter, Map<TypeVariable, Type> actualTypeMap) {
        if (typeParameter instanceof TypeVariable) {
            return actualTypeMap.get(typeParameter);
        } else if (typeParameter instanceof ParameterizedType) {
            return makeParameterizedType(getRawClass(typeParameter), ((ParameterizedType) typeParameter).getActualTypeArguments(), actualTypeMap);
        } else if (typeParameter instanceof GenericArrayType) {
            return new GenericArrayTypeImpl(getActualType(((GenericArrayType) typeParameter).getGenericComponentType(), actualTypeMap));
        }
        return typeParameter;
    }
}

## ReflectMethodUtil-反射方法工具类

反射方法工具类
[MethodHd](https://www.jianshu.com/p/c54503aabc60)

### ReflectMethodUtil-暂无说明

暂无说明

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### getIgnoreMethodList-获取忽略的方法列表

获取忽略的方法列表

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 忽略方法名称列表 | java.util.List |

### isIgnoreMethod-是否为应该忽略的方法名称

是否为应该忽略的方法名称

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| methodName | 方法名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否 | boolean |

### getParamTypeNames-获取方法类型的名称

获取方法类型的名称

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| method | 方法反射信息 | java.lang.reflect.Method |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 参数列表 | java.util.List |

### getParamNames-获取参数名称

获取参数名称

https://blog.csdn.net/revitalizing/article/details/71036970

（1）如果没有指定对应的注解信息，则直接返回 argIndex
比如：arg0 arg1

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| method | 方法信息 | java.lang.reflect.Method |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 方法名称列表 | java.util.List |

### getParamNames-获取参数名称列表

获取参数名称列表

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| parameterAnnotations | 参数注解 | 数组 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 名称列表 | java.util.List |

### getParamName-获取参数名称

获取参数名称

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| index | 参数的下标 | 整型 |
| annotations | 注解信息 | 数组 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 参数名称 | java.lang.String |

### getReturnGenericType-获取方法返回值的泛型

获取方法返回值的泛型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| method | 方法 | java.lang.reflect.Method |
| index | 泛型的下标 | 整型 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 返回类型的泛型 | java.lang.Class |

### getParamGenericType-获取参数的泛型

获取参数的泛型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| method | 方法 | java.lang.reflect.Method |
| paramIndex | 方法的下标 | 整型 |
| genericIndex | 泛型的下标 | 整型 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 对应的类型 | java.lang.Class |

### getMethodOptional-获取指定注解的方法

获取指定注解的方法

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| tClass | 类信息 | java.lang.Class |
| annotationClass | 注解信息 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 方法的 optional 信息 | com.github.houbb.heaven.util.util.Optional |

### invoke-执行反射调用

执行反射调用

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| instance | 对象实例，为空的时候针对 | java.lang.Object |
| method | 方法实例 | java.lang.reflect.Method |
| args | 参数信息 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 调用结果 | java.lang.Object |

### invoke-执行反射调用

执行反射调用

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| instance | 对象实例，为空的时候针对 | java.lang.Object |
| methodName | 方法名称 | 字符串 |
| args | 参数信息 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 调用结果 | java.lang.Object |

### invokeNoArgsMethod-直接执行调用无参方法

直接执行调用无参方法

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| instance | 实例对象 | java.lang.Object |
| method | 方法信息 | java.lang.reflect.Method |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.lang.Object |

### invokeNoArgsMethod-直接执行调用无参方法

直接执行调用无参方法

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| instance | 实例对象 | java.lang.Object |
| methodName | 方法名称信息 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.lang.Object |

### invokeFactoryMethod-直接执行调用无参方法

直接执行调用无参方法

限制如下：
（1）工厂方法必须为静态
（2）工厂方法必须无参
（3）工厂方法必须返回指定对象信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类信息 | java.lang.Class |
| factoryMethod | 工厂方法 | java.lang.reflect.Method |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 对象实例 | java.lang.Object |

### getGenericReturnParamType-获取泛型参数类型

获取泛型参数类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| method | 方法信息 | java.lang.reflect.Method |
| paramIndex | 参数下标 | 整型 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.lang.Class |

### invokeSetterMethod-调用 setter 方法，进行设置值

调用 setter 方法，进行设置值

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| instance | 实例信息 | java.lang.Object |
| propertyName | 属性名称 | 字符串 |
| value | 对象值 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### invokeGetterMethod-调用 getter 方法，获取属性值

调用 getter 方法，获取属性值

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| instance | 实例信息 | java.lang.Object |
| fieldName | 属性名称 | 字符串 |
| fieldType | 字段类型 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.lang.Object |

### invokeGetterMethod-调用 getter 方法，获取属性值

调用 getter 方法，获取属性值

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| instance | 实例信息 | java.lang.Object |
| fieldName | 属性名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.lang.Object |

### invokeGetterMethod-调用 getter 方法，获取属性值

调用 getter 方法，获取属性值

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| instance | 实例信息 | java.lang.Object |
| field | 字段类型 | java.lang.reflect.Field |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.lang.Object |

### buildSetMethodName-构建设置方法名称

构建设置方法名称

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| propertyName | 属性名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| set 方法名称 | java.lang.String |

### buildGetMethodName-构建设置方法名称

构建设置方法名称
（1）boolean 会变为 isXXX
（2）常规都是 getXXX

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| fieldType | 字段类型 | java.lang.Class |
| propertyName | 属性名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| set 方法名称 | java.lang.String |

### buildGetMethodName-构建设置方法名称

构建设置方法名称
1. 默认使用 getXXX

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| propertyName | 属性名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| set 方法名称 | java.lang.String |





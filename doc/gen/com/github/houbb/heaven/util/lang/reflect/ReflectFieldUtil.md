## ReflectFieldUtil-反射字段工具类

反射字段工具类

### ReflectFieldUtil-暂无说明

暂无说明

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### isAssignable-是否可以设置

是否可以设置

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| sourceField | 原始字段 | java.lang.reflect.Field |
| targetField | 目标字段 | java.lang.reflect.Field |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | boolean |

### isString-判断字段为字符串类型

判断字段为字符串类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| field | 字段 | java.lang.reflect.Field |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| {@code true} 是 | java.lang.Boolean |

### isNotString-判断字段是否不为字符串类型

判断字段是否不为字符串类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| field | 字段 | java.lang.reflect.Field |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| {@code true} 是 | java.lang.Boolean |

### isAnnotationPresent-判断字段field,声明了clazz注解

判断字段field,声明了clazz注解

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| field | 字段 | java.lang.reflect.Field |
| clazz | 注解 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否声明了 | boolean |

### isNotAnnotationPresent-判断字段field,未声明clazz注解

判断字段field,未声明clazz注解

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| field | 字段 | java.lang.reflect.Field |
| clazz | 注解 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否未声明 | boolean |

### getGenericParamType-获取字段的泛型参数类型

获取字段的泛型参数类型
[java通过反射获取List中的泛型](https://blog.csdn.net/yy19900811/article/details/24239945?utm_source=blogxgwz4)

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| field | 字段 | java.lang.reflect.Field |
| paramIndex | 泛型参数的下标 | 整型 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 泛型信息 | java.lang.Class |

### containsAnnotationField-当前类包含指定的注解信息

当前类包含指定的注解信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类 | java.lang.Class |
| annotationClass | 注解类 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否包含 | boolean |

### getComponentType-获取字段的类型

获取字段的类型
主要作用于集合类型
<pre>
String[] 返回 String
Collection&lt;String&gt; 返回 String
Map&lt;String, Integer&gt; 返回 0: String, 1: Integer
</pre>

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| field | 集合类型的字段 | java.lang.reflect.Field |
| typeIndex | 类型的下标 | 整型 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 对应的类型 | java.lang.Class |

### getComponentType-获取字段的类型

获取字段的类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| field | 集合类型的字段 | java.lang.reflect.Field |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 对应的类型 | java.lang.Class |

### setValue-设置字段的值

设置字段的值

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| field | 字段 | java.lang.reflect.Field |
| instance | 实例对象 | java.lang.Object |
| fieldValue | 值 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### setValue-设置字段值

设置字段值

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| instance | 实例 | java.lang.Object |
| fieldName | 字段名称 | 字符串 |
| fieldValue | 字段值 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### getValue-获取对应的值信息

获取对应的值信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| field | 字段 | java.lang.reflect.Field |
| instance | 实例 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 值 | java.lang.Object |

### getValue-获取对应的值信息

获取对应的值信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| fieldName | 字段名称 | 字符串 |
| instance | 实例 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 值 | java.lang.Object |

### getField-获取指定字段名称的字段信息

获取指定字段名称的字段信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| object | 对象实例 | java.lang.Object |
| fieldName | 字段名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 字段信息 | java.lang.reflect.Field |

### getField-获取指定字段名称的字段信息

获取指定字段名称的字段信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类名称 | java.lang.Class |
| fieldName | 字段名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 字段信息 | java.lang.reflect.Field |





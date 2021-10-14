## ClassTypeUtil-class 类型工具类

class 类型工具类

### ClassTypeUtil-暂无说明

暂无说明

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### isMap-是否为 map class 类型

是否为 map class 类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 对象类型 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否为 map class | boolean |

### isArray-是否为 数组 class 类型

是否为 数组 class 类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 对象类型 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否为 数组 class | boolean |

### isCollection-是否为 Collection class 类型

是否为 Collection class 类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 对象类型 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否为 Collection class | boolean |

### isIterable-是否为 Iterable class 类型

是否为 Iterable class 类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 对象类型 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否为 数组 class | boolean |

### isBase-是否为基本类型

是否为基本类型
1. 8大基本类型
2. 常见的值类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 对象类型 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否为基本类型 | boolean |

### isEnum-是否为枚举

是否为枚举

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类型 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 枚举 | boolean |

### isAbstract-是否为抽象类

是否为抽象类

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否为抽象类 | boolean |

### isAbstractOrInterface-是抽象类或者接口

是抽象类或者接口

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类信息 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否 | boolean |

### isJavaBean-是否为标准的类<br>

是否为标准的类<br>
这个类必须：

<pre>
0、不为 null
1、非接口
2、非抽象类
3、非Enum枚举
4、非数组
5、非注解
6、非原始类型（int, long等）
7、非集合 Iterable
8、非 Map.clas
9、非 JVM 生成类
</pre>

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否为标准类 | boolean |

### isJdk-判断一个类是JDK 自带的类型

判断一个类是JDK 自带的类型
jdk 自带的类，classLoader 是为空的。

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否为 java 类 | boolean |

### isBean-判断是否为Bean对象<br>

判断是否为Bean对象<br>
判定方法是是否存在只有一个参数的setXXX方法

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 待测试类 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否为Bean对象 | boolean |

### getListType-获取列表字段对应的类型

获取列表字段对应的类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| field | 字段 | java.lang.reflect.Field |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 返回对应的 class 类型 | java.lang.Class |

### isWildcardGenericType-是否为通配符泛型

是否为通配符泛型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| type | 类型 | java.lang.reflect.Type |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否 | boolean |

### isList-是否为列表

是否为列表

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类型 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | boolean |

### isSet-是否为 set

是否为 set

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类型 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | boolean |

### isPrimitive-是否为基本类型

是否为基本类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 对象类型 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否 | boolean |

### isPrimitive-是否为基本类型

是否为基本类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| object | 对象 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否 | boolean |





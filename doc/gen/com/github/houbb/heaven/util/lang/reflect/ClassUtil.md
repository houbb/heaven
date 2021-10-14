## ClassUtil-Class 工具类

Class 工具类

### ClassUtil-暂无说明

暂无说明

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### getClassVar-获取对应类的默认变量名：

获取对应类的默认变量名：
1. 首字母小写
String=》string

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| className | 类名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 类的默认变量名 | java.lang.String |

### getAllFieldList-获取类所有的字段信息

获取类所有的字段信息
ps: 这个方法有个问题 如果子类和父类有相同的字段 会不会重复
1. 还会获取到 serialVersionUID 这个字段。 0.1.77 移除

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 字段列表 | java.util.List |

### getModifyableFieldList-获取可变更的字段信息

获取可变更的字段信息
（1）过滤掉 final 的字段信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类信息 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 0.1.35 | java.util.List |

### getAllFieldMap-获取类所有的字段信息 map

获取类所有的字段信息 map
ps: 这个方法有个问题 如果子类和父类有相同的字段 会不会重复
1. 还会获取到 serialVersionUID 这个字段。

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 字段列表 map | java.util.Map |

### beanToMap-bean 转换为 map

bean 转换为 map

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| bean | 原始对象 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.util.Map |

### newInstance-获取对象的实例化

获取对象的实例化

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 实例化对象 | T |

### getAllFieldsReadMethods-获取所有字段的 read 方法列表

获取所有字段的 read 方法列表

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类信息 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 方法列表 | java.util.List |

### currentClassLoader-获取当前的 class loader

获取当前的 class loader

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 当前的 class loader | java.lang.ClassLoader |

### getClass-获取类信息

获取类信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| className | 类名称信息 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 构建后的类信息 | java.lang.Class |

### getMethod-获取方法信息

获取方法信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类信息 | java.lang.Class |
| methodName | 方法名称 | 字符串 |
| paramTypes | 参数类型 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 方法信息 | java.lang.reflect.Method |

### getMethod-获取方法信息

获取方法信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类信息 | java.lang.Class |
| methodName | 方法名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 方法信息 | java.lang.reflect.Method |

### getConstructor-获取构造器信息

获取构造器信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类 | java.lang.Class |
| paramTypes | 参数类型数组 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 构造器 | java.lang.reflect.Constructor |

### getMethodList-获取方法列表

获取方法列表
（1）当前类和超类的 public 方法

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| tClass | 类型 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果列表 | java.util.List |

### getDeclaredMethodList-获取方法列表

获取方法列表
（1）当前类的方法，包括私有。
（2）暂时不进行递归处理，后期看是否有需要。

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| tClass | 类型 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果列表 | java.util.List |

### getAllSuperClass-获取所有父类信息

获取所有父类信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类型 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 所有父类信息 | java.util.List |

### getAllInterfaces-获取所有接口信息

获取所有接口信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类型 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 所有父类信息 | java.util.List |

### getAllInterfacesAndSuperClass-获取所有接口信息和父类信息

获取所有接口信息和父类信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类型 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 接口信息和父类信息 | java.util.List |

### isAssignable-是否可以设置

是否可以设置

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| sourceType | 原始类型 | java.lang.Class |
| targetType | 目标类型 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | boolean |





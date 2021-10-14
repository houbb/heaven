## ReflectAnnotationUtil-反射注解工具类

反射注解工具类

### ReflectAnnotationUtil-暂无说明

暂无说明

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### updateValue-更新值信息

更新值信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotation | 注解 | java.lang.annotation.Annotation |
| method | 方法 | 字符串 |
| value | 属性值 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### getValue-获取值信息

获取值信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotation | 注解 | java.lang.annotation.Annotation |
| method | 方法 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 获取的属性值 | java.lang.Object |

### getValueStr-获取值信息-字符串形式

获取值信息-字符串形式

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotation | 注解 | java.lang.annotation.Annotation |
| method | 方法 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 对象值 String 形式 | java.lang.String |

### getAnnotationAttributes-获取对应的注解属性 map

获取对应的注解属性 map
https://segmentfault.com/a/1190000011213222?utm_source=tag-newest

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotation | 直接 | java.lang.annotation.Annotation |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| map | java.util.Map |

### getAnnotation-获取当前字段被指定注解标注的注解

获取当前字段被指定注解标注的注解

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotation | 注解 | java.lang.annotation.Annotation |
| annotationClass | 标注注解类型 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 注解信息 | com.github.houbb.heaven.util.util.Optional |

### getAnnotation-获取类指定的注解

获取类指定的注解

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类 | java.lang.Class |
| annotationClass | 指定注解类型 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | com.github.houbb.heaven.util.util.Optional |

### getAnnotationRefs-获取类对应的注解

获取类对应的注解
（1）直接对应的注解
（2）被指定注解类型标注的注解。

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类型 | java.lang.Class |
| annotationClass | 注解类 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果列表 | java.util.List |





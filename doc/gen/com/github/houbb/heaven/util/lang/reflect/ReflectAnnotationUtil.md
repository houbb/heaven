## ReflectAnnotationUtil-反射注解工具类

反射注解工具类

### ReflectAnnotationUtil-暂无说明

暂无说明

#### 方法入参

暂无入参

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### updateValue-更新值信息

更新值信息

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| annotation | 注解 | java.lang.annotation.Annotation |  |  |
| method | 方法 | 字符串 |  |  |
| value | 属性值 | java.lang.Object |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### getValue-获取值信息

获取值信息

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| annotation | 注解 | java.lang.annotation.Annotation |  |  |
| method | 方法 | 字符串 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### getValueStr-获取值信息-字符串形式

获取值信息-字符串形式

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| annotation | 注解 | java.lang.annotation.Annotation |  |  |
| method | 方法 | 字符串 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### getAnnotationAttributes-获取对应的注解属性 map

获取对应的注解属性 map
https://segmentfault.com/a/1190000011213222?utm_source=tag-newest

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| annotation | 直接 | java.lang.annotation.Annotation |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### getAnnotation-获取当前字段被指定注解标注的注解

获取当前字段被指定注解标注的注解

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| annotation | 注解 | java.lang.annotation.Annotation |  |  |
| annotationClass | 标注注解类型 | java.lang.Class |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

| 字段 | 说明 | 字段类型 | 备注 |
|:---|:---|:---|:---|
| EMPTY | Common instance for {@code empty()}. | com.github.houbb.heaven.util.util.Optional |   |
| value | If non-null, the value; if null, indicates no value is present | T |   |

##### 方法出参详情

暂无出参详情

### getAnnotation-获取类指定的注解

获取类指定的注解

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| clazz | 类 | java.lang.Class |  |  |
| annotationClass | 指定注解类型 | java.lang.Class |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

| 字段 | 说明 | 字段类型 | 备注 |
|:---|:---|:---|:---|
| EMPTY | Common instance for {@code empty()}. | com.github.houbb.heaven.util.util.Optional |   |
| value | If non-null, the value; if null, indicates no value is present | T |   |

##### 方法出参详情

暂无出参详情

### getAnnotationRefs-获取类对应的注解

获取类对应的注解
（1）直接对应的注解
（2）被指定注解类型标注的注解。

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| clazz | 类型 | java.lang.Class |  |  |
| annotationClass | 注解类 | java.lang.Class |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情





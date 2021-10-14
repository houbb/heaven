## AbstractAnnotationTypeMeta-抽象注解类型元数据

抽象注解类型元数据

<p> project: heaven-AnnotationMeta </p>
<p> create on 2019/11/29 23:04 </p>

### getAnnotations-获取对应的注解信息列表

获取对应的注解信息列表

（1）这里其实没有必要使用 {@link Map} 因为一般注解数量不会太多，只是数组性能反而更好。

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 注解数组 | java.lang.annotation.Annotation |

### AbstractAnnotationTypeMeta-暂无说明

暂无说明

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### isAnnotated-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotationName |  | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | boolean |

### getAnnotation-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotationName |  | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | java.lang.annotation.Annotation |

### isAnnotatedOrRef-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotationName |  | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | boolean |

### isAnnotatedOrRef-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| classList |  | 列表 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | boolean |

### isAnnotationRef-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz |  | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | boolean |

### getAnnotationOrRefs-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotationName |  | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | java.util.List |

### getAnnotationOpt-获取注解对应信息

获取注解对应信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotations | 注解数组 | 数组 |
| annotationName | 指定注解名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果信息 | com.github.houbb.heaven.util.util.Optional |

### getAnnotationOpt-获取注解对应信息

获取注解对应信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotations | 注解列表 | 列表 |
| annotationName | 指定注解名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果信息 | com.github.houbb.heaven.util.util.Optional |

### getAnnotationRefs-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotationName |  | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | java.util.List |

### getAnnotationReferenced-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotationName |  | 字符串 |
| annotationRefName |  | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | java.lang.annotation.Annotation |

### getAnnotationAttributes-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotationName |  | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | java.util.Map |

### getAnnotationOrRefAttributes-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotationName |  | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | java.util.Map |

### getAnnotationOrRefAttribute-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotationName |  | 字符串 |
| attrMethodName |  | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | java.lang.Object |

### getAnnotationAttr-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotation |  | java.lang.annotation.Annotation |
| methodName |  | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | java.lang.Object |

### getAnnotatedAttr-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz |  | java.lang.Class |
| methodName |  | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | java.lang.Object |

### getAnnotationReferencedAttr-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz |  | java.lang.Class |
| methodName |  | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | java.lang.Object |





## IAnnotationTypeMeta-注解元数据

注解元数据

<p> project: heaven-AnnotationMeta </p>
<p> create on 2019/11/29 23:04 </p>

### isAnnotated-Determine whether the underlying element has an annotation

Determine whether the underlying element has an annotation
of the given type defined.
<p>If this method returns {@code true}, then
{@link #getAnnotationAttributes} will return a non-null Map.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotationName | the | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| whether a matching annotation is defined | boolean |

### getAnnotation-Determine whether the underlying element has an annotation

Determine whether the underlying element has an annotation
of the given type defined.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotationName | the | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| a matching annotation is returned | java.lang.annotation.Annotation |

### isAnnotatedOrRef-Determine whether the underlying element has an annotation or meta-annotation

Determine whether the underlying element has an annotation or meta-annotation
of the given type defined.
<p>If this method returns {@code true}, then
{@link #getAnnotationAttributes} will return a non-null Map.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotationName | the | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| whether a matching annotation is defined | boolean |

### isAnnotatedOrRef-Determine whether the underlying element has an annotation or meta-annotation

Determine whether the underlying element has an annotation or meta-annotation
of the given type defined.
<p>If this method returns {@code true}, then
{@link #getAnnotationAttributes} will return a non-null Map.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| classList | the | 列表 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| whether a matching annotation is defined | boolean |

### isAnnotationRef-是否被引用了指定的注解

是否被引用了指定的注解

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类信息 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否 | boolean |

### getAnnotationOrRefs-Determine whether the underlying element has an annotation or meta-annotation

Determine whether the underlying element has an annotation or meta-annotation
of the given type defined.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotationName | the | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| all matching annotation is returned | java.util.List |

### getAnnotationRefs-获取指定类型的所有相关注解

获取指定类型的所有相关注解
（1）排除直接注解本身

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotationName | 注解名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 注解类表 | java.util.List |

### getAnnotationReferenced-获取被引用的注解基本信息

获取被引用的注解基本信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotationName | 注解名称 | 字符串 |
| annotationRefName | 引用注解名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 被引用的注解本身 | java.lang.annotation.Annotation |

### getAnnotationAttributes-Retrieve the attributes of the annotation of the given type, if any (i.e. if

Retrieve the attributes of the annotation of the given type, if any (i.e. if
defined on the underlying element, as direct annotation),
also taking attribute overrides on composed annotations into account.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotationName | the | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| a Map of attributes, with the attribute name as key (e.g. "value")
and the defined attribute value as Map value. This return value will be
{@code null} if no matching annotation is defined. | java.util.Map |

### getAnnotationOrRefAttributes-Retrieve the attributes of the annotation of the given type, if any (i.e. if

Retrieve the attributes of the annotation of the given type, if any (i.e. if
defined on the underlying element, as direct annotation or meta-annotation),
also taking attribute overrides on composed annotations into account.

备注：当有多个时，则只会选择一个。

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotationName | the | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| a Map of attributes, with the attribute name as key (e.g. "value")
and the defined attribute value as Map value. This return value will be
{@code null} if no matching annotation is defined. | java.util.Map |

### getAnnotationOrRefAttribute-Retrieve the attributes of the annotation of the given type, if any (i.e. if

Retrieve the attributes of the annotation of the given type, if any (i.e. if
defined on the underlying element, as direct annotation or meta-annotation),
also taking attribute overrides on composed annotations into account.

备注：当有多个时，则只会选择一个。

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotationName | the | 字符串 |
| attrMethodName | the | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| a Map of attributes, with the attribute name as key (e.g. "value")
and the defined attribute value as Map value. This return value will be
{@code null} if no matching annotation is defined. | java.lang.Object |

### getAnnotationAttr-获取当前注解对应的属性信息

获取当前注解对应的属性信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| annotation | 注解类 | java.lang.annotation.Annotation |
| methodName | 方法名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.lang.Object |

### getAnnotatedAttr-获取被当前注解指定的属性信息

获取被当前注解指定的属性信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 注解类 | java.lang.Class |
| methodName | 方法名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.lang.Object |

### getAnnotationReferencedAttr-获取被当前注解为元注解的的属性信息

获取被当前注解为元注解的的属性信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 注解类 | java.lang.Class |
| methodName | 方法名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.lang.Object |





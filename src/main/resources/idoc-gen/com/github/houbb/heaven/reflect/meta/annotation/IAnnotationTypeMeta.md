## IAnnotationTypeMeta-<p> project: heaven-AnnotationMeta </p>

<p> project: heaven-AnnotationMeta </p>
<p> create on 2019/11/29 23:04 </p>

### isAnnotated-Determine whether the underlying element has an annotation

Determine whether the underlying element has an annotation
of the given type defined.
<p>If this method returns {@code true}, then
{@link #getAnnotationAttributes} will return a non-null Map.

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| annotationName | the | 字符串 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### getAnnotation-Determine whether the underlying element has an annotation

Determine whether the underlying element has an annotation
of the given type defined.

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| annotationName | the | 字符串 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### isAnnotatedOrRef-Determine whether the underlying element has an annotation or meta-annotation

Determine whether the underlying element has an annotation or meta-annotation
of the given type defined.
<p>If this method returns {@code true}, then
{@link #getAnnotationAttributes} will return a non-null Map.

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| annotationName | the | 字符串 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### isAnnotatedOrRef-Determine whether the underlying element has an annotation or meta-annotation

Determine whether the underlying element has an annotation or meta-annotation
of the given type defined.
<p>If this method returns {@code true}, then
{@link #getAnnotationAttributes} will return a non-null Map.

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| classList | the | 列表 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### isAnnotationRef-是否被引用了指定的注解

是否被引用了指定的注解

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| clazz | 类信息 | java.lang.Class |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### getAnnotationOrRefs-Determine whether the underlying element has an annotation or meta-annotation

Determine whether the underlying element has an annotation or meta-annotation
of the given type defined.

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| annotationName | the | 字符串 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### getAnnotationRefs-获取指定类型的所有相关注解

获取指定类型的所有相关注解
（1）排除直接注解本身

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| annotationName | 注解名称 | 字符串 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### getAnnotationReferenced-获取被引用的注解基本信息

获取被引用的注解基本信息

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| annotationName | 注解名称 | 字符串 |  |  |
| annotationRefName | 引用注解名称 | 字符串 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### getAnnotationAttributes-Retrieve the attributes of the annotation of the given type, if any (i.e. if

Retrieve the attributes of the annotation of the given type, if any (i.e. if
defined on the underlying element, as direct annotation),
also taking attribute overrides on composed annotations into account.

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| annotationName | the | 字符串 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### getAnnotationOrRefAttributes-Retrieve the attributes of the annotation of the given type, if any (i.e. if

Retrieve the attributes of the annotation of the given type, if any (i.e. if
defined on the underlying element, as direct annotation or meta-annotation),
also taking attribute overrides on composed annotations into account.

备注：当有多个时，则只会选择一个。

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| annotationName | the | 字符串 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### getAnnotationOrRefAttribute-Retrieve the attributes of the annotation of the given type, if any (i.e. if

Retrieve the attributes of the annotation of the given type, if any (i.e. if
defined on the underlying element, as direct annotation or meta-annotation),
also taking attribute overrides on composed annotations into account.

备注：当有多个时，则只会选择一个。

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| annotationName | the | 字符串 |  |  |
| attrMethodName | the | 字符串 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### getAnnotationAttr-获取当前注解对应的属性信息

获取当前注解对应的属性信息

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| annotation | 注解类 | java.lang.annotation.Annotation |  |  |
| methodName | 方法名称 | 字符串 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### getAnnotatedAttr-获取被当前注解指定的属性信息

获取被当前注解指定的属性信息

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| clazz | 注解类 | java.lang.Class |  |  |
| methodName | 方法名称 | 字符串 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### getAnnotationReferencedAttr-获取被当前注解为元注解的的属性信息

获取被当前注解为元注解的的属性信息

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| clazz | 注解类 | java.lang.Class |  |  |
| methodName | 方法名称 | 字符串 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情





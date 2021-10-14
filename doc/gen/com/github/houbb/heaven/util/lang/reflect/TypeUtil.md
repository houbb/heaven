## TypeUtil-Type 工具类

Type 工具类

### TypeUtil-暂无说明

暂无说明

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### createCollection-创建集合

创建集合

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| type | 类型 | java.lang.reflect.Type |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 集合 | java.util.Collection |

### createMap-创建一个 map

创建一个 map

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| type | 类型 | java.lang.reflect.Type |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.util.Map |

### getMapKeyValueType-根据 map 的类型，获取对应的 key/value 类型

根据 map 的类型，获取对应的 key/value 类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| mapType | map | java.lang.reflect.Type |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | com.github.houbb.heaven.support.tuple.impl.Pair |

### createCollection-创建集合

创建集合

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| type | 类型 | java.lang.reflect.Type |
| size | 集合大小 | 整型 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 集合 | java.util.Collection |

### getRawClass-获取对应的 raw 类型

获取对应的 raw 类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| type | 类型 | java.lang.reflect.Type |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.lang.Class |

### getGenericType-获取泛型类型

获取泛型类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| type | 类型 | java.lang.reflect.Type |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 元素类型 | java.lang.Class |

### getCollectionItemType-获取集合元素类型

获取集合元素类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| collectionType | 集合类型 | java.lang.reflect.Type |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 类型 | java.lang.reflect.Type |

### getCollectionItemType-获取集合元素类型

获取集合元素类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类型 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.lang.reflect.Type |

### getCollectionItemType-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| parameterizedType |  | java.lang.reflect.ParameterizedType |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | java.lang.reflect.Type |

### getWildcardTypeUpperBounds-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| type |  | java.lang.reflect.Type |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | java.lang.reflect.Type |

### createActualTypeMap-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| typeParameters |  | 数组 |
| actualTypeArguments |  | 数组 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | java.util.Map |

### getCollectionSuperType-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz |  | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | java.lang.reflect.Type |

### makeParameterizedType-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| rawClass |  | java.lang.Class |
| typeParameters |  | 数组 |
| actualTypeMap |  | 映射 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | java.lang.reflect.ParameterizedType |

### getActualType-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| typeParameter |  | java.lang.reflect.Type |
| actualTypeMap |  | 映射 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | java.lang.reflect.Type |

### getGenericParamType-获取泛型参数类型

获取泛型参数类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| genericType | 类型 | java.lang.reflect.Type |
| paramIndex | 泛型参数下标 | 整型 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.lang.Class |

### getGenericParamType-获取泛型参数类型

获取泛型参数类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| genericType | 类型 | java.lang.reflect.Type |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.lang.Class |

### cast-转换为指定的数据类型

转换为指定的数据类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| obj | 原始数据 | java.lang.Object |
| type | 预期类型 | java.lang.reflect.Type |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | T |

### cast-类型转换

类型转换

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| obj | 原始结果 | java.lang.Object |
| type | 类型 | java.lang.reflect.ParameterizedType |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 转换后的结果 | T |





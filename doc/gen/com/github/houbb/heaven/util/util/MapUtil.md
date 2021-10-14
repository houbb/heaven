## MapUtil-Map 工具类

Map 工具类

### MapUtil-暂无说明

暂无说明

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### isEmpty-判断map为空

判断map为空

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| map | map | 映射 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| {@code true} 为空 | boolean |

### isNotEmpty-判断map为非空

判断map为非空

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| map | map | 映射 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| {@code true} 非空 | boolean |

### toMap-可遍历的结合转换为 map

可遍历的结合转换为 map

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| values | 可遍历的元素 | 集合 |
| keyFunction | 转化方式 | com.github.houbb.heaven.support.handler.IHandler |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| map 结果 | java.util.Map |

### toMap-可遍历的结合转换为 map

可遍历的结合转换为 map

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| values | 可遍历的元素 | 集合 |
| mapHandler | map | com.github.houbb.heaven.support.handler.IMapHandler |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| map 结果 | java.util.Map |

### toList-可遍历的结合转换为 map

可遍历的结合转换为 map

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| map | 可遍历的元素 | 映射 |
| entryHandler | entry | com.github.houbb.heaven.support.handler.IMapEntryHandler |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| list 结果 | java.util.List |

### toIndexMap-key 是元素的索引

key 是元素的索引

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| values | 值 | 集合 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 map | java.util.Map |

### getMapValue-获取对应的映射信息

获取对应的映射信息
（1）如果对应的值不存在，则返回 key 本身
（2）如果 map 为空，则返回

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| map | map | 映射 |
| key | key | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| value | java.lang.String |

### getMapValue-获取对应的映射信息

获取对应的映射信息
1. 不存在则返回默认值

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| map | map | 映射 |
| key | key | K |
| defaultValue | 默认值 | V |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| value | V |

### getFirstEntry-获取 map 的第一个值

获取 map 的第一个值

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| map | map | 映射 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.util.Map$Entry |





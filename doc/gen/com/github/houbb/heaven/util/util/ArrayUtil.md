## ArrayUtil-数组工具类

数组工具类

### ArrayUtil-暂无说明

暂无说明

#### 方法入参

暂无入参

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### isEmpty-数组是否为空

数组是否为空

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| objects | 数组对象 | 数组 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### isNotEmpty-数组是否不为空

数组是否不为空

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| objects | 数组对象 | 数组 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### toList-数组转换为列表

数组转换为列表

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| objects | 数组 | 数组 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### toArray-转换为数组

转换为数组

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| objectList | 集合 | 列表 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### toArray-数组转换为数组

数组转换为数组
（1）通过一层转换

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| values | 集合 | 数组 |  |  |
| keyFunction | 处理函数 | com.github.houbb.heaven.support.handler.IHandler |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### union-数组的并集

数组的并集

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| values | 集合 | 数组 |  |  |
| others | 其他数组信息 | K |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### contains-是否包含数据

是否包含数据

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| array | 数组信息 | 数组 |  |  |
| objectToFind | 待发现的对象 | java.lang.Object |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### notContains-是否不包含数据

是否不包含数据

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| array | 数组信息 | 数组 |  |  |
| objectToFind | 待发现的对象 | java.lang.Object |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### indexOf-查询对应元素的下标

查询对应元素的下标

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| array | 数组信息 | 数组 |  |  |
| objectToFind | 待发现的对象 | java.lang.Object |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### indexOf-查询对应元素的下标

查询对应元素的下标

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| array | 数组信息 | 数组 |  |  |
| objectToFind | 待发现的对象 | java.lang.Object |  |  |
| startIndex | 开始下标 | 整型 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### listToArray-列表转数组

列表转数组

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| list | 列表 | 列表 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### arrayToList-数组转列表

数组转列表
（1）如果为空，则直接转为空。

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| array | 数组 | E |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### getStartIndex-获取开始的下标

获取开始的下标
（1）默认为0
（2）如果为负数，或者超过 arrays.length-1，则使用 0
（3）正常返回 startIndex

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| startIndex | 开始下标 | 整型 |  |  |
| arrays | 数组信息 | 数组 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### getEndIndex-获取开始的下标

获取开始的下标
（1）默认为0
（2）如果为负数，或者超过 arrays.length-1，则使用 arrays.length-1
（3）正常返回 endIndex

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| endIndex | 结束下标 | 整型 |  |  |
| arrays | 数组信息 | 数组 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### firstNotNullElem-找到第一个不为 null 的元素

找到第一个不为 null 的元素

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| objects | 对象 | 数组 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

| 字段 | 说明 | 字段类型 | 备注 |
|:---|:---|:---|:---|
| EMPTY | Common instance for {@code empty()}. | com.github.houbb.heaven.util.util.Optional |   |
| value | If non-null, the value; if null, indicates no value is present | T |   |

##### 方法出参详情

暂无出参详情

### newArray-返回数组信息

返回数组信息

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| objects | 数组 | java.lang.Object |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### toList-可遍历的元素对象的某个元素，转换为列表

可遍历的元素对象的某个元素，转换为列表

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| values | 遍历对象数组 | 数组 |  |  |
| keyFunction | 转换方式 | com.github.houbb.heaven.support.handler.IHandler |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### toList-long 可遍历的元素对象的某个元素，转换为列表

long 可遍历的元素对象的某个元素，转换为列表

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| arrayObject | 数组对象 | java.lang.Object |  |  |
| keyFunction | 转换方式 | com.github.houbb.heaven.support.handler.IHandler |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### shift-执行平移操作

执行平移操作
1. 数组判断空。如果为空，直接返回空
2. 添加偏移量的 mod

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| array | 原始数组 | 数组 |  |  |
| offset | 偏移量 | 整型 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情




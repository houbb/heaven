## Pipeline-管道类

管道类
1. 作用：用于列表信息的统一管理

### addLast-加入到列表的末尾

加入到列表的末尾

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| t | 元素 | T |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| this | com.github.houbb.heaven.support.pipeline.Pipeline |

### addFirst-加入到列表的开头

加入到列表的开头

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| t | 元素 | T |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| this | com.github.houbb.heaven.support.pipeline.Pipeline |

### set-设置元素 index 位置为 t

设置元素 index 位置为 t

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| index | 下标志 | 整型 |
| t | 元素 | T |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| this | com.github.houbb.heaven.support.pipeline.Pipeline |

### removeLast-移除最后一个元素

移除最后一个元素

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| this | com.github.houbb.heaven.support.pipeline.Pipeline |

### removeFirst-移除第一个元素

移除第一个元素

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| this | com.github.houbb.heaven.support.pipeline.Pipeline |

### remove-移除 index 位置的元素

移除 index 位置的元素

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| index | 下标值 | 整型 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| this | com.github.houbb.heaven.support.pipeline.Pipeline |

### get-获取指定位置的元素

获取指定位置的元素

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| index | 下标 | 整型 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 元素 | T |

### getFirst-获取第一个位置的元素

获取第一个位置的元素

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 元素 | T |

### getLast-获取最后一个位置的元素

获取最后一个位置的元素

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 元素 | T |

### list-获取所有的元素列表

获取所有的元素列表

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 所有的元素列表 | java.util.List |

### slice-进行 slice 分片返回一个从 startIndex~endIndex 的新列表

进行 slice 分片返回一个从 startIndex~endIndex 的新列表
1. 如果超过数组下标则直接报错

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| startIndex | 开始下标 | 整型 |
| endIndex | 结束下标 | 整型 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 截取后的元素列表 | java.util.List |





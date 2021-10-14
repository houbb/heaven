## SnowFlakeId- 雪花算法  19 位 

<p> 雪花算法  19 位 </p>

<pre> Created: 2018/6/15 上午11:41  </pre>
<pre> Project: heaven  </pre>
[理解分布式id生成算法SnowFlake](https://segmentfault.com/a/1190000011282426?utm_source=tag-newest)

### SnowFlakeId-暂无说明

暂无说明

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### SnowFlakeId-暂无说明



#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| workerId | 工作机器ID | 长整型 |
| datacenterId | 序列号 | 长整型 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### getMaxWorkerId-获取 maxWorkerId

获取 maxWorkerId

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| datacenterId | 客户端编号 | 长整型 |
| maxWorkerId | 机器标识 | 长整型 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 最大机器标识 | long |

### getDatacenterId-数据标识id部分

数据标识id部分

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| maxDatacenterId | 最大标识 | 长整型 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 最大标识 | long |

### nextId-获取下一个ID

获取下一个ID

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| next id | long |

### tilNextMillis-等待直到下一个毫秒

等待直到下一个毫秒

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| lastTimestamp | 等待直到下一个毫秒 | 长整型 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 等待直到下一个毫秒 | long |

### timeGen-生成时间

生成时间

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 时间 | long |

### genId-暂无说明

暂无说明

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | java.lang.String |





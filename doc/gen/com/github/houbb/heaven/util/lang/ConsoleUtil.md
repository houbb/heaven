## ConsoleUtil-日志工具类

日志工具类

### ConsoleUtil-暂无说明

暂无说明

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### info-输出文档

输出文档

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| className | 类名 | 字符串 |
| methodName | 方法名 | 字符串 |
| format | 文本格式化 | 字符串 |
| args | 参数 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### info-输出文档

输出文档

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| format | 文本格式化 | 字符串 |
| args | 参数 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### buildString-格式化信息

格式化信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| format | 格式化 | 字符串 |
| params | 参数 | 数组 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.lang.String |

### log-消息打印

消息打印

final String threadName = Thread.currentThread().getName();

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| level | 消息等级 | 字符串 |
| className |  | 字符串 |
| methodName |  | 字符串 |
| content | 内容 | 字符串 |
| throwable | 异常 | java.lang.Throwable |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### buildPrettyMethodName-构建更加优雅的方法名称

构建更加优雅的方法名称
（1）className 只取首字母

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| className | 类名 | 字符串 |
| methodName | 方法名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.lang.String |





## ExceptionUtil-异常工具类

异常工具类

### ExceptionUtil-暂无说明

暂无说明

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### unwrapThrowable-解包异常

解包异常

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| wrapped | 异常 | java.lang.Throwable |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 被解包的异常 | java.lang.Throwable |

### throwUnsupportedOperationException-抛出运行时不支持的操作异常

抛出运行时不支持的操作异常

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### unchecked-将CheckedException转换为UncheckedException.

将CheckedException转换为UncheckedException.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| ex | ex | java.lang.Throwable |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 运行时异常 | java.lang.RuntimeException |

### getStackTraceAsString-将ErrorStack转化为String.

将ErrorStack转化为String.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| ex | 异常 | java.lang.Throwable |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 返回异常内容 | java.lang.String |

### getErrorMessageWithNestedException-获取组合本异常信息与底层异常信息的异常描述, 适用于本异常为统一包装异常类，底层异常才是根本原因的情况。

获取组合本异常信息与底层异常信息的异常描述, 适用于本异常为统一包装异常类，底层异常才是根本原因的情况。

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| ex | 异常 | java.lang.Throwable |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 异常信息 | java.lang.String |

### getRootCause-获取异常的Root Cause.

获取异常的Root Cause.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| ex | 异常 | java.lang.Throwable |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 异常的 RootCause. | java.lang.Throwable |

### isCausedBy-判断异常是否由某些底层的异常引起.

判断异常是否由某些底层的异常引起.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| ex | 异常 | java.lang.Exception |
| causeExceptionClasses | 导致的异常原因 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| {@code true} 是否由某个异常引起 | boolean |

### getActualThrowable-获取确切的异常信息

获取确切的异常信息
1. 主要针对代理报错

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| throwable | 异常 | java.lang.Throwable |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 确切的异常信息 | java.lang.Throwable |





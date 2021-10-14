## FieldMetas-字段元数据工具类

字段元数据工具类
<p> project: FieldMeta </p>
<p> create on 2019/11/9 23:08 </p>

### FieldMetas-暂无说明

暂无说明

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### buildFieldsMetaList-构建字段元数据列表

构建字段元数据列表

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类信息 | java.lang.Class |
| instance | 实例对象 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果列表 | java.util.List |

### buildFieldsMetaList-构建字段元数据列表

构建字段元数据列表

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类信息 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果列表 | java.util.List |

### buildFieldsMetaList-构建字段元数据列表

构建字段元数据列表

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| fieldList | 字段列表 | 列表 |
| instance | 实例信息 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果列表 | java.util.List |

### buildReadMethodsMetaList-构建读取方法元数据列表

构建读取方法元数据列表

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类信息 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果列表 | java.util.List |

### buildReadMethodsMetaList-构建读取方法元数据列表

构建读取方法元数据列表
<p>
（1）只处理 get 开头的方法
（2）只处理无参方法
（3）排除 getClass 方法
（4）如果是 boolean 类型，则读取 isXXX 方法

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类信息 | java.lang.Class |
| instance | 实例对象 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果列表 | java.util.List |

### buildWriteMethodsMetaList-构建写入方法元数据列表

构建写入方法元数据列表
<p>
（1）只处理 set 开头的方法
（2）只处理无参方法

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类信息 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果列表 | java.util.List |

### buildWriteMethodsMetaList-构建写入方法元数据列表

构建写入方法元数据列表
<p>
（1）只处理 set 开头的方法
（2）只处理当个参数方法

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类信息 | java.lang.Class |
| instance | 实例对象 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果列表 | java.util.List |

### buildMethodsMetaList-构建字段元数据列表

构建字段元数据列表
（1）只处理 get 开头的方法
（2）只处理无参方法
（3）排除 getClass 方法
（4）如果是 boolean 类型，则读取 isXXX 方法

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| methodList | 方法列表 | 列表 |
| instance | 实例信息 | java.lang.Object |
| methodCondition | 方法满足的条件 | com.github.houbb.heaven.support.condition.ICondition |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果列表 | java.util.List |





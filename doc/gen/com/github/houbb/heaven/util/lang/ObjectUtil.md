## ObjectUtil-Object 工具类

Object 工具类

### ObjectUtil-暂无说明

暂无说明

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### isSameType-判断两个对象是否为同一对象

判断两个对象是否为同一对象
instanceof
isInstance
isAssignableFrom

注意：任何一个元素为 null，则认为是不同类型。

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| one | 第一个元素 | java.lang.Object |
| two | 第二个元素 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否为同一对象 | boolean |

### isNotSameType-不是同一个类型

不是同一个类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| one | 第一个元素 | java.lang.Object |
| two | 第二个元素 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否为不同对象 | boolean |

### isNull-判断当前对象是否为空

判断当前对象是否为空
- 对象为空
- 空字符串
- 空集合/map
- 空数组
- 自定义空类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| object | 对象 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否为空 | boolean |

### isNotNull-判断对象是否非null

判断对象是否非null

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| object | 元素 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| {@code true} 非空 | boolean |

### isEmpty-判断内容是否为空

判断内容是否为空
- 空字符串
- 空集合/map
- 空数组
- 自定义空类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| object | 对象 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否为空 | boolean |

### isNotEmpty-判断对象是否非空

判断对象是否非空

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| object | 对象 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否非空 | boolean |

### isEquals-判断两个对象是否相同

判断两个对象是否相同
1.如果不是同一种类型,则直接返回false

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| except | 期望值 | java.lang.Object |
| real | 实际值 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 两个对象是否相同 | boolean |

### isNotEquals-判断两个对象是否不相同

判断两个对象是否不相同
1.如果不是同一种类型,则返回true

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| except | 期望值 | java.lang.Object |
| real | 实际值 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 两个对象是否不同 | boolean |

### objectToString-对象转字符串

对象转字符串

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| object | 对象 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.lang.String |

### objectToString-对象转字符串

对象转字符串

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| object | 对象 | java.lang.Object |
| defaultValue | 默认值，原始对象为 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.lang.String |

### isNull-判断所有参数皆为null

判断所有参数皆为null

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| object | 对象 | java.lang.Object |
| others | 其他参数 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否都为空 | boolean |

### isEqualsOrNull-判断两个元素是否相等或者都为 Null

判断两个元素是否相等或者都为 Null

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| left | 元素1 | java.lang.Object |
| right | 元素2 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否相等或者都为 Null | boolean |

### toList-可遍历的元素对象的某个元素，转换为列表

可遍历的元素对象的某个元素，转换为列表

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| object | 可遍历对象 | java.lang.Object |
| handler | 转换方式 | com.github.houbb.heaven.support.handler.IHandler |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果列表 | java.util.List |

### getClass-获取实体对象对应的 class 信息

获取实体对象对应的 class 信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| object | 实例对象 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 对象 class 信息 | java.lang.Class |

### emptyToNull-empty 转换为 null

empty 转换为 null

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| object | 对象 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |





## RandomUtil-随机工具类

随机工具类

### RandomUtil-暂无说明

暂无说明

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### getRandom-获取随机数生成器对象<br>

获取随机数生成器对象<br>
ThreadLocalRandom是JDK 7之后提供并发产生随机数，能够解决多个线程发生的竞争争夺。

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| {@link ThreadLocalRandom} | java.util.concurrent.ThreadLocalRandom |

### getSecureRandom-获取{@link SecureRandom}，类提供加密的强随机数生成器 (RNG)

获取{@link SecureRandom}，类提供加密的强随机数生成器 (RNG)

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| {@link SecureRandom} | java.security.SecureRandom |

### getRandom-获取随机数产生器

获取随机数产生器

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| isSecure | 是否为强随机数生成器 | 布尔值 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| {@link Random} | java.util.Random |

### randomChar-随机的字符

随机的字符

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| length | 长度 | 整型 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 随机的数字 | java.lang.String |

### randomCharNumber-随机的字符数字

随机的字符数字

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| length | 长度 | 整型 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 随机的数字 | java.lang.String |

### randomNumber-随机的数字

随机的数字

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| length | 长度 | 整型 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 随机的数字 | java.lang.String |

### randomString-获得一个随机的字符串

获得一个随机的字符串

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| baseString | 随机字符选取的样本 | 字符串 |
| length | 字符串的长度 | 整型 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 随机字符串 | java.lang.String |

### random-随机选择列表中的一个元素

随机选择列表中的一个元素

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| list | 列表 | 列表 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | T |





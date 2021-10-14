## StreamUtil-流工具类

流工具类

### StreamUtil-暂无说明

暂无说明

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### toString-流转换为字符

流转换为字符

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| is | 流。注意：这里并不会关闭输入流，需要外部自行处理。 | java.io.InputStream |
| charset | 编码集合 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 字符串 | java.lang.String |

### toString-流转换为字符

流转换为字符

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| is | 流。注意：这里并不会关闭输入流，需要外部自行处理。 | java.io.InputStream |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 字符串 | java.lang.String |

### getFileContent-获取文章内容

获取文章内容

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| path | 路径 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 文件内容 | java.lang.String |

### getFileContent-获取文章内容

获取文章内容

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| path | 路径 | 字符串 |
| charset | 字符集合 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 文件内容 | java.lang.String |

### getFileBytes-获取文件字节流

获取文件字节流

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| filePath | 文件路径 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 字节流 | byte |

### getInputStream-获取文件对应输入流

获取文件对应输入流

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| filePath | 文件路径 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 输入流 | java.io.InputStream |

### closeStream-关闭流

关闭流

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| closeable | 可关闭的信息 | java.io.Closeable |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### readAllLines-获取数据内容

获取数据内容
例如： /data.txt

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| path | resource | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 返回数据集合 | java.util.List |

### readAllLines-构建数据集合

构建数据集合

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| is | 文件输入流 | java.io.InputStream |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 返回数据集合 | java.util.List |

### readAllLines-构建数据集合

构建数据集合

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| is | 文件输入流 | java.io.InputStream |
| charset | 文件编码 | 字符串 |
| ignoreEmpty | 是否忽略空白行 | 布尔值 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 返回数据集合 | java.util.List |

### getFileContent-获取文件内容

获取文件内容

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| path | 路径 | 字符串 |
| startIndex | 开始下标 | 整型 |
| endIndex | 结束下标 | 整型 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.lang.String |

### getFileContent-获取文件内容

获取文件内容

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| path | 路径 | 字符串 |
| startIndex | 开始下标 | 整型 |
| endIndex | 结束下标 | 整型 |
| charset | 编码 | java.nio.charset.Charset |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.lang.String |

### inputStreamToFile-文件输入流转 file

文件输入流转 file
https://www.cnblogs.com/asfeixue/p/9065681.html

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| inputStream | 输入流 | java.io.InputStream |
| deleteOnExit | 退出时删除 | 布尔值 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 文件信息 | java.io.File |

### inputStreamToFile-文件输入流转 file

文件输入流转 file
https://www.cnblogs.com/asfeixue/p/9065681.html

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| inputStream | 输入流 | java.io.InputStream |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 文件信息 | java.io.File |

### inputStreamToBytes-输入流转为字节流

输入流转为字节流

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| inputStream | 输入流 | java.io.InputStream |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 字节数组 | byte |

### inputStreamToString-输入流转为字符串

输入流转为字符串

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| inputStream | 输入流 | java.io.InputStream |
| charsetStr | 字符编码 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 字节数组 | java.lang.String |

### inputStreamToString-输入流转为字符串

输入流转为字符串

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| inputStream | 输入流 | java.io.InputStream |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 字节数组 | java.lang.String |

### readToMap-将文件内容转换为 map

将文件内容转换为 map

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| path | 文件路径 | 字符串 |
| charset | 文件编码 | 字符串 |
| mapHandler | 转换实现 | com.github.houbb.heaven.support.handler.IMapHandler |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.util.Map |

### readToMap-将文件内容转换为 map

将文件内容转换为 map

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| path | 文件路径 | 字符串 |
| mapHandler | 转换实现 | com.github.houbb.heaven.support.handler.IMapHandler |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.util.Map |

### readToMap-将文件内容转换为 map

将文件内容转换为 map

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| path | 文件路径 | 字符串 |
| splliter | 拆分符号 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.util.Map |

### write-Writes the set of service class names to a service file.

Writes the set of service class names to a service file.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| lines | a | 集合 |
| output | not | java.io.OutputStream |
| charset | 文件编码 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### write-Writes the set of service class names to a service file.

Writes the set of service class names to a service file.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| lines | a | 集合 |
| output | not | java.io.OutputStream |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |





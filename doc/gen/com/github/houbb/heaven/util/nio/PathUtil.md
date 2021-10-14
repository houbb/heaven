## PathUtil-路径工具类

路径工具类

### PathUtil-暂无说明

暂无说明

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### getRelativePath-获取 path 相对于 parentPath 剩余的路径

获取 path 相对于 parentPath 剩余的路径
和 {@link Path#relativize(Path)} 不同，这个结果更加直观。不过性能一般。

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| parentPath | 父类路径 | java.nio.file.Path |
| path | 原始路径 | java.nio.file.Path |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 相对结果路径 | java.lang.String |

### getPublicParentPath-获取共有的路径

获取共有的路径

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| pathList | 路径列表 | 列表 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.nio.file.Path |

### getMaxLength-获取最长的字符串

获取最长的字符串

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| stringList | 字符串列表 | 列表 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 最长的结果 | java.lang.String |

### getParentPaths-获取所有的父类路径

获取所有的父类路径
1. 不包含本身
2. 递归获取父类，如果父类为 null 则停止（说明到 root 了）
3. 默认 / root 的是所有逻辑的父亲路径，包括 root 文件夹本身。

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| path | 当前路径 | java.nio.file.Path |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 所有的父类列表 | java.util.List |

### getParentPath-获取父类路径，避免返回 null

获取父类路径，避免返回 null
1. 如果为根路径，则依然返回根路径

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| path | 路径 | java.nio.file.Path |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | java.nio.file.Path |

### retainAll-获取所有集合的交集

获取所有集合的交集
1. 如果后续参数为空，则直接返回第一个集合。
2. 如果第一个列表为空，则直接返回第一个集合。

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| collectionList | 原始对象集合 | 列表 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 满足条件的结合 | java.util.List |

### getPathList-递归获取所有对应的文件

递归获取所有对应的文件
1. 如果为文件，直接返回本身
2. 如果为文件夹，则递归获取下面的所有文件信息

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| rootPath | 根路径 | java.nio.file.Path |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 文件列表 | java.util.List |

### getPathList-获得对应的PATH列表。

获得对应的PATH列表。

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| dir | 文件夹 | 字符串 |
| glob | 文件正则 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 路径列表 | java.util.List |

### getDirFileNames-获取指定文件夹下对应的某类型文件

获取指定文件夹下对应的某类型文件

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| dir | 文件夹路径 | 字符串 |
| glob | 文件正则表达式 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| path list | java.util.List |

### getAllDirFileNames-获取某一路径下的所有文件

获取某一路径下的所有文件

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| dir | 文件夹 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 路径列表 | java.util.List |

### getDirFileNameStrs-获得列表下对应的文件字符串形式

获得列表下对应的文件字符串形式

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| dir | 文件夹 | 字符串 |
| glob | 文件正则 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 文件名称列表 | java.util.List |

### getPath-结果不确定

结果不确定

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 路径 | java.lang.String |

### getRootPath-获取的target路径

获取的target路径

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 路径 | java.lang.String |

### getAppRootPath-获取项目根路径。

获取项目根路径。

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 本项目中返回: /Users/houbinbin/IT/code/script-generator
since 0.0.7 | java.lang.String |

### getAppResourcesPath-获取资源文件默认存放路径。

获取资源文件默认存放路径。

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 根路径+/src/main/resources | java.lang.String |

### getAppTestResourcesPath-获取测试类

获取测试类

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 转换后的路径 | java.lang.String |

### getRootPath-类似getPath(Class), 只是不包含类的路径,而是获取到当前类包的根路径。

类似getPath(Class), 只是不包含类的路径,而是获取到当前类包的根路径。
如:
filelist:/Users/houbinbin/IT/code/script-generator/script-generator-tool/target/classes/
转化为:
/Users/houbinbin/IT/code/script-generator/script-generator-tool/src/main/java

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 转换后的路径 | java.lang.String |

### getPath-直接class.getResource("")拿到的是编译后的路径。

直接class.getResource("")拿到的是编译后的路径。
如:
filelist:/Users/houbinbin/IT/code/script-generator/script-generator-tool/target/classes/com/ryo/script-generator/util/
转化成:
/Users/houbinbin/IT/code/script-generator/script-generator-tool/src/main/java/com/ryo/script-generator/util/

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 转换后的路径 | java.lang.String |

### packageToPath-将包名称转化为对应的路径

将包名称转化为对应的路径
com.github.houbinbin TO: com/github/houbinbin

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| packagePath | 包名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 转换后的路径 | java.lang.String |

### readAllLines-读取文件所有行的内容

读取文件所有行的内容

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| pathStr | 路径 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 列表 | java.util.List |

### readAllLines-读取文件所有行的内容

读取文件所有行的内容

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| pathStr | 路径 | 字符串 |
| charset | 编码 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 列表 | java.util.List |

### readAllLines-读取文件所有的行

读取文件所有的行

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| pathStr | 路径 | 字符串 |
| charset | 编码 | 字符串 |
| startIndex | 开始行下标 | 整型 |
| endIndex | 结束行下标 | 整型 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 列表内容 | java.util.List |

### writeLines-写入行内容到指定列

写入行内容到指定列

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| pathStr | 路径 | 字符串 |
| lines | 行内容数组 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### writeLines-写入行内容到指定文件

写入行内容到指定文件

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| pathStr | 路径 | 字符串 |
| lines | 行内容 | 集合 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### appendLines-行内容添加到到指定列

行内容添加到到指定列

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| pathStr | 路径 | 字符串 |
| lines | 行内容数组 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### appendLines-行内容添加到到指定文件

行内容添加到到指定文件

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| pathStr | 路径 | 字符串 |
| lines | 行内容 | 集合 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### writeLines-写入行内容到指定列

写入行内容到指定列

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| pathStr | 路径 | 字符串 |
| lines | 行内容 | 集合 |
| charset | 编码 | 字符串 |
| openOptions | 操作 | java.nio.file.OpenOption |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |





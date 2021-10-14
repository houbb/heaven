## PackageUtil-包工具类

包工具类

### getPackageName-获取包名称

获取包名称

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 包名称 | java.lang.String |

### isSamePackage-是否在同一个包下

是否在同一个包下

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| packageName | 包名称 | 字符串 |
| clazz | 目标类 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否 | boolean |

### isJavaLangPackage-是否为 java.lang 包的类，不包含子包

是否为 java.lang 包的类，不包含子包

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| clazz | 类信息 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否 | boolean |

### scanPackageClassNameSet-扫描包中对应的类集合

扫描包中对应的类集合

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| packageName | 包名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果列表 | java.util.Set |

### recursiveFile-递归处理文件信息

递归处理文件信息

（1）如果是文件夹

（2）如果是文件
 跳过特殊标志的信息
 $ 这个怎么处理？
 Proxy.isProxyClass(XXX)

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| packageNamePrefix | 包名称前缀 | 字符串 |
| file | 根路径 | java.io.File |
| classNameSet | 类的全称信息集合 | java.util.Set |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### main-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| args |  | 数组 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |





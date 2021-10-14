## Hex-HEX

HEX

<a href="http://en.wikipedia.org/wiki/Hexadecimal">Hexadecimal</a> encoder and decoder.
This class was borrowed from Apache Commons Codec SVN repository (rev. {@code 560660}) with modifications
to enable Hex conversion without a full dependency on Commons Codec.  We didn't want to reinvent the wheel of
great work they've done, but also didn't want to force every Shiro user to depend on the commons-codec.jar
As per the Apache 2.0 license, the original copyright notice and all author and copyright information have
remained in tact.

### encodeToString-Encodes the specified byte array to a character array and then returns that character array

Encodes the specified byte array to a character array and then returns that character array
as a String.

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| bytes | the | 数组 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### encode-Converts an array of bytes into an array of characters representing the hexadecimal values of each byte in order.

Converts an array of bytes into an array of characters representing the hexadecimal values of each byte in order.
The returned array will be double the length of the passed array, as it takes two characters to represent any
given byte.

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| data | byte | 数组 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### decode-Converts an array of character bytes representing hexadecimal values into an

Converts an array of character bytes representing hexadecimal values into an
array of bytes of those same values. The returned array will be half the
length of the passed array, as it takes two characters to represent any
given byte. An exception is thrown if the passed char array has an odd
number of elements.

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| array | An | 数组 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### decode-Converts the specified Hex-encoded String into a raw byte array.  This is a

Converts the specified Hex-encoded String into a raw byte array.  This is a
convenience method that merely delegates to {@link #decode(char[])} using the
argument's hex.toCharArray() value.

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| hex | a | 字符串 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### decode-Converts an array of characters representing hexadecimal values into an

Converts an array of characters representing hexadecimal values into an
array of bytes of those same values. The returned array will be half the
length of the passed array, as it takes two characters to represent any
given byte. An exception is thrown if the passed char array has an odd
number of elements.

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| data | An | 数组 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### toDigit-Converts a hexadecimal character to an integer.

Converts a hexadecimal character to an integer.

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| ch | A | 字符 |  |  |
| index | The | 整型 |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情





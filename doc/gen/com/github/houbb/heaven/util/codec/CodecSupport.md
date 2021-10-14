## CodecSupport-Codec 支持类

Codec 支持类

Base abstract class that provides useful encoding and decoding operations, especially for character data.

### toBytes-Converts the specified character array to a byte array using the Shiro's preferred encoding (UTF-8).

Converts the specified character array to a byte array using the Shiro's preferred encoding (UTF-8).

This is a convenience method equivalent to calling the {@link #toBytes(String,String)} method with a
a wrapping String and {@link CodecSupport#PREFERRED_ENCODING PREFERRED_ENCODING}, i.e.

<code>toBytes( new String(chars), {@link CodecSupport#PREFERRED_ENCODING PREFERRED_ENCODING} );</code>

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| chars | the | 数组 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| the byte array of the UTF-8 encoded character array. | byte |

### toBytes-Converts the specified character array into a byte array using the specified character encoding.

Converts the specified character array into a byte array using the specified character encoding.

This is a convenience method equivalent to calling the {@link #toBytes(String,String)} method with a
a wrapping String and the specified encoding, i.e.

<code>toBytes( new String(chars), encoding );</code>

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| chars | the | 数组 |
| encoding | the | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| the bytes of the specified character array under the specified encoding. | byte |

### toBytes-Converts the specified source argument to a byte array with Shiro's

Converts the specified source argument to a byte array with Shiro's
{@link CodecSupport#PREFERRED_ENCODING PREFERRED_ENCODING}.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| source | the | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| the bytes representing the specified string under the {@link CodecSupport#PREFERRED_ENCODING PREFERRED_ENCODING}. | byte |

### toBytes-Converts the specified source to a byte array via the specified encoding, throwing a

Converts the specified source to a byte array via the specified encoding, throwing a
{@link CodecException CodecException} if the encoding fails.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| source | the | 字符串 |
| encoding | the | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| the byte array of the specified source with the given encoding. | byte |

### toString-Converts the specified byte array to a String using the {@link CodecSupport#PREFERRED_ENCODING PREFERRED_ENCODING}.

Converts the specified byte array to a String using the {@link CodecSupport#PREFERRED_ENCODING PREFERRED_ENCODING}.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| bytes | the | 数组 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| the specified byte array as an encoded String ({@link CodecSupport#PREFERRED_ENCODING PREFERRED_ENCODING}). | java.lang.String |

### toString-Converts the specified byte array to a String using the specified character encoding.  This implementation

Converts the specified byte array to a String using the specified character encoding.  This implementation
does the same thing as <code>new {@link String#String(byte[], String) String(byte[], encoding)}</code>, but will
wrap any {@link UnsupportedEncodingException} with a nicer runtime {@link CodecException}, allowing you to
decide whether or not you want to catch the exception or let it propagate.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| bytes | the | 数组 |
| encoding | the | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| the specified byte array as an encoded String | java.lang.String |

### toChars-Returns the specified byte array as a character array using the

Returns the specified byte array as a character array using the
{@link CodecSupport#PREFERRED_ENCODING PREFERRED_ENCODING}.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| bytes | the | 数组 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| the specified byte array encoded as a character array ({@link CodecSupport#PREFERRED_ENCODING PREFERRED_ENCODING}). | char |

### toChars-Converts the specified byte array to a character array using the specified character encoding.

Converts the specified byte array to a character array using the specified character encoding.

Effectively calls <code>{@link #toString(byte[], String) toString(bytes,encoding)}.{@link String#toCharArray() toCharArray()};</code>

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| bytes | the | 数组 |
| encoding | the | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| the specified byte array as an encoded char array | char |

### isByteSource-Returns {@code true} if the specified object can be easily converted to bytes by instances of this class,

Returns {@code true} if the specified object can be easily converted to bytes by instances of this class,
{@code false} otherwise.

The default implementation returns {@code true} IFF the specified object is an instance of one of the following
types:

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| o | the | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| {@code true} if the specified object can be easily converted to bytes by instances of this class,
        {@code false} otherwise. | boolean |

### toBytes-Converts the specified Object into a byte array.

Converts the specified Object into a byte array.
If the argument is a {@code byte[]}, {@code char[]}, {@link String}, {@link File}, or
{@link InputStream}, it will be converted automatically and returned.}
If the argument is anything other than these types, it is passed to the
{@link #objectToBytes(Object) objectToBytes} method which must be overridden by subclasses.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| o | the | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| a byte array representation of the Object argument. | byte |

### toString-Converts the specified Object into a String.

Converts the specified Object into a String.
If the argument is a {@code byte[]} or {@code char[]} it will be converted to a String using the
{@link #PREFERRED_ENCODING}.  If a String, it will be returned as is.
If the argument is anything other than these three types, it is passed to the
{@link #objectToString(Object) objectToString} method.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| o | the | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| a byte array representation of the Object argument. | java.lang.String |

### toBytes-暂无说明

暂无说明

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| file |  | java.io.File |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  | byte |

### toBytes-Converts the specified {@link InputStream InputStream} into a byte array.

Converts the specified {@link InputStream InputStream} into a byte array.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| in | the | java.io.InputStream |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| the bytes of the input stream | byte |

### objectToBytes-Default implementation throws a CodecException immediately since it can't infer how to convert the Object

Default implementation throws a CodecException immediately since it can't infer how to convert the Object
to a byte array.  This method must be overridden by subclasses if anything other than the three default
types (listed in the {@link #toBytes(Object) toBytes(Object)} JavaDoc) are to be converted to a byte array.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| o | the | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| a byte array representation of the Object argument. | byte |

### objectToString-Default implementation merely returns <code>objectArgument.toString()</code>.  Subclasses can override this

Default implementation merely returns <code>objectArgument.toString()</code>.  Subclasses can override this
method for different mechanisms of converting an object to a String.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| o | the | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| a String representation of the Object argument. | java.lang.String |

### toChars-转为字符串

转为字符串

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| text | 文本 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| char 数组 | char |

### toString-转化为字符串

转化为字符串

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| chars | 字符数组 | 数组 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 字符串 | java.lang.String |





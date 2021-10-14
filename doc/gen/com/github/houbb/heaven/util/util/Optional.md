## Optional-Optional 工具类

Optional 工具类

A container object which may or may not contain a non-null value.
If a value is present, {@code isPresent()} will return {@code true} and
{@code get()} will return the value.

此处简化 jdk8 Optional，提供一个简化版的 Optional提供给 jdk7 使用。便于过渡使用。

### Optional-Constructs an empty instance.

Constructs an empty instance.

Generally only one empty instance, {@link Optional#EMPTY},
should exist per VM.

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### empty-Returns an empty {@code Optional} instance.  No value is present for this

Returns an empty {@code Optional} instance.  No value is present for this
Optional.

Though it may be tempting to do so, avoid testing if an object
is empty by comparing with {@code ==} against instances returned by
{@code Option.empty()}. There is no guarantee that it is a singleton.
Instead, use {@link #isPresent()}.

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| an empty {@code Optional} | com.github.houbb.heaven.util.util.Optional |

### Optional-Constructs an instance with the value present.

Constructs an instance with the value present.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| value | the | T |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### of-Returns an {@code Optional} with the specified present non-null value.

Returns an {@code Optional} with the specified present non-null value.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| value | the | T |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| an {@code Optional} with the value present | com.github.houbb.heaven.util.util.Optional |

### ofNullable-Returns an {@code Optional} describing the specified value, if non-null,

Returns an {@code Optional} describing the specified value, if non-null,
otherwise returns an empty {@code Optional}.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| value | the | T |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| an {@code Optional} with a present value if the specified value
is non-null, otherwise an empty {@code Optional} | com.github.houbb.heaven.util.util.Optional |

### get-If a value is present in this {@code Optional}, returns the value,

If a value is present in this {@code Optional}, returns the value,
otherwise throws {@code NoSuchElementException}.

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| the non-null value held by this {@code Optional} | T |

### getCastOrNull-获取转换后的类型。

获取转换后的类型。
如果为空，则直接返回 null

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| rClass | 类型 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 结果 | R |

### isPresent-Return {@code true} if there is a value present, otherwise {@code false}.

Return {@code true} if there is a value present, otherwise {@code false}.

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| {@code true} if there is a value present, otherwise {@code false} | boolean |

### isNotPresent-Return {@code true} if there is a value not present, otherwise {@code false}.

Return {@code true} if there is a value not present, otherwise {@code false}.

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| {@code true} if there is a value not present, otherwise {@code false} | boolean |

### orElseThrow-Return the contained value, if present, otherwise throw an exception

Return the contained value, if present, otherwise throw an exception
to be created by the provided supplier.

A method reference to the exception constructor with an empty
argument list can be used as the supplier. For example,
{@code IllegalStateException::new}

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| throwable | Type | X |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| the present value | T |

### orElseNull-Return the contained value, if present, otherwise return null.

Return the contained value, if present, otherwise return null.

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| the present value or null | T |

### orDefault-Return the contained value, if present, otherwise return default value.

Return the contained value, if present, otherwise return default value.

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| defaultVal | default | T |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| the present value or default value | T |

### equals-Indicates whether some other object is "equal to" this Optional. The

Indicates whether some other object is "equal to" this Optional. The
other object is considered equal if:
<ul>
<li>it is also an {@code Optional} and;
<li>both instances have no value present or;
<li>the present values are "equal to" each other via {@code equals()}.
</ul>

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| obj | an | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| {code true} if the other object is "equal to" this object
otherwise {@code false} | boolean |

### hashCode-Returns the hash code value of the present value, if any, or 0 (zero) if

Returns the hash code value of the present value, if any, or 0 (zero) if
no value is present.

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| hash code value of the present value or 0 if no value is present | int |

### toString-Returns a non-empty string representation of this Optional suitable for

Returns a non-empty string representation of this Optional suitable for
debugging. The exact presentation format is unspecified and may vary
between implementations and versions.

If a value is present the result must include its string
representation in the result. Empty and present Optionals must be
unambiguously differentiable.

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| the string representation of this instance | java.lang.String |





## Optional-A container object which may or may not contain a non-null value.

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

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### empty-Returns an empty {@code Optional} instance.  No value is present for this

Returns an empty {@code Optional} instance.  No value is present for this
Optional.

Though it may be tempting to do so, avoid testing if an object
is empty by comparing with {@code ==} against instances returned by
{@code Option.empty()}. There is no guarantee that it is a singleton.
Instead, use {@link #isPresent()}.

#### 方法入参

暂无入参

##### 方法入参详情

暂无入参详情

#### 方法出参

| 字段 | 说明 | 字段类型 | 备注 |
|:---|:---|:---|:---|
| EMPTY | Common instance for {@code empty()}. | com.github.houbb.heaven.util.util.Optional |   |
| value | If non-null, the value; if null, indicates no value is present | T |   |

##### 方法出参详情

暂无出参详情

### Optional-Constructs an instance with the value present.

Constructs an instance with the value present.

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| value | the | T |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### of-Returns an {@code Optional} with the specified present non-null value.

Returns an {@code Optional} with the specified present non-null value.

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| value | the | T |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

| 字段 | 说明 | 字段类型 | 备注 |
|:---|:---|:---|:---|
| EMPTY | Common instance for {@code empty()}. | com.github.houbb.heaven.util.util.Optional |   |
| value | If non-null, the value; if null, indicates no value is present | T |   |

##### 方法出参详情

暂无出参详情

### ofNullable-Returns an {@code Optional} describing the specified value, if non-null,

Returns an {@code Optional} describing the specified value, if non-null,
otherwise returns an empty {@code Optional}.

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| value | the | T |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

| 字段 | 说明 | 字段类型 | 备注 |
|:---|:---|:---|:---|
| EMPTY | Common instance for {@code empty()}. | com.github.houbb.heaven.util.util.Optional |   |
| value | If non-null, the value; if null, indicates no value is present | T |   |

##### 方法出参详情

暂无出参详情

### get-If a value is present in this {@code Optional}, returns the value,

If a value is present in this {@code Optional}, returns the value,
otherwise throws {@code NoSuchElementException}.

#### 方法入参

暂无入参

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### getCastOrNull-获取转换后的类型。

获取转换后的类型。
如果为空，则直接返回 null

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| rClass | 类型 | java.lang.Class |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### isPresent-Return {@code true} if there is a value present, otherwise {@code false}.

Return {@code true} if there is a value present, otherwise {@code false}.

#### 方法入参

暂无入参

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### isNotPresent-Return {@code true} if there is a value not present, otherwise {@code false}.

Return {@code true} if there is a value not present, otherwise {@code false}.

#### 方法入参

暂无入参

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### orElseThrow-Return the contained value, if present, otherwise throw an exception

Return the contained value, if present, otherwise throw an exception
to be created by the provided supplier.

A method reference to the exception constructor with an empty
argument list can be used as the supplier. For example,
{@code IllegalStateException::new}

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| throwable | Type | X |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### orElseNull-Return the contained value, if present, otherwise return null.

Return the contained value, if present, otherwise return null.

#### 方法入参

暂无入参

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### orDefault-Return the contained value, if present, otherwise return default value.

Return the contained value, if present, otherwise return default value.

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| defaultVal | default | T |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### equals-Indicates whether some other object is "equal to" this Optional. The

Indicates whether some other object is "equal to" this Optional. The
other object is considered equal if:
<ul>
<li>it is also an {@code Optional} and;
<li>both instances have no value present or;
<li>the present values are "equal to" each other via {@code equals()}.
</ul>

#### 方法入参

| 字段 | 说明 | 字段类型 | 是否必填 | 备注 |
|:---|:---|:---|:---|:----|
| obj | an | java.lang.Object |  |  |

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### hashCode-Returns the hash code value of the present value, if any, or 0 (zero) if

Returns the hash code value of the present value, if any, or 0 (zero) if
no value is present.

#### 方法入参

暂无入参

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情

### toString-Returns a non-empty string representation of this Optional suitable for

Returns a non-empty string representation of this Optional suitable for
debugging. The exact presentation format is unspecified and may vary
between implementations and versions.

If a value is present the result must include its string
representation in the result. Empty and present Optionals must be
unambiguously differentiable.

#### 方法入参

暂无入参

##### 方法入参详情

暂无入参详情

#### 方法出参

暂无出参

##### 方法出参详情

暂无出参详情





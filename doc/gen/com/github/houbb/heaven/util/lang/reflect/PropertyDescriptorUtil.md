## PropertyDescriptorUtil-内省工具类

内省工具类

### PropertyDescriptorUtil-暂无说明

暂无说明

#### 方法入参

暂无入参

#### 方法出参

| 说明 | 类型 |
|:---|:---|
|  |  |

### getPropertyDescriptor-获取属性描述类

获取属性描述类

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| beanClass | 类 | java.lang.Class |
| propertyName | 属性值 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 性描述 | java.beans.PropertyDescriptor |

### getReadMethod-获取属性读方法

获取属性读方法

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| beanClass | 对象类型 | java.lang.Class |
| propertyName | 属性名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 属性读方法 | java.lang.reflect.Method |

### getWriteMethod-获取属性写方法

获取属性写方法

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| beanClass | 对象类型 | java.lang.Class |
| propertyName | 属性名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 属性写方法 | java.lang.reflect.Method |

### getPropertyType-获取属性类型

获取属性类型

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| beanClass | 对象类型 | java.lang.Class |
| propertyName | 属性名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 属性字段类型 | java.lang.Class |

### getAllPropertyDescriptorList-获取所有属性描述列表

获取所有属性描述列表

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| beanClass | 对象信息 | java.lang.Class |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 列表 | java.util.List |

### setPropertyValue-设置属性值

设置属性值

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| bean | 对象 | java.lang.Object |
| descriptor | 描述类 | java.beans.PropertyDescriptor |
| value | 待设置的值 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否设置成功 | boolean |

### setPropertyValue-设置属性值

设置属性值

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| bean | 对象 | java.lang.Object |
| descriptorName | 描述名称 | 字符串 |
| value | 待设置的值 | java.lang.Object |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 是否设置成功 | boolean |

### getPropertyValue-获取属性值

获取属性值

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| bean | 对象 | java.lang.Object |
| descriptor | 描述类 | java.beans.PropertyDescriptor |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 对应的值 | java.lang.Object |

### getPropertyValue-获取属性值

获取属性值

#### 方法入参

| 字段 | 说明 | 字段类型 |
|:---|:---|:---|
| bean | 对象 | java.lang.Object |
| descriptorName | 描述名称 | 字符串 |

#### 方法出参

| 说明 | 类型 |
|:---|:---|
| 对应的配置值 | java.lang.Object |





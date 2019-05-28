package com.github.houbb.heaven.reflect.api;

import java.util.List;

/**
 * 类信息接口
 * @author binbin.hou
 * @since 0.1.5
 */
public interface IClass extends IMember {

    /**
     * 字段列表
     * @return 字段列表
     */
    List<IField> fields();

    /**
     * 方法列表
     * @return 方法列表
     */
    List<IMethod> methods();

}

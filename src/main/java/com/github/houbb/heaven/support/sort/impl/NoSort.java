package com.github.houbb.heaven.support.sort.impl;

import com.github.houbb.heaven.support.sort.ISort;

import java.util.List;

/**
 * 不进行任何排序
 * @author binbin.hou
 * @since 0.1.6
 */
public class NoSort<T> implements ISort<T> {

    @Override
    public List<T> sort(List<T> list) {
        return list;
    }

}

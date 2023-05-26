package com.github.houbb.heaven.util.model;

import java.util.List;

public class TestGenericTypeUser<T> {

    private List<T> nameList;

    private String name;

    public List<T> getNameList() {
        return nameList;
    }

    public void setNameList(List<T> nameList) {
        this.nameList = nameList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestGenericTypeUser{" +
                "nameList=" + nameList +
                ", name='" + name + '\'' +
                '}';
    }

}

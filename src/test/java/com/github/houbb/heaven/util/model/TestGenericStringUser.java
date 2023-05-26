package com.github.houbb.heaven.util.model;

import java.util.List;

public class TestGenericStringUser {

    private List<String> nameList;

    private String name;

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
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
        return "TestGenericUser{" +
                "nameList=" + nameList +
                ", name='" + name + '\'' +
                '}';
    }

}

# 项目简介

本项目用于提供公有的核心代码，收集常见的工具类。

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.houbb/heaven/badge.svg)](http://mvnrepository.com/artifact/com.github.houbb/heaven)
[![Build Status](https://www.travis-ci.org/houbb/heaven.svg?branch=master)](https://www.travis-ci.org/houbb/heaven?branch=master)
[![Coverage Status](https://coveralls.io/repos/github/houbb/heaven/badge.svg?branch=master)](https://coveralls.io/github/houbb/heaven?branch=master)

## 准则

不引入任何三方工具。

只有一个模块，保证快速迭代。

同一个大版本下保证兼容性。

# 变更日志

> [变更日志](doc/CHANGELOG.md)

# 项目准则

最基础的项目一定要简单，精简，健壮。

所有的高楼都应该以此为基础。

引入这个类的开发项目，除非特殊需要，不用再手写常见的 util 工具。

# 快速开始 

## 需要 

jdk1.7+

maven 3.x+

## maven 引入 

```xml
<dependency>
    <groupId>com.github.houbb</groupId>
    <artifactId>heaven</artifactId>
    <version>0.1.121</version>
</dependency>
```
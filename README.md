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

> [变更日志](CHANGELOG.md)

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
    <version>0.11.0</version>
</dependency>
```

# 文档

> [文档目录](doc/gen/heaven-索引.md)

# ROAD-MAP

- [ ] 添加基于 gen-case 的测试用例

# 中间件等工具开源矩阵

[heaven: 收集开发中常用的工具类](https://github.com/houbb/heaven)

[rpc: 基于 netty4 实现的远程调用工具](https://github.com/houbb/rpc)

[mq: 简易版 mq 实现](https://github.com/houbb/mq)

[ioc: 模拟简易版 spring ioc](https://github.com/houbb/ioc)

[mybatis: 简易版 mybatis](https://github.com/houbb/mybatis)

[cache: 渐进式 redis 缓存](https://github.com/houbb/cache)

[jdbc-pool: 数据库连接池实现](https://github.com/houbb/jdbc-pool)

[sandglass: 任务调度时间工具框架](https://github.com/houbb/sandglass)

[sisyphus: 支持注解的重试框架](https://github.com/houbb/sisyphus)

[resubmit: 防止重复提交框架，支持注解](https://github.com/houbb/resubmit)

[auto-log: 日志自动输出](https://github.com/houbb/auto-log)

[async: 多线程异步并行框架](https://github.com/houbb/async)

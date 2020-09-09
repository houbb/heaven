/*
 * Copyright (c)  2019. houbinbin Inc.
 * heaven All rights reserved.
 */

package com.github.houbb.heaven.util.id.impl;


import com.github.houbb.heaven.util.id.Id;
import com.github.houbb.heaven.util.lang.StringUtil;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <p> 雪花算法  19 位 </p>
 *
 * <pre> Created: 2018/6/15 上午11:41  </pre>
 * <pre> Project: heaven  </pre>
 * [理解分布式id生成算法SnowFlake](https://segmentfault.com/a/1190000011282426?utm_source=tag-newest)
 *
 * @author houbinbin
 * @since 0.1.12
 */
@Deprecated
public class SnowFlakeId implements Id {

    /**
     * 机器标识位数
     */
    private static final long workerIdBits = 5L;

    private static final long datacenterIdBits = 5L;

    private static final long maxWorkerId = -1L ^ (-1L << workerIdBits);

    private static final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

    /**
     * worker 唯一标识
     */
    private long workerId;

    /**
     * 数据标识id部分
     */
    private long datacenterId;
    /**
     * 并发控制
     */
    private long sequence = 0L;
    /**
     * 上次生产id时间戳
     */
    private long lastTimestamp = -1L;

    public SnowFlakeId() {
        this.datacenterId = getDatacenterId(maxDatacenterId);
        this.workerId = getMaxWorkerId(datacenterId, maxWorkerId);
    }

    /**
     * @param workerId     工作机器ID
     * @param datacenterId 序列号
     */
    public SnowFlakeId(long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new RuntimeException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new RuntimeException(
                    String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    /**
     * 获取 maxWorkerId
     *
     * @param datacenterId 客户端编号
     * @param maxWorkerId  机器标识
     * @return 最大机器标识
     */
    protected static long getMaxWorkerId(long datacenterId, long maxWorkerId) {
        StringBuilder mpid = new StringBuilder();
        mpid.append(datacenterId);
        String name = ManagementFactory.getRuntimeMXBean().getName();
        if (StringUtil.isNotEmpty(name)) {
            /*
             * GET jvmPid
             */
            mpid.append(name.split("@")[0]);
        }
        /*
         * MAC + PID 的 hashcode 获取16个低位
         */
        return (mpid.toString().hashCode() & 0xffff) % (maxWorkerId + 1);
    }

    /**
     * 数据标识id部分
     *
     * @param maxDatacenterId 最大标识
     * @return 最大标识
     */
    protected static long getDatacenterId(long maxDatacenterId) {
        long id = 0L;
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            if (network == null) {
                id = 1L;
            } else {
                byte[] mac = network.getHardwareAddress();
                if (null != mac) {
                    id = ((0x000000FF & (long) mac[mac.length - 1]) | (0x0000FF00 & (((long) mac[mac.length - 2]) << 8))) >> 6;
                    id = id % (maxDatacenterId + 1);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    /**
     * 获取下一个ID
     *
     * @return next id
     */
    private synchronized long nextId() {
        long timestamp = timeGen();
        //闰秒
        if (timestamp < lastTimestamp) {
            long offset = lastTimestamp - timestamp;
            if (offset <= 5) {
                try {
                    wait(offset << 1);
                    timestamp = timeGen();
                    if (timestamp < lastTimestamp) {
                        throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", offset));
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", offset));
            }
        }

        //毫秒内自增位
        long sequenceBits = 12L;
        if (lastTimestamp == timestamp) {
            // 相同毫秒内，序列号自增
            long sequenceMask = -1L ^ (-1L << sequenceBits);
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                // 同一毫秒的序列数已经达到最大
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            // 不同毫秒内，序列号置为 1 - 3 随机数
            sequence = ThreadLocalRandom.current().nextLong(1, 3);
        }

        lastTimestamp = timestamp;

        // 时间戳部分
        long workerIdShift = sequenceBits;
        long datacenterIdShift = sequenceBits + workerIdBits;
        /* 时间戳左移动位 */
        long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
        //时间起始标记点，作为基准，一般取系统的最近时间（一旦确定不能变动）
        long twepoch = 1288834974657L;
        return ((timestamp - twepoch) << timestampLeftShift)
                // 数据中心部分
                | (datacenterId << datacenterIdShift)
                // 机器标识部分
                | (workerId << workerIdShift)
                // 序列号部分
                | sequence;
    }

    /**
     * 等待直到下一个毫秒
     * @param lastTimestamp 等待直到下一个毫秒
     * @return 等待直到下一个毫秒
     */
    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 生成时间
     * @return 时间
     */
    protected long timeGen() {
        return System.currentTimeMillis();
    }

    @Override
    public String genId() {
        return String.valueOf(this.nextId());
    }

}

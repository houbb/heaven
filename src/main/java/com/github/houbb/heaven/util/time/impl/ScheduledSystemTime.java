package com.github.houbb.heaven.util.time.impl;

import com.github.houbb.heaven.util.time.Time;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 基于任务调度，性能更好的时间戳获取类
 *
 * ps: 这里其实有一个问题，因为是 1ms 调度一次，会导致时间更新没有那么及时。
 *
 * @author d
 * @since 0.1.163
 */
public class ScheduledSystemTime implements Time  {

    /**
     * 时间间隔
     *
     * 1毫秒=1000微秒
     * 机器时钟，纳秒不是那么准确
     */
    private final long period;

    /**
     * 当前时间戳
     */
    private final AtomicLong now;

    private ScheduledSystemTime(long period) {
        this.period = period;
        this.now = new AtomicLong(System.currentTimeMillis());
        scheduleClockUpdating();
    }

    public ScheduledSystemTime() {
        this(1);
    }

    private void scheduleClockUpdating() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {

            @Override
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "System Clock");
                thread.setDaemon(true);
                return thread;
            }
        });
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                now.incrementAndGet();
            }
        }, period, period, TimeUnit.MILLISECONDS);
    }

    @Override
    public long time() {
        return now.get();
    }

}

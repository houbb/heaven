package com.github.houbb.heaven.support.concurrent.context;

import com.github.houbb.heaven.util.lang.SpiUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * 跨线程处理
 *
 * 作用：用来跨线程处理传递信息，比如 async，线程池等。
 *
 * 比如在 aop 中，直接处理。
 *
 * <pre>
 * Object[] args = point.args();
 * Object arg0 = args[0];
 *
 * // 直接转换为当前的对象
 * if(arg0 instanceOf Runnable) {
 *      args[0] = new CrossThreadWrapper((Runnable)arg0);
 * } else if(arg0 instanceOf Callable) {
 *      args[0] = new CrossThreadWrapper((Callable)arg0);
 * }
 *
 * // 继续处理
 * </pre>
 * @param <T> 泛型
 * @since 0.3.0
 */
public class CrossThreadWrapper<T> implements Runnable, Callable<T> {

    private Runnable runnable;

    private Callable<T> callable;

    /**
     * 通过 spi 获取所有的实现类
     */
    private static List<CrossThreadProcessor> processorList = new ArrayList<>();

    /**
     * 上下文
     */
    private final Map<String, Object> context = new HashMap<>();

    static {
        processorList = SpiUtil.getClassImplList(CrossThreadProcessor.class);
    }

    public CrossThreadWrapper(Runnable runnable) {
        // 任务执行之前
        this.initContext();

        this.runnable = runnable;
    }

    public CrossThreadWrapper(Callable<T> callable) {
        this.initContext();

        this.callable = callable;
    }

    @Override
    public void run() {
        try {
            beforeExecute();
            this.runnable.run();
        } finally {
            afterExecute();
        }
    }

    @Override
    public T call() throws Exception {
        try {
            beforeExecute();
            return this.callable.call();
        } finally {
            afterExecute();
        }
    }

    /**
     * 初始化上下文
     */
    protected void initContext() {
        for(CrossThreadProcessor processor : processorList) {
            processor.initContext(context);
        }
    }

    /**
     * 执行前
     */
    protected void beforeExecute() {
        for(CrossThreadProcessor processor : processorList) {
            processor.beforeExecute(context);
        }
    }

    /**
     * 执行之后
     */
    protected void afterExecute() {
        for(CrossThreadProcessor processor : processorList) {
            processor.afterExecute(context);
        }
    }

}

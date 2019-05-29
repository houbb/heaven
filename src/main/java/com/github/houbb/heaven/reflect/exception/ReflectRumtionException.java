package com.github.houbb.heaven.reflect.exception;

/**
 *
 * 反射运行时异常
 * @author binbin.hou
 * @since 0.1.5
 */
public class ReflectRumtionException extends RuntimeException {

    public ReflectRumtionException() {
    }

    public ReflectRumtionException(String message) {
        super(message);
    }

    public ReflectRumtionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReflectRumtionException(Throwable cause) {
        super(cause);
    }

    public ReflectRumtionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

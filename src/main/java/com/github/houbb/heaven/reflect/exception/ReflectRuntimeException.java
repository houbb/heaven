package com.github.houbb.heaven.reflect.exception;

/**
 *
 * 反射运行时异常
 * @author binbin.hou
 * @since 0.1.5
 */
public class ReflectRuntimeException extends RuntimeException {

    public ReflectRuntimeException() {
    }

    public ReflectRuntimeException(String message) {
        super(message);
    }

    public ReflectRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReflectRuntimeException(Throwable cause) {
        super(cause);
    }

    public ReflectRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package com.github.houbb.heaven.reflect.handler;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.reflect.simple.SimpleAnnotation;
import com.github.houbb.heaven.support.handler.IHandler;

import java.lang.annotation.Annotation;

/**
 * @author binbin.hou
 * @since 0.1.5
 */
@ThreadSafe
public class SimpleAnnotationHandler implements IHandler<Annotation, SimpleAnnotation> {

    @Override
    public SimpleAnnotation handle(Annotation annotation) {
        return null;
    }

}

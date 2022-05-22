package com.wbo112.demo1.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(value=RUNTIME)
public @interface HelloWorldAnnotation {
}

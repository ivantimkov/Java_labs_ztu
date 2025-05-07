package com.education.ztu;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String author() default "Student";
    String date() default "2025-05-07";
    int version() default 1;
}

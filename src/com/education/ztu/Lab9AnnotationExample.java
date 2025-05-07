package com.education.ztu;

import java.lang.reflect.Method;

public class Lab9AnnotationExample {
    public static void main(String[] args) throws Exception {
        Class<AnnotatedClass> clazz = AnnotatedClass.class;

        if (clazz.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);
            System.out.println("Class annotation: author=" + annotation.author() +
                    ", date=" + annotation.date() + ", version=" + annotation.version());
        }

        Method method = clazz.getMethod("annotatedMethod");
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            System.out.println("Method annotation: author=" + annotation.author() +
                    ", date=" + annotation.date() + ", version=" + annotation.version());
        }
    }
}

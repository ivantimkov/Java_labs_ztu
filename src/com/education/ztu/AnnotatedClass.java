package com.education.ztu;

@MyAnnotation(author = "Іван", date = "2025-05-07", version = 2)
public class AnnotatedClass {
    @MyAnnotation
    public void annotatedMethod() {
        System.out.println("Цей метод анотований.");
    }
}

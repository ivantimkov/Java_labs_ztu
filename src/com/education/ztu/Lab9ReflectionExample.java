package com.education.ztu;

import java.lang.reflect.*;

public class Lab9ReflectionExample {
    public static void main(String[] args) throws Exception {
        // 1. Три способи отримати Class
        Class<?> clazz1 = Person.class;
        Class<?> clazz2 = new Person().getClass();
        Class<?> clazz3 = Class.forName("com.education.ztu.Person");

        System.out.println("== Поля ==");
        for (Field field : clazz1.getDeclaredFields()) {
            System.out.println(field.getName() + " (" + field.getType().getSimpleName() + ")");
        }

        System.out.println("\n== Методи ==");
        for (Method method : clazz1.getDeclaredMethods()) {
            System.out.print(method.getName() + "(");
            for (Class<?> paramType : method.getParameterTypes()) {
                System.out.print(paramType.getSimpleName() + " ");
            }
            System.out.println(") : " + method.getReturnType().getSimpleName());
        }

        System.out.println("\n== Конструктори ==");
        for (Constructor<?> constructor : clazz1.getDeclaredConstructors()) {
            System.out.print(clazz1.getSimpleName() + "(");
            for (Class<?> param : constructor.getParameterTypes()) {
                System.out.print(param.getSimpleName() + " ");
            }
            System.out.println(")");
        }

        // Створити екземпляр
        Object person = clazz1.getConstructor(String.class, int.class, String.class)
                              .newInstance("Аліна", 25, "HR");
        // Виклик методу
        Method greet = clazz1.getMethod("greet");
        greet.invoke(person);

        // Робота з приватним полем
        Field ageField = clazz1.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(person, 35);
        System.out.println("Новий вік: " + ageField.get(person));
    }
}

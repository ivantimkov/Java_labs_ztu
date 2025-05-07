package com.education.ztu;

public class Person {
    public String name;
    private int age;
    private String position;

    public Person() {
        this.name = "Default Name";
        this.age = 0;
        this.position = "None";
    }

    public Person(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public void greet() {
        System.out.println("Hello, my name is " + name);
    }

    private void promote(String newPosition) {
        this.position = newPosition;
        System.out.println("Promoted to " + newPosition);
    }
}

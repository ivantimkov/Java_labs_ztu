package com.education.ztu.game;

import java.io.Serializable;
import java.util.Objects;

public abstract class Participant implements Cloneable, Comparable<Participant>, Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public Participant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Геттери
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Сеттери
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Клонування
    @Override
    public Participant clone() {
        try {
            return (Participant) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Participant that = (Participant) obj;
        return age == that.age && Objects.equals(name, that.name);
    }

    // toString
    @Override
    public String toString() {
        return "Participant{name='" + name + "', age=" + age + "}";
    }

    // compareTo (порівняння по імені)
    @Override
    public int compareTo(Participant other) {
        return this.name.compareTo(other.name);
    }
}

package com.education.ztu;

public abstract class Person implements Human {
    private String firstName;
    private String lastName;
    protected int age;
    protected Location location;
    protected Gender gender;
    protected static int counter = 0;

    // Блок ініціалізації
    {
        firstName = "John";
        lastName = "Doe";
        age = 18;
        location = Location.UKRAINE;
        gender = Gender.OTHER;
        counter++;
    }

    // Конструктори
    public Person() {}

    public Person(String firstName, String lastName, int age, Location location, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.location = location;
        this.gender = gender;
        counter++;
    }

    // Getters & Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }

    // Статичний метод
    public static void showCounter() {
        System.out.println("Created Persons: " + counter);
    }

    // Реалізація Human
    @Override
    public void sayFullName() {
        System.out.println("Full Name: " + firstName + " " + lastName);
    }

    @Override
    public void sayAge() {
        System.out.println("Age: " + age);
    }

    @Override
    public void sayLocation() {
        System.out.println("Location: " + location);
    }

    @Override
    public void sayGender() {
        System.out.println("Gender: " + gender);
    }

    public void getFullInfo() {
        sayFullName();
        sayAge();
        sayLocation();
        sayGender();
    }

    public abstract String getOccupation();
}
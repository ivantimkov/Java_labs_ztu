package com.education.ztu;

public class Teacher extends Person {
    private String subject;
    private Car car;

    public Teacher() {
        super();
        this.subject = "Unknown subject";
        this.car = new Car("DefaultCar", "AAA0000");
    }

    public Teacher(String firstName, String lastName, int age, Location location, Gender gender, String subject, Car car) {
        super(firstName, lastName, age, location, gender);
        this.subject = subject;
        this.car = car;
    }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public Car getCar() { return car; }
    public void setCar(Car car) { this.car = car; }

    public void teach() {
        System.out.println(getFirstName() + " is teaching " + subject);
    }

    @Override
    public String getOccupation() {
        return "Teacher";
    }

    @Override
    public void getFullInfo() {
        super.getFullInfo();
        System.out.println("Occupation: " + getOccupation());
        System.out.println("Subject: " + subject);
        System.out.println("Car: " + car);
    }
}
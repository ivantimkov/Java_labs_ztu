package com.education.ztu;

public class Employee extends Person {
    private String company;
    private Car car;

    public Employee() {
        super();
        this.company = "Unknown Company";
        this.car = new Car("DefaultCar", "BBB1111");
    }

    public Employee(String firstName, String lastName, int age, Location location, Gender gender, String company, Car car) {
        super(firstName, lastName, age, location, gender);
        this.company = company;
        this.car = car;
    }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public Car getCar() { return car; }
    public void setCar(Car car) { this.car = car; }

    public void work() {
        System.out.println(getFirstName() + " is working at " + company);
    }

    @Override
    public String getOccupation() {
        return "Employee";
    }

    @Override
    public void getFullInfo() {
        super.getFullInfo();
        System.out.println("Occupation: " + getOccupation());
        System.out.println("Company: " + company);
        System.out.println("Car: " + car);
    }
}

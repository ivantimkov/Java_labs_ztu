package com.education.ztu;

public class Student extends Person {
    private String university;

    public Student() {
        super();
        this.university = "Unknown University";
    }

    public Student(String firstName, String lastName, int age, Location location, Gender gender, String university) {
        super(firstName, lastName, age, location, gender);
        this.university = university;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void study() {
        System.out.println(getFirstName() + " is studying at " + university);
    }

    @Override
    public String getOccupation() {
        return "Student";
    }

    @Override
    public void getFullInfo() {
        super.getFullInfo();
        System.out.println("Occupation: " + getOccupation());
        System.out.println("University: " + university);
    }
}
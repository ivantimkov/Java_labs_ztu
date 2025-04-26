package com.education.ztu;

import com.education.ztu.game.*;

public class Main {
    public static void main(String[] args) {
        // Створюємо учасників
        Student student1 = new Student("Іван", 20);
        Student student2 = new Student("Олена", 21);

        Schoolar schoolar1 = new Schoolar("Максим", 14);
        Schoolar schoolar2 = new Schoolar("Аліна", 13);

        Employee employee1 = new Employee("Сергій", 30);
        Employee employee2 = new Employee("Марина", 28);

        // Створюємо команди
        Team<Student> studentTeam = new Team<>("Student Team");
        Team<Schoolar> schoolarTeam = new Team<>("Schoolar Team");
        Team<Employee> employeeTeam = new Team<>("Employee Team");

        // Додаємо учасників у відповідні команди
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);

        schoolarTeam.addNewParticipant(schoolar1);
        schoolarTeam.addNewParticipant(schoolar2);

        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);

        // Гра між командами (тільки між однаковими лігами!)
        studentTeam.playWith(studentTeam);
        schoolarTeam.playWith(schoolarTeam);
        employeeTeam.playWith(employeeTeam);

        // Помилка компіляції, якщо спробувати грати різні ліги:
        // studentTeam.playWith(employeeTeam); // не дозволено
    }
}

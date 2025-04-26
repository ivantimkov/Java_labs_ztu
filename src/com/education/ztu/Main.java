package com.education.ztu;

public class Main {
    public static void main(String[] args) {
        // Створення об'єктів
        Student student = new Student("Alice", "Green", 20, Location.UKRAINE, Gender.FEMALE, "ZTU");
        Teacher teacher = new Teacher("Bob", "Smith", 45, Location.USA, Gender.MALE, "Math", new Car("Toyota", "AB1234CD"));
        Employee employee = new Employee("Charlie", "Brown", 30, Location.CANADA, Gender.MALE, "Google", new Car("Tesla", "XY9876ZZ"));

        // Демонстрація методів
        System.out.println("=== Student Info ===");
        student.getFullInfo();
        student.study();

        System.out.println("\n=== Teacher Info ===");
        teacher.getFullInfo();
        teacher.teach();
        teacher.getCar().startCar();
        System.out.println("Engine running: " + teacher.getCar().isRunning());

        System.out.println("\n=== Employee Info ===");
        employee.getFullInfo();
        employee.work();
        employee.getCar().startCar();
        System.out.println("Engine running: " + employee.getCar().isRunning());

        // Статичний лічильник
        System.out.println("\n=== Total Persons Created ===");
        Person.showCounter();

        // instanceof демонстрація
        System.out.println("\n=== instanceof demonstration ===");
        System.out.println("Is student a Person? " + (student instanceof Person));
        System.out.println("Is teacher a Student? " + (teacher instanceof Person));
        System.out.println("Is employee a Human? " + (employee instanceof Human));
    }
}

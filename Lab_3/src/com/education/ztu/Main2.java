package com.education.ztu;

import com.education.ztu.game.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Main2 {
    public static void main(String[] args) {
        // Створюємо учасників
        Student student1 = new Student("Іван", 20);
        Student student2 = new Student("Олена", 21);

        // Створюємо команду студентів
        Team<Student> studentTeam = new Team<>("Student Team");
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);

        // Клонуємо команду
        Team<Student> clonedTeam = new Team<>(studentTeam);

        // Виводимо оригінальну та клоновану команди
        System.out.println("Original team: " + studentTeam.getParticipants());
        System.out.println("Cloned team: " + clonedTeam.getParticipants());

        // Перевіряємо equals та hashCode
        System.out.println("Teams are equal: " + studentTeam.getParticipants().equals(clonedTeam.getParticipants()));
        System.out.println("Hashcodes: Original=" + studentTeam.hashCode() + ", Cloned=" + clonedTeam.hashCode());

        // Додаємо їх в список
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        // Сортування за іменем (Comparable)
        Collections.sort(students);
        System.out.println("Sorted by name:");
        students.forEach(System.out::println);

        // Сортування за віком (Comparator)
        students.sort(new ParticipantAgeComparator());
        System.out.println("\nSorted by age:");
        students.forEach(System.out::println);

        // Сортування за іменем, потім за віком (Java 8 компаратор)
        Comparator<Participant> nameAgeComparator = Comparator
                .comparing(Participant::getName)
                .thenComparing(Participant::getAge);

        students.sort(nameAgeComparator);
        System.out.println("\nSorted by name then age:");
        students.forEach(System.out::println);
    }
}

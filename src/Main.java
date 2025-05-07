package com.education.ztu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Java Lab 4 Меню =====");
            System.out.println("1. Методи класу String");
            System.out.println("2. StringBuilder / StringBuffer");
            System.out.println("3. Форматований чек");
            System.out.println("4. Інтернаціоналізація чеку");
            System.out.println("5. Робота з датами");
            System.out.println("0. Вихід");
            System.out.print("Оберіть пункт: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    StringMethods.main(null);
                    break;
                case 2:
                    StringBuilderDemo.main(null);
                    break;
                case 3:
                    Receipt.main(null);
                    break;
                case 4:
                    LocalizationExample.main(null);
                    break;
                case 5:
                    DateExample.main(null);
                    break;
                case 0:
                    System.out.println("Завершення програми...");
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }

        } while (choice != 0);
    }
}

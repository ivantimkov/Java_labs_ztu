import com.education.ztu.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Меню ===");
            System.out.println("1. Вивести Hello, World!!!");
            System.out.println("2. Додавання двох чисел");
            System.out.println("3. Виведення аргументів командного рядка");
            System.out.println("4. НСД двох чисел");
            System.out.println("5. Сума цифр числа");
            System.out.println("6. Послідовність Фібоначчі");
            System.out.println("7. Коди латинських літер");
            System.out.println("0. Вихід");
            System.out.print("Виберіть опцію: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // спожити перехід на новий рядок

            switch (choice) {
                case 1 -> Task1.main(null);
                case 2 -> Task2.main(null);
                case 3 -> Task3.main(new String[]{"2", "3", "5", "8"});
                case 4 -> Task4.main(null);
                case 5 -> Task5.main(null);
                case 6 -> Task6.main(null);
                case 7 -> Task7.main(null);
                case 0 -> running = false;
                default -> System.out.println("Невірний вибір!");
            }
        }

        System.out.println("Завершення роботи.");
    }
}
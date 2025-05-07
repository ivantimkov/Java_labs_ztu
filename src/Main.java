
import com.education.ztu.Lab9AnnotationExample;
import com.education.ztu.Lab9ReflectionExample;
import com.education.ztu.Lab9RegexExample;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Головне меню ===");
            System.out.println("1. Демонстрація регулярних виразів");
            System.out.println("2. Демонстрація Reflection API");
            System.out.println("3. Демонстрація анотацій");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Lab9RegexExample.main(null);
                    break;
                case "2":
                    Lab9ReflectionExample.main(null);
                    break;
                case "3":
                    Lab9AnnotationExample.main(null);
                    break;
                case "0":
                    System.out.println("Завершення програми...");
                    return;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }
}

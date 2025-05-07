
import com.education.ztu.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Перевірка логіну та паролю ===");
        boolean result = checkCredentials("User_123", "Pass_123", "Pass_123");
        System.out.println("Результат перевірки: " + result);

        System.out.println("\n=== Створення звіту про покупки ===");
        List<Product> products = new ArrayList<>();
        products.add(new Product("Молоко", 25.5, 2));
        products.add(new Product("Хліб", 15.0, 1));
        products.add(new Product("Сир", 80.0, 1));

        String reportPath = "directory_for_files/purchases.txt";
        FileOperations.writeReport(products, reportPath);

        System.out.println("\n=== Читання звіту з файлу ===");
        FileOperations.readReport(reportPath);

        System.out.println("\n=== Копіювання текстового файлу ===");
        FileOperations.copyTextFile("directory_for_files/purchases.txt", "directory_for_files/purchases_copy.txt");

        System.out.println("\n=== Копіювання зображення ===");
        FileOperations.copyBinaryFile("directory_for_files/source_image.jpg", "directory_for_files/copied_image.jpg");

        System.out.println("\n=== Вставка тексту в файл (RandomAccessFile) ===");
        FileOperations.modifyFile("directory_for_files/purchases.txt", "\nДодатковий товар", 50);

        System.out.println("\n=== Операції з File API ===");
        FileOperations.fileOperations();

        System.out.println("\n=== Створення архіву ===");
        ArchiveManager.createZip("directory_for_files", "directory_for_files/archive.zip");

        System.out.println("\n=== Зчитування вмісту архіву ===");
        ArchiveManager.readZip("directory_for_files/archive.zip");
    }

    public static boolean checkCredentials(String login, String password, String confirmPassword) {
        try {
            if (!login.matches("[a-zA-Z0-9_]+") || login.length() >= 20) {
                throw new WrongLoginException("Логін повинен містити лише латинські літери, цифри та знак підкреслення і бути менше 20 символів.");
            }

            if (!password.matches("[a-zA-Z0-9_]+") || password.length() >= 20) {
                throw new WrongPasswordException("Пароль повинен містити лише латинські літери, цифри та знак підкреслення і бути менше 20 символів.");
            }

            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароль і підтвердження не співпадають.");
            }

            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Помилка: " + e.getMessage());
            return false;
        }
    }
}

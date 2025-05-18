import com.education.ztu.ProductDAO;
import com.education.ztu.Product;

public class Main {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();

        System.out.println("Завдання 3: Створення таблиці та додавання 10 товарів через Statement...");
        dao.createTableAndAddTenProducts();

        System.out.println("\nЗавдання 3: Всі товари після додавання:");
        dao.getAll().forEach(System.out::println);

        System.out.println("\nЗавдання 4: Додавання 5 товарів через PreparedStatement...");
        dao.addFiveProducts();

        System.out.println("\nЗавдання 4: Товари після додавання 5 нових:");
        dao.getAll().forEach(System.out::println);

        System.out.println("\nЗавдання 4: Пошук товарів за категорією або брендом 'Accessories':");
        dao.findByCategoryOrBrand("Accessories");

        System.out.println("\nЗавдання 4: Видалення всіх товарів...");
        dao.deleteAll();

        System.out.println("\nПісля видалення всі товари:");
        dao.getAll().forEach(System.out::println);

        System.out.println("\nЗавдання 5: Додавання двох товарів з транзакціями та точкою збереження:");
        dao.addTwoProductsWithTransaction();

        System.out.println("\nЗавдання 5: Товари після транзакції:");
        dao.getAll().forEach(System.out::println);

        System.out.println("\nЗавдання 6: Всі товари перед оновленням:");
        dao.getAll().forEach(System.out::println);

        var products = dao.getAll();
        if (!products.isEmpty()) {
            Product p = products.get(0);
            p.setPrice(p.getPrice() + 10);
            dao.update(p);

            System.out.println("\nЗавдання 6: Всі товари після оновлення:");
            dao.getAll().forEach(System.out::println);

            dao.delete(p.getId());

            System.out.println("\nЗавдання 6: Всі товари після видалення першого:");
            dao.getAll().forEach(System.out::println);
        }
    }
}

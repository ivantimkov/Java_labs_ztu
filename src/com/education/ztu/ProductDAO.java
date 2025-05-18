package com.education.ztu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.education.ztu.DBUtil.getConnection;

public class ProductDAO extends AbstractDAO<Product> {

    // Завдання 3: створення таблиці та додавання 10 товарів через Statement
    public void createTableAndAddTenProducts() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS products (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL," +
                "brand VARCHAR(100) NOT NULL," +
                "category VARCHAR(100) NOT NULL," +
                "price DOUBLE NOT NULL" +
                ")";
        String[] products = {
                "INSERT INTO products (name, brand, category, price) VALUES ('Phone', 'Apple', 'Electronics', 999.99)",
                "INSERT INTO products (name, brand, category, price) VALUES ('Tablet', 'Samsung', 'Electronics', 499.99)",
                "INSERT INTO products (name, brand, category, price) VALUES ('Headphones', 'Sony', 'Accessories', 149.99)",
                "INSERT INTO products (name, brand, category, price) VALUES ('Camera', 'Canon', 'Electronics', 799.99)",
                "INSERT INTO products (name, brand, category, price) VALUES ('Printer', 'HP', 'Office', 199.99)",
                "INSERT INTO products (name, brand, category, price) VALUES ('Mouse', 'Logitech', 'Accessories', 29.99)",
                "INSERT INTO products (name, brand, category, price) VALUES ('Keyboard', 'Microsoft', 'Accessories', 59.99)",
                "INSERT INTO products (name, brand, category, price) VALUES ('Monitor', 'Dell', 'Electronics', 299.99)",
                "INSERT INTO products (name, brand, category, price) VALUES ('Router', 'TP-Link', 'Networking', 89.99)",
                "INSERT INTO products (name, brand, category, price) VALUES ('Smartwatch', 'Garmin', 'Wearables', 199.99)"
        };

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(createTableSQL);
            System.out.println("Таблиця products створена або вже існує.");

            for (String productInsert : products) {
                stmt.addBatch(productInsert);
            }
            int[] results = stmt.executeBatch();
            System.out.println("Додано товарів: " + results.length);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Завдання 4: видалення всіх товарів
    public void deleteAll() {
        String sql = "DELETE FROM products";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsDeleted = stmt.executeUpdate(sql);
            System.out.println("Видалено записів: " + rowsDeleted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Product p) {
        String sql = "INSERT INTO products (name, brand, category, price) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            ps.setString(2, p.getBrand());
            ps.setString(3, p.getCategory());
            ps.setDouble(4, p.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addFiveProducts() {
        String sql = "INSERT INTO products (name, brand, category, price) VALUES (?, ?, ?, ?)";
        Object[][] products = {
                {"Mouse", "Logitech", "Accessories", 29.99},
                {"Keyboard", "Razer", "Accessories", 89.99},
                {"Monitor", "Samsung", "Electronics", 199.99},
                {"Laptop", "HP", "Computers", 799.99},
                {"Smartwatch", "Xiaomi", "Wearables", 149.99}
        };

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (Object[] p : products) {
                pstmt.setString(1, (String)p[0]);
                pstmt.setString(2, (String)p[1]);
                pstmt.setString(3, (String)p[2]);
                pstmt.setDouble(4, (double)p[3]);
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            System.out.println("✅ 5 товарів додано через PreparedStatement.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product read(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Product(rs.getInt("id"), rs.getString("name"),
                        rs.getString("brand"), rs.getString("category"), rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void findByCategoryOrBrand(String keyword) {
        String sql = "SELECT * FROM products WHERE category = ? OR brand = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, keyword);
            pstmt.setString(2, keyword);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("🔍 Товари з категорії або бренду: " + keyword);
            while (rs.next()) {
                System.out.printf("%d | %s | %s | %s | %.2f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("brand"),
                        rs.getString("category"),
                        rs.getDouble("price")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product p) {
        String sql = "UPDATE products SET name = ?, brand = ?, category = ?, price = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            ps.setString(2, p.getBrand());
            ps.setString(3, p.getCategory());
            ps.setDouble(4, p.getPrice());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM products WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new Product(rs.getInt("id"), rs.getString("name"),
                        rs.getString("brand"), rs.getString("category"), rs.getDouble("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addTwoProductsWithTransaction() {
        String sql1 = "INSERT INTO products (name, brand, category, price) VALUES (?, ?, ?, ?)";
        String sqlWithError = "INSER INTO products (name, brand, category, price) VALUES (?, ?, ?, ?)"; // навмисна помилка

        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false);

            Savepoint sp = null;

            try (PreparedStatement ps1 = conn.prepareStatement(sql1);
                 PreparedStatement ps2 = conn.prepareStatement(sqlWithError)) {

                // Додаємо перший товар
                ps1.setString(1, "TestProduct1");
                ps1.setString(2, "TestBrand1");
                ps1.setString(3, "TestCategory1");
                ps1.setDouble(4, 123.45);
                ps1.executeUpdate();

                sp = conn.setSavepoint("Savepoint1");

                // Додаємо другий товар (з помилкою)
                ps2.setString(1, "TestProduct2");
                ps2.setString(2, "TestBrand2");
                ps2.setString(3, "TestCategory2");
                ps2.setDouble(4, 543.21);
                ps2.executeUpdate();

                conn.commit();

            } catch (SQLException e) {
                System.out.println("Помилка під час додавання другого товару: " + e.getMessage());
                if (sp != null) {
                    conn.rollback(sp);
                    conn.commit();
                } else {
                    conn.rollback();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

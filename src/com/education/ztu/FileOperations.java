package com.education.ztu;

import java.io.*;
import java.util.List;

public class FileOperations {
    public static void writeReport(List<Product> products, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Product product : products) {
                writer.write(product.toString() + "\n");
            }
            System.out.println("Звіт успішно записано.");
        } catch (IOException e) {
            System.out.println("Помилка запису: " + e.getMessage());
        }
    }

    public static void readReport(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Зміст звіту:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Помилка читання: " + e.getMessage());
        }
    }

    public static void copyTextFile(String sourcePath, String destPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Текстовий файл скопійовано.");
        } catch (IOException e) {
            System.out.println("Помилка копіювання текстового файлу: " + e.getMessage());
        }
    }

    public static void copyBinaryFile(String sourcePath, String destPath) {
        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destPath)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            System.out.println("Бінарний файл скопійовано.");
        } catch (IOException e) {
            System.out.println("Помилка копіювання бінарного файлу: " + e.getMessage());
        }
    }

    public static void modifyFile(String filePath, String content, long position) {
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            raf.seek(position);
            raf.writeBytes(content);
            System.out.println("Файл змінено на позиції " + position);
        } catch (IOException e) {
            System.out.println("Помилка модифікації файлу: " + e.getMessage());
        }
    }

    public static void fileOperations() {
        File dir = new File("directory_for_files/inner_directory");
        if (dir.mkdir()) {
            System.out.println("Папку створено: " + dir.getAbsolutePath());
        }

        System.out.println("Батьківська директорія: " + dir.getParent());

        try {
            File file1 = new File(dir, "file1.txt");
            File file2 = new File(dir, "file2.txt");
            file1.createNewFile();
            file2.createNewFile();

            file2.delete();
            System.out.println("Файл file2.txt видалено.");

            File renamedDir = new File("directory_for_files/renamed_inner_directory");
            dir.renameTo(renamedDir);
            System.out.println("Папку перейменовано.");

            File mainDir = new File("directory_for_files");
            File[] files = mainDir.listFiles();
            if (files != null) {
                for (File f : files) {
                    String type = f.isDirectory() ? "Папка" : "Файл";
                    System.out.println(type + ": " + f.getName() + " - " + f.length() + " байт");
                }
            }
        } catch (IOException e) {
            System.out.println("Помилка при роботі з файлами: " + e.getMessage());
        }
    }
}
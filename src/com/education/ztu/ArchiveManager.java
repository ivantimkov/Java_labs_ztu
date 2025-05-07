package com.education.ztu;

import java.io.*;
import java.util.zip.*;

public class ArchiveManager {

    // Створення ZIP архіву з усіма файлами в директорії
    public static void createZip(String sourceDirPath, String zipFilePath) {
        File dir = new File(sourceDirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Неправильна директорія для архівації.");
            return;
        }

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilePath))) {
            for (File file : dir.listFiles()) {
                if (file.isFile()) {
                    try (FileInputStream fis = new FileInputStream(file)) {
                        ZipEntry zipEntry = new ZipEntry(file.getName());
                        zos.putNextEntry(zipEntry);

                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = fis.read(buffer)) >= 0) {
                            zos.write(buffer, 0, length);
                        }

                        zos.closeEntry();
                    }
                }
            }
            System.out.println("Архів створено успішно.");
        } catch (IOException e) {
            System.out.println("Помилка під час створення архіву: " + e.getMessage());
        }
    }

    // Зчитування імен файлів з архіву
    public static void readZip(String zipFilePath) {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry;
            System.out.println("Файли в архіві:");
            while ((entry = zis.getNextEntry()) != null) {
                System.out.println("- " + entry.getName());
                zis.closeEntry();
            }
        } catch (IOException e) {
            System.out.println("Помилка при читанні архіву: " + e.getMessage());
        }
    }
}

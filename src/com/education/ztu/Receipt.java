package com.education.ztu;

import java.util.Formatter;

public class Receipt {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        formatter.format("Дата та час покупки: %1$td.%1$tm.%1$tY %1$tT\n", java.time.LocalDateTime.now());
        formatter.format("===========================================\n");
        formatter.format("%-3s %-10s %-15s %10s\n", "№", "Товар", "Категорія", "Ціна");
        formatter.format("===========================================\n");

        String[][] items = {
                {"1.", "Джинси", "Жіночий одяг", "1500,78 ₴"},
                {"2.", "Спідниця", "Жіночий одяг", "1000,56 ₴"},
                {"3.", "Краватка", "Чоловічий одяг", "500,78 ₴"},
                {"4.", "Футболка", "Чоловічий одяг", "399,99 ₴"},
                {"5.", "Пальто", "Жіночий одяг", "3200,00 ₴"},
                {"6.", "Сорочка", "Чоловічий одяг", "750,00 ₴"},
                {"7.", "Шкарпетки", "Чоловічий одяг", "50,00 ₴"},
                {"8.", "Сукня", "Жіночий одяг", "2000,00 ₴"},
                {"9.", "Шарф", "Жіночий одяг", "350,00 ₴"},
                {"10.", "Пояс", "Чоловічий одяг", "199,99 ₴"}
        };

        for (String[] item : items) {
            formatter.format("%-3s %-10s %-15s %10s\n", item[0], item[1], item[2], item[3]);
        }

        formatter.format("===========================================\n");
        formatter.format("Разом: %34s\n", "10051,10 ₴");

        System.out.println(formatter);
    }
}

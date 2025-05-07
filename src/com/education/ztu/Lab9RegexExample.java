package com.education.ztu;

import java.util.regex.*;

public class Lab9RegexExample {
    public static void main(String[] args) {
        String data =
                "ПІБ: Іванов Іван Іванович, Вік: 30, Посада: Менеджер, Дата народження: 20.05.1995, Email: ivanov@example.com, Телефон: +380501234567\n" +
                        "ПІБ: Петров Петро Петрович, Вік: 28, Посада: Аналітик, Дата народження: 11.11.1996, Email: petro.p@example.ua, Телефон: +380671112233\n" +
                        "ПІБ: Сидоренко Олена Юріївна, Вік: 35, Посада: HR, Дата народження: 03.03.1989, Email: s.olenka@work.org, Телефон: +380931234567\n" +
                        "ПІБ: Мельник Андрій Андрійович, Вік: 40, Посада: Технік, Дата народження: 15.07.1983, Email: andriy@tech.com, Телефон: +380661111111\n";

        System.out.println("== Emails ==");
        Matcher emailMatcher = Pattern.compile("[\\w.%-]+@[\\w.-]+\\.[A-Za-z]{2,6}").matcher(data);
        while (emailMatcher.find()) {
            System.out.println(emailMatcher.group());
        }

        System.out.println("\n== Phone Numbers ==");
        Matcher phoneMatcher = Pattern.compile("\\+\\d{12}").matcher(data);
        while (phoneMatcher.find()) {
            System.out.println(phoneMatcher.group());
        }

        System.out.println("\n== Дати народження (переформатовані) ==");
        Matcher dateMatcher = Pattern.compile("(\\d{2})\\.(\\d{2})\\.(\\d{4})").matcher(data);
        while (dateMatcher.find()) {
            String reformatted = dateMatcher.group(3) + "-" + dateMatcher.group(2) + "-" + dateMatcher.group(1);
            System.out.println("Original: " + dateMatcher.group() + " -> New: " + reformatted);
        }

        System.out.println("\n== Зміна посад ==");
        String updatedData = data.replaceAll("Менеджер", "Керівник").replaceAll("Технік", "Інженер");
        System.out.println(updatedData);
    }
}

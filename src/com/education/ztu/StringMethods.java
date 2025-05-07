package com.education.ztu;

public class StringMethods {
    public static void main(String[] args) {
        String text = "I learn Java!!!";

        System.out.println("Останній символ: " + text.charAt(text.length() - 1));
        System.out.println("Закінчується на '!!!': " + text.endsWith("!!!"));
        System.out.println("Починається з 'I learn ': " + text.startsWith("I learn "));
        System.out.println("Містить 'Java': " + text.contains("Java"));
        System.out.println("Позиція 'Java': " + text.indexOf("Java"));
        System.out.println("Замінити 'а' на 'о': " + text.replace('a', 'o'));
        System.out.println("Верхній регістр: " + text.toUpperCase());
        System.out.println("Нижній регістр: " + text.toLowerCase());
        System.out.println("Вирізати 'Java': " + text.substring(0, 8) + text.substring(12));
    }
}


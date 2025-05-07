package com.education.ztu;

import java.util.function.*;
import java.util.Arrays;

public class LambdaExamples {

    public static void main(String[] args) {
        // Завдання 2
        Printable printable = () -> System.out.println("Lambda: Hello from Printable!");
        printable.print();

        // Завдання 3a
        Predicate<String> isNumeric = str -> {
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };

        Predicate<String> isNotEmpty = str -> !str.isEmpty();
        Predicate<String> combined = isNumeric.and(isNotEmpty);

        System.out.println("123 is numeric and not empty: " + combined.test("123"));
        System.out.println("'' is numeric and not empty: " + combined.test(""));

        // Завдання 3b
        Consumer<String> lessonStart = s -> System.out.println("Пара почалася о 8:30");
        Consumer<String> lessonEnd = s -> System.out.println("Пара закінчилася о 9:50");
        lessonStart.andThen(lessonEnd).accept("Будь-який текст");

        // Завдання 3c
        Supplier<String> upperCaseSupplier = () -> "це приклад".toUpperCase();
        System.out.println("Uppercase: " + upperCaseSupplier.get());

        // Завдання 3d
        Function<String, Integer> productFunction = str -> {
            return Arrays.stream(str.split(" "))
                    .map(Integer::parseInt)
                    .reduce(1, (a, b) -> a * b);
        };
        System.out.println("Product: " + productFunction.apply("2 3 4"));
    }
}

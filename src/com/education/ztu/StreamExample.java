package com.education.ztu;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Comparator;

public class StreamExample {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Dell", 1200.0, 5),
                new Product("Phone", "Samsung", 800.0, 10),
                new Product("Tablet", "Apple", 900.0, 2),
                new Product("Monitor", "Dell", 300.0, 7),
                new Product("Keyboard", "Logitech", 50.0, 15)
        );

        // map — бренди
        System.out.println("Бренди:");
        products.stream()
                .map(Product::getBrand)
                .distinct()
                .forEach(System.out::println);

        // filter, limit — ціна < 1000
        System.out.println("\nТовари дешевші за 1000:");
        products.stream()
                .filter(p -> p.getPrice() < 1000)
                .limit(2)
                .forEach(System.out::println);

        // reduce — сума всіх товарів на складі
        int totalCount = products.stream()
                .map(Product::getCount)
                .reduce(0, Integer::sum);
        System.out.println("\nЗагальна кількість товарів: " + totalCount);

        // groupingBy — по бренду
        System.out.println("\nГрупування по бренду:");
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(Product::getBrand));
        grouped.forEach((brand, list) -> {
            System.out.println(brand + ":");
            list.forEach(System.out::println);
        });

        // sorted — за зростанням ціни
        System.out.println("\nВідсортовані за ціною:");
        Product[] sortedArray = products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .toArray(Product[]::new);
        Arrays.stream(sortedArray).forEach(System.out::println);
    }
}

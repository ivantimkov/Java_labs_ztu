package com.education.ztu;

import java.util.*;

public class OptionalExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList();
        Optional<Integer> max = numbers.stream().max(Integer::compare);

        String result = max.map(Object::toString).orElse("Числа відсутні");
        System.out.println("Максимальне значення: " + result);
    }
}

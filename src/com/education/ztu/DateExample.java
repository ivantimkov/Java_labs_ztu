package com.education.ztu;

import java.time.*;

public class DateExample {
    public static void main(String[] args) {
        LocalDateTime labStart = LocalDateTime.of(2025, 5, 2, 10, 0, 0);
        LocalDateTime now = LocalDateTime.now();

        System.out.println("День тижня: " + labStart.getDayOfWeek());
        System.out.println("День року: " + labStart.getDayOfYear());
        System.out.println("Місяць: " + labStart.getMonth());
        System.out.println("Рік: " + labStart.getYear());
        System.out.println("Час: " + labStart.getHour() + ":" + labStart.getMinute() + ":" + labStart.getSecond());

        System.out.println("Рік високосний: " + Year.isLeap(labStart.getYear()));
        System.out.println("Зараз: " + now);
        System.out.println("Після початку: " + now.isAfter(labStart));
        System.out.println("До початку: " + now.isBefore(labStart));

        LocalDateTime changed = labStart.plusDays(2).minusHours(3);
        System.out.println("Змінена дата: " + changed);
    }
}


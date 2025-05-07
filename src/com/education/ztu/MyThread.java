package com.education.ztu;

public class MyThread extends Thread {
    public MyThread() {
        System.out.println("Стан потоку: NEW");
    }

    @Override
    public void run() {
        System.out.println("Стан потоку: RUNNING");
        for (int i = 0; i < 100; i++) {
            System.out.println("Я люблю програмувати!!!");
        }
        System.out.println("Стан потоку: TERMINATED");
    }
}
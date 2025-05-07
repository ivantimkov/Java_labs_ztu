package com.education.ztu;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 10000; i++) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + ": Розрахунок завершено!!!");
                return;
            }
            if (i % 10 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
package com.education.ztu;

public class ArithmeticProgression implements Runnable {
    private static int result = 1;

    public synchronized void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print(result + " ");
            result++;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }
}
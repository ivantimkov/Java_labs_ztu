package com.education.ztu;

import java.util.Scanner;

public class ReaderPrinter {
    private String message;
    private final Object lock = new Object();

    class Reader extends Thread {
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                synchronized (lock) {
                    System.out.print("Введіть повідомлення (або 'exit'): ");
                    message = scanner.nextLine();
                    lock.notify();
                    if ("exit".equalsIgnoreCase(message)) break;
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class Printer extends Thread {
        public void run() {
            while (true) {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if ("exit".equalsIgnoreCase(message)) break;
                    System.out.println("Прочитано: " + message);
                    lock.notify();
                }
            }
        }
    }

    public void start() {
        new Reader().start();
        new Printer().start();
    }
}
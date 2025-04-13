package com.education.ztu;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість елементів: ");
        int n = scanner.nextInt();

        int[] fib = new int[n];
        int[] reversed = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1)
                fib[i] = 1;
            else
                fib[i] = fib[i - 1] + fib[i - 2];
        }

        for (int i = 0; i < n; i++) {
            reversed[i] = fib[n - 1 - i];
        }

        System.out.print("Фібоначчі: ");
        for (int val : fib)
            System.out.print(val + " ");

        System.out.print("\nОбернено: ");
        for (int val : reversed)
            System.out.print(val + " ");
        System.out.println();
    }
}

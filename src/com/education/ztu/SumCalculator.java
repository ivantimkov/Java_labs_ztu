package com.education.ztu;

import java.util.Random;
import java.util.concurrent.*;

public class SumCalculator {
    private static final int SIZE = 1_000_000;
    private static final int THREADS = 5;
    private static int[] numbers = new int[SIZE];

    static {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = random.nextInt(10);
        }
    }

    public static void calculateSingleThread() {
        long start = System.currentTimeMillis();
        long sum = 0;
        for (int number : numbers) sum += number;
        long end = System.currentTimeMillis();
        System.out.println("Однопотоково: сума = " + sum + ", час = " + (end - start) + " мс");
    }

    public static void calculateMultiThread() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        int chunkSize = SIZE / THREADS;
        Future<Long>[] results = new Future[THREADS];

        for (int i = 0; i < THREADS; i++) {
            int start = i * chunkSize;
            int end = (i == THREADS - 1) ? SIZE : start + chunkSize;
            results[i] = executor.submit(() -> {
                long localSum = 0;
                for (int j = start; j < end; j++) {
                    localSum += numbers[j];
                }
                return localSum;
            });
        }

        long totalSum = 0;
        long start = System.currentTimeMillis();
        for (Future<Long> future : results) totalSum += future.get();
        long end = System.currentTimeMillis();
        executor.shutdown();
        System.out.println("Багатопотоково: сума = " + totalSum + ", час = " + (end - start) + " мс");
    }
}
import com.education.ztu.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Завдання 2 ===");
        MyThread thread = new MyThread();
        System.out.println("Ім'я: " + thread.getName());
        System.out.println("Пріоритет: " + thread.getPriority());
        System.out.println("Живий: " + thread.isAlive());
        System.out.println("Демон: " + thread.isDaemon());

        thread.setName("MyCustomThread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        thread.join();

        System.out.println("Головний потік: " + Thread.currentThread().getName());
        System.out.println("Пріоритет: " + Thread.currentThread().getPriority());

        System.out.println("\n=== Завдання 3 ===");
        Thread t1 = new Thread(new MyRunnable(), "Thread-1");
        Thread t2 = new Thread(new MyRunnable(), "Thread-2");
        Thread t3 = new Thread(new MyRunnable(), "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(2000);
        t1.interrupt();
        t2.interrupt();
        t3.interrupt();

        System.out.println("\n=== Завдання 4-5 ===");
        ArithmeticProgression ap = new ArithmeticProgression();
        new Thread(ap).start();
        new Thread(ap).start();
        new Thread(ap).start();

        Thread.sleep(5000);

        System.out.println("\n=== Завдання 6 ===");
        ReaderPrinter rp = new ReaderPrinter();
        rp.start();

        System.out.println("\n=== Завдання 7 ===");
        SumCalculator.calculateSingleThread();
        SumCalculator.calculateMultiThread();
    }
}
package by.zloy.poc.concurrency;

public class ThreadSharedCounterSync {

    // статическая переменная, к которой обращаются оба потока
    private static volatile int sharedCounter = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                incrementCounter();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                incrementCounter();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final value of sharedCounter: " + sharedCounter);
    }

    // синхронизируемый метод, чтобы избежать гонки
    private static synchronized void incrementCounter() {
        sharedCounter++;
    }
}

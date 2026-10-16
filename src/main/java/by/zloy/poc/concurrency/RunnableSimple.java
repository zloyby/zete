package by.zloy.poc.concurrency;

public class RunnableSimple {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Привет из потока: " + Thread.currentThread().getName());
        };

        Thread thread1 = new Thread(task);
        thread1.start();
        //thread1.start(); // throws java.lang.IllegalThreadStateException
    }
}

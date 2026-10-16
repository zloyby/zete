package by.zloy.poc.concurrency;

public class VolatileHappensBefore {

    static class State {
        int a = 0;
        volatile boolean ready = false;
    }

    public static void main(String[] args) throws InterruptedException {
        State ref = new State();

        Thread t1 = new Thread(() -> {
            ref.a = 41;
            ref.a = 42; // with volatile - can be this
            ref.ready = true;
            ref.a = 43; // with volatile - or this, if race conditions
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 started with a = " + ref.a + " and ready = " + ref.ready);
            while (!ref.ready) {
                // without volatile - maybe printed [ 0; 41; 42; 43; nothing (case with optimization from compiler) ]
                System.out.println("Result when ready = false: " + ref.a);
                //System.exit(0);
            }
        });

        t2.start();
        Thread.sleep(5); // just to test when T2 was executed before T1
        t1.start();
        t1.join();
        t2.join();
        System.out.println("Exit with: " + ref.a);
    }
}

package by.zloy.poc.threads;

public class TestVolatileHappensBefore {

    public static void main(String[] args) throws InterruptedException {

        var ref = new Object() {
            // without volatile - maybe printed [ 0; 41; 42; 43; nothing (case with optimization from compiler) ]
            volatile boolean ready = false;
            int a = 0;
        };

        Thread t1 = new Thread(() -> {
            ref.a = 41;
            //System.out.println("Thread 1 started with a = " + ref.a);
            ref.a = 42; // with volatile - can be this
            ref.ready = true;
            for (int i = 0; i < 1000000000; i++) {
                 ref.a = ref.a + i;
            }
            ref.a = 43; // with volatile - or this, if race conditions
        });

        Thread t2 = new Thread(() -> {
            //System.out.println("Thread 2 started with a = " + ref.a);
            while (!ref.ready) {
                System.out.println(ref.a);
            }
        });

        t2.start();
        t1.start();
        //t1.sleep(1000);
        t1.join();
        t2.join();
    }
}

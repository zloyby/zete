package by.zloy.test.threads;

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class TestAtomicReference {

    private final AtomicReference<ObjectFromLongOperation> atomicReference;

    private TestAtomicReference() {
        atomicReference = new AtomicReference<>();
    }

    public static void main(String[] args) {
        TestAtomicReference testAtomicReference = new TestAtomicReference();
        new Thread(testAtomicReference::test).start();
        new Thread(testAtomicReference::test).start();
    }

    private void test() {
        ObjectFromLongOperation oauthToken = atomicReference.get();
        System.out.println(Thread.currentThread().getName() + "#1: " + (oauthToken == null ? "NULL" : oauthToken.getToken()));

        if (oauthToken == null) {
            System.out.println(Thread.currentThread().getName() + "#2: Before Long");
            atomicReference.compareAndSet(null, longOperation());
            System.out.println(Thread.currentThread().getName() + "#3: After Long");
        }

        oauthToken = atomicReference.get();
        System.out.println(Thread.currentThread().getName() + "#4: " + (oauthToken == null ? "NULL" : oauthToken.getToken()));
    }

    private ObjectFromLongOperation longOperation() {
        Random r = new Random();
        int random = r.nextInt(10000);
        //int random = by.zloy.utils.Random.getRandom(10000);
        System.out.println(Thread.currentThread().getName() + ". Random is " + random);
        try {
            Thread.sleep(random);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ObjectFromLongOperation(String.valueOf(random));
    }

    public class ObjectFromLongOperation {
        private String token;

        ObjectFromLongOperation(String token) {
            this.token = token;
        }

        String getToken() {
            return token;
        }
    }
}

/*
Thread-0#1: NULL
Thread-0#2: Before Long
Thread-1#1: NULL
Thread-1#2: Before Long
Thread-0. Random is 6147
Thread-1. Random is 9970
Thread-0#3: After Long
Thread-0#4: 6147
Thread-1#3: After Long
Thread-1#4: 6147

Thread-0#1: NULL
Thread-0#2: Before Long
Thread-1#1: NULL
Thread-1#2: Before Long
Thread-0. Random is 6219
Thread-1. Random is 4862
Thread-1#3: After Long
Thread-1#4: 4862
Thread-0#3: After Long
Thread-0#4: 4862
*/
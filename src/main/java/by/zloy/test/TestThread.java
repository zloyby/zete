package by.zloy.test;

public class TestThread {
    private Object o;

    public static void main(String[] args) {
        TestThread thread = new TestThread();
        thread.method();
    }

    public void method() {
        o = new Object();

        try {
            o.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

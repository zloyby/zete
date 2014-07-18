package by.zloy.test;

public class TestThread {
    public static void main(String[] args) {
        TestThread thread = new TestThread();
        thread.method();
    }

    private Object o;

    public void method() {
        o = new Object();

        try {
            o.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

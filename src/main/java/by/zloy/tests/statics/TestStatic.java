package by.zloy.tests.statics;

public class TestStatic {
    private final static ToCreateOne ONE = new ToCreateOne();

    public static void main(String[] args) {
        TestStatic ts1 = new TestStatic();
        ONE.print();

        TestStatic ts2 = new TestStatic();
        ONE.print();
    }
}

package by.zloy.tests.statics;

public class ToCreateOne {
    public ToCreateOne() {
        System.out.println("Created " + System.currentTimeMillis());
    }

    public void print() {
        System.out.println("Print " + this.toString());
    }
}

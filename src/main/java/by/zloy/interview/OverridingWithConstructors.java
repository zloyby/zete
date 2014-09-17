package by.zloy.interview;

public class OverridingWithConstructors {

    public static class A {
        public A() {
            System.out.println("Constructor A");
            func();
        }

        public void func() {
            System.out.println("Parent");
        }
    }

    public static class B extends A {
        public B() {
            System.out.println("Constructor B");
            func();
        }

        public void func() {
            System.out.println("Child");
        }
    }

    public static void main(String[] args) {
        A a = new B();
        a.func();
    }

}

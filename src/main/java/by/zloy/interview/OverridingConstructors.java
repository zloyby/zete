package by.zloy.interview;

public class OverridingConstructors {

    public static class A {
        public A() {
            System.out.println("Constructor A");
            f();
        }

        public void f() {
            System.out.println("Parent");
        }
    }

    public static class B extends A {
        public B() {
            System.out.println("Constructor B");
            f();
        }

        public void f() {
            System.out.println("Child");
        }
    }

    public static void main(String[] args) {
        A test = new B();
    }

}

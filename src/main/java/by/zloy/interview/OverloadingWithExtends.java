package by.zloy.interview;

public class OverloadingWithExtends {

    public static void main(String[] args) {
        A test = new B();
        test.f();
    }

    @SuppressWarnings("UnusedDeclaration")
    public static class A {
        Long defaultNumber;

        public A() {
            System.out.println("Constructor A");
            defaultNumber = 1L;
            f(defaultNumber);
        }

        protected void f() {
            System.out.println("Parent None " + defaultNumber);
        }

        void f(Number number) {
            System.out.println("Parent Number " + defaultNumber + " " + number);
        }

        private void f(Integer number) {
            System.out.println("Parent Integer " + defaultNumber + " " + number);
        }

        public void f(Long number) {
            System.out.println("Parent Long " + defaultNumber + " " + number);
        }
    }

    @SuppressWarnings("UnusedDeclaration")
    public static class B extends A {
        Integer defaultNumber;

        public B() {
            System.out.println("Constructor B");
            defaultNumber = 2;
            f(defaultNumber);
        }

        public void f() {
            System.out.println("Child None " + defaultNumber);
        }

        public void f(Number number) {
            System.out.println("Child Number " + defaultNumber + " " + number);
        }

        public void f(Integer number) {
            System.out.println("Child Integer " + defaultNumber + " " + number);
        }

        public void f(Long number) {
            System.out.println("Child Long " + defaultNumber + " " + number);
        }
    }
}

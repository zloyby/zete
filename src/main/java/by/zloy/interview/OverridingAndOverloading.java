package by.zloy.interview;

public class OverridingAndOverloading {

    public static void main(String[] args) {
        Parent obj = new Child();
        new Tester().test(obj);
    }

    public static class Parent {

        public void test() {
            System.out.println("parent::test");
        }
    }

    public static class Child extends Parent {

        public void test() {
            System.out.println("child::test");
        }
    }

    public static class Tester {

        public void test(Parent obj) {
            System.out.println("Testing parent...");
            obj.test();
        }

        public void test(Child obj) {
            System.out.println("Testing child...");
            obj.test();
        }
    }
}

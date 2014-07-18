package by.zloy.test;

/**
 * User: eugene
 * Date: 3/11/13
 * Time: 9:19 PM
 */
public class TestExtends {

    public static void main(String[] args) {
        TestExtends te = new TestExtends();
        te.test();
    }

    protected void test() {
        C c = new C();
        c.sout();
    }

    class A {
        protected String a = "A";
    }

    class B extends A {
        protected String b = "B";
        private String b2 = "B2";
    }

    class C extends B {
        public void sout() {
            System.out.println(a);
            System.out.println(b);
//            System.out.println(b2);
        }
    }
}

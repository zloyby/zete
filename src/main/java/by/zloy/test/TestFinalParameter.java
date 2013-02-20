package by.zloy.test;

/**
 * @author EugenKozlov
 */
public class TestFinalParameter {
    public static void main(String[] args) {
        TestFinalParameter testFinalParameter = new TestFinalParameter();
        testFinalParameter.run();
    }

    private void run() {
        StringParam test = new StringParam("default");
        System.out.println("1." + test.getT());
        change(test);
        System.out.println("2." + test.getT());
    }

    private void change(final StringParam test) {
        test.setT("changed");
    }

    private class StringParam {
        private String t;

        public StringParam(String t) {
            this.t = t;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }
    }
}

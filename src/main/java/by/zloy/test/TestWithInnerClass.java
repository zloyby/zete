package by.zloy.test;

public class TestWithInnerClass {

    public static void main(String[] args) {
        TestWithInnerClass outerClass = new TestWithInnerClass();
        TestWithInnerClass.InnerClass ic = outerClass.new InnerClass();

        TestWithInnerClass.StaticInnerClass sic = new TestWithInnerClass.StaticInnerClass();
    }

    //protected - create from children and from package Test* classes
    protected static class StaticInnerClass {

    }

    //public - I can create from another * classes, default - I can create from another Test* classes, and so on...
    private class InnerClass {

    }
}

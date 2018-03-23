package by.zloy.test.logicals;

/**
 * @author EugenKozlov
 */
public class TestOr {
    String z;

    public static void main(String[] args) {
        TestOr a = null;
        TestOr b = null;
        System.out.println(a != null | b.z == null);
        System.out.println(a != null || b.z == null);
    }
}

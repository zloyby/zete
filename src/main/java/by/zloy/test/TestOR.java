package by.zloy.test;

/**
 * @author EugenKozlov
 */
public class TestOR {
    String z;

    public static void main(String[] args) {
        TestOR a = null;
        TestOR b = null;
        System.out.println(a != null | b.z == null);
        System.out.println(a != null || b.z == null);
    }
}

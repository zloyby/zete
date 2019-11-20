package by.zloy.tests.strings;

/**
 * @author EugenKozlov
 */
public class TestStringSplit {
    public static void main(String[] args) {
        String s = "asd:zxc";
        String[] res = s.split(":");
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}

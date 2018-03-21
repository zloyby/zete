package by.zloy.test;

import java.util.regex.Pattern;

/**
 * User: eugene
 * Date: 4/19/13
 * Time: 1:09 PM
 */
public class TestRegexp {
    public final static Pattern NUMBER_PATTERN = Pattern.compile("[-+]?[0-9]*[\\,\\.]?[0-9]+");

    public static void main(String[] args) {
        System.out.println(NUMBER_PATTERN.matcher("1").matches());
        System.out.println(NUMBER_PATTERN.matcher("-1").matches());
        System.out.println(NUMBER_PATTERN.matcher("2.").matches());
        System.out.println(NUMBER_PATTERN.matcher("-2.").matches());
        System.out.println(NUMBER_PATTERN.matcher("2,").matches());
        System.out.println(NUMBER_PATTERN.matcher("-2,").matches());
        System.out.println(NUMBER_PATTERN.matcher("3,1415").matches());
        System.out.println(NUMBER_PATTERN.matcher("-3,1415").matches());

    }
}

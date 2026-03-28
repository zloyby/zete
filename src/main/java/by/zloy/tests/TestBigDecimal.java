package by.zloy.tests;

import java.math.BigDecimal;

public class TestBigDecimal {
    public static void main(String[] args) {

        String a = "2303.4250000000004";
        BigDecimal bd = new BigDecimal(a);
        System.out.println(a);
        System.out.println(bd.setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString());

        a = "2303.4240000000004";
        bd = new BigDecimal(a);
        System.out.println(a);
        System.out.println(bd.setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString());

        a = "2303.4248000000004";
        bd = new BigDecimal(a);
        System.out.println(a);
        System.out.println(bd.setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString());

        a = "2303.4250000000004";
        bd = new BigDecimal(a);
        System.out.println(a);
        System.out.println(bd.setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString());

        a = "2303.4249999999999";
        bd = new BigDecimal(a);
        System.out.println(a);
        System.out.println(bd.setScale(2, BigDecimal.ROUND_HALF_EVEN).toPlainString());

    }
}

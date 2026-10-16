package by.zloy.poc.core;

public class BigDecimal {
    public static void main(String[] args) {

        String a = "2303.4250000000004";
        java.math.BigDecimal bd = new java.math.BigDecimal(a);
        System.out.println(a);
        System.out.println(bd.setScale(2, java.math.BigDecimal.ROUND_HALF_EVEN).toPlainString());

        a = "2303.4240000000004";
        bd = new java.math.BigDecimal(a);
        System.out.println(a);
        System.out.println(bd.setScale(2, java.math.BigDecimal.ROUND_HALF_EVEN).toPlainString());

        a = "2303.4248000000004";
        bd = new java.math.BigDecimal(a);
        System.out.println(a);
        System.out.println(bd.setScale(2, java.math.BigDecimal.ROUND_HALF_EVEN).toPlainString());

        a = "2303.4250000000004";
        bd = new java.math.BigDecimal(a);
        System.out.println(a);
        System.out.println(bd.setScale(2, java.math.BigDecimal.ROUND_HALF_EVEN).toPlainString());

        a = "2303.4249999999999";
        bd = new java.math.BigDecimal(a);
        System.out.println(a);
        System.out.println(bd.setScale(2, java.math.BigDecimal.ROUND_HALF_EVEN).toPlainString());

    }
}

package by.zloy.test;

import java.math.BigDecimal;

public class TestIban {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("GB");
        builder.append("00");
        builder.append("CASH");
        builder.append("406080");
        builder.append("1557267");

        final String x = fixChecksum(builder.toString());
        System.out.println(x);
    }

    private static String fixChecksum(String ibanTemplate) {
        int remainder = checksum(ibanTemplate);
        String pp = padLeft(String.valueOf(98 - remainder), 2, '0');
        return ibanTemplate.substring(0, 2) + pp + ibanTemplate.substring(4);
    }

    private static int checksum(String iban) {
        String tmp = (iban.substring(4) + iban.substring(0, 4)).toUpperCase();
        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < tmp.length(); i++) {
            char c = tmp.charAt(i);
            if (c >= '0' && c <= '9') {
                digits.append(c);
            } else if (c >= 'A' && c <= 'Z') {
                int n = c - 'A' + 10;
                digits.append((char) ('0' + n / 10));
                digits.append((char) ('0' + (n % 10)));
            } else {
                return -1;
            }
        }
        BigDecimal n = new BigDecimal(digits.toString());
        return n.remainder(BigDecimal.valueOf(97)).intValue();
    }

    private static String padLeft(String input, int lenght, char pad) {
        StringBuilder result = new StringBuilder(input);
        while (result.length() < lenght) {
            result.insert(0, pad);
        }
        return result.toString();
    }


}

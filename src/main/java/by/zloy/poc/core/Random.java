package by.zloy.poc.core;

/**
 * @author EugenKozlov
 */
public class Random {
    public static void main(String[] args) {
        int max = 10;

        for (int i = -max; i < max; i++) {
            java.util.Random rnd = new java.util.Random();
            System.out.println(rnd.nextInt(max));
        }
    }
}

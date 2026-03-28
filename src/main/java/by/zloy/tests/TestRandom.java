package by.zloy.tests;

import java.util.Random;

/**
 * @author EugenKozlov
 */
public class TestRandom {
    public static void main(String[] args) {
        int max = 10;

        for (int i = -max; i < max; i++) {
            Random rnd = new Random();
            System.out.println(rnd.nextInt(max));
        }
    }
}

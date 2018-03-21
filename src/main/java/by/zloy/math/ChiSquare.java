package by.zloy.math;

import org.apache.commons.math3.stat.inference.TestUtils;

/**
 * The chi-squared test for independence between two categorical variables
 * uses a normal approximation to generate a p-value. The approximation
 * is appropriate when the expected value under independence is large
 * enough in each cell (say at least 5).
 */
public class ChiSquare {
    public static void main(String[] args) {

        long[][] longs = {{1, 9}, {11, 3}};
        double v = TestUtils.chiSquareTest(longs);
        System.out.printf("value: %.9f\n", v);

        double[] expected = {31, 69};
        long[] observed = {9, 91};
        double v2 = TestUtils.chiSquareTest(expected, observed);
        System.out.printf("value2: %.9f\n", v2);
    }
}

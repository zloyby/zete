package by.zloy.interview;

import java.util.Arrays;

public class TwoMaxNumbers {

    public static void main(String a[]) {
        int num[] = {5, 34, 78, 2, 45, 1, 99, 23};
        printTwoMaxNumbers1(num);
        printTwoMaxNumbers2(num);
    }

    public static void printTwoMaxNumbers1(int[] nums) {
        int maxOne = 0;
        int maxTwo = 0;
        for (int n : nums) {
            if (maxOne < n) {
                maxTwo = maxOne;
                maxOne = n;
            } else if (maxTwo < n) {
                maxTwo = n;
            }
        }
        System.out.println("First Max Number: " + maxOne);
        System.out.println("Second Max Number: " + maxTwo);
    }

    private static void printTwoMaxNumbers2(int[] num) {
        Arrays.sort(num);
        System.out.println("First Max Number: " + num[num.length - 1]);
        System.out.println("Second Max Number: " + num[num.length - 2]);
    }
}
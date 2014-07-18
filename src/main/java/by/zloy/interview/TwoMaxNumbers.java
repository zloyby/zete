package by.zloy.interview;

public class TwoMaxNumbers {

    public static void main(String a[]) {
        int num[] = {5, 34, 78, 2, 45, 1, 99, 23};
        printTwoMaxNumbers(num);
    }

    public static void printTwoMaxNumbers(int[] nums) {
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
}
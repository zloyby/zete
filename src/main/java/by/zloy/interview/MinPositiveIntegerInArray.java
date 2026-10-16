package by.zloy.interview;

import java.util.Arrays;

public class MinPositiveIntegerInArray {

    public static void main(String[] args) {
//        int[] testArray = {1, 3, 6, 4, 1, 2};
//        int[] testArray = {1, 2, 3};
//        int[] testArray = {-1, -3};
//        int[] testArray = {-1000000, 1, 1000000};
        int[] testArray = {0};
        MinPositiveIntegerInArray minPositiveIntegerInArray = new MinPositiveIntegerInArray();
        int result = minPositiveIntegerInArray.solution(testArray);
        System.out.println("Result: " + result);
    }

    public int solution(int[] A) {
        int i = 1;
        int[] positive = Arrays.stream(A).distinct().sorted().filter(a -> a > 0).toArray(); //1,3,5,...
        for (int k : positive) {
            if (k != i) {
                return i;
            } else {
                i++;
            }
        }
        return i;
    }
}

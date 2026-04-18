package by.zloy.interview;

import java.util.Arrays;

public class FindMinPositiveIntegerInArray {

    public int solution(int[] A) {
        // Implement your solution here
        int i = 1;
        int[] positive = Arrays.stream(A).distinct().sorted().filter(a -> a > 0).toArray(); //1,3,5,...
        for (int k : positive) {
            //System.out.println("COMPARE: " + k + " and " + i);
            if (k != i) {
                return i;
            } else {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
//        int[] testArray = {1, 3, 6, 4, 1, 2};
//        int[] testArray = {1, 2, 3};
//        int[] testArray = {-1, -3};
//        int[] testArray = {-1000000, 1, 1000000};
        int[] testArray = {0};
        FindMinPositiveIntegerInArray findMinPositiveIntegerInArray = new FindMinPositiveIntegerInArray();
        int result = findMinPositiveIntegerInArray.solution(testArray);
        System.out.println("Result: " + result);
    }
}

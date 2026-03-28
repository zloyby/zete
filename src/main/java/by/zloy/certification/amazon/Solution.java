package by.zloy.certification.amazon;

//import java.util.HashMap;
//import java.util.Map;
//import javafx.util.Pair;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 1, 3, 3, 3, 2, 3, 2, 1, 0};
//        int[] arr = new int[]{1,2,3,4,5};
//        int[] arr = new int[] { -1, -3 };
//        int[] arr = new int[] { 1, 3, 6, 4, 1, 2 };

//        int[] arr = new int[10000];
//        for (int i = 0; i < 10000; i++) {
//            arr[i] = 2;
//        }

        Solution s = new Solution();
        System.out.println(s.solution1(123456));
        System.out.println(s.solution2(arr, 2, 2));
        System.out.println(s.solution3(arr));
        System.out.println(s.solution3NotFinishedForTimeout(arr));
    }

    private int solution1(int A) {

        String all = Integer.toString(A);
        int length = all.length();
        if (length == 1) {
            return A;
        }
        char[] array = new char[length];
        for (int i = 0, j = 0; j < length; i++, j = j + 2) {
            char s = all.charAt(i);
            if (length - 1 - i == i) {
                array[j] = s;
            } else {
                char e = all.charAt(length - 1 - i);
                array[j] = s;
                array[j + 1] = e;
            }
        }

        return Integer.parseInt(new String(array));
    }

    private int solution2(int[] A, int K, int L) {
        //Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        int max = -1;
        for (int i = 0; i < A.length; i++) {
            int kSum = getSum(A, K, i);
            for (int j = 0; j < A.length; j++) {
                boolean isValidCoordinates = checkCoordinates(i, K + i, j, L + j, A.length);
                if (isValidCoordinates) {
                    int lSum = getSum(A, L, j);
                    //Pair<Integer, Integer> coordinates = new Pair<>(i, j);
                    //map.put(coordinates, kSum + lSum);
                    if (max < kSum + lSum) {
                        max = kSum + lSum;
                    }
                }
            }
        }
        return max;
    }

    private boolean checkCoordinates(int startK, int endK, int startL, int endL, int length) {
        if (endK - 1 > length || endL - 1 > length) {
            return false;
        }
        return startK > endL || startL > endK;
    }

    private int getSum(int[] A, int K, int i) {
        int sum = 0;
        for (int j = i; j < K + i; j++) {
            if (j > A.length - 1) {
                break;
            }
            sum = sum + A[j];
        }
        return sum;
    }

    private int solution3(int[] A) {
        int count = 0;
        for (int e = 3; e <= A.length; e++) {
            for (int i = 0; i <= A.length - e; i++) {
                if (checkVelocityIsEqualsInElements(Arrays.copyOfRange(A, i, i + e))) {
                    count++;
                }
            }
        }
        return count;
    }

    private int solution3NotFinishedForTimeout(int[] A) {
        int count = 0;
        int e = 3;
        for (int i = 0; i <= A.length - e; i++) {
            int[] copy = Arrays.copyOfRange(A, i, i + e);
            boolean isSameVelocity = checkVelocityIsEqualsInElements(copy);
            if (isSameVelocity) {
                count++;
                if (e < A.length) {
                    e++;
                    i--;
                } else {
                    e = 3;
                }
            } else {
                e = 3;
            }
        }
        return count;
    }

    private boolean checkVelocityIsEqualsInElements(int[] arr) {
        int defaultVelocity = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (defaultVelocity != (arr[i] - arr[i - 1])) {
                return false;
            }
        }
        return true;
    }
}

package by.zloy.certification.hackerrank;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.run();
    }

    private void run() {
        System.out.println("Starting...");
        int result = countPairs(new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }}, 2);
        System.out.println("Result: " + result);
    }

    public static int countPairs(List<Integer> arrayList, int diff) {
        int pairs = 0;
        for (Integer number : arrayList) {
            if (arrayList.contains(number + diff)) {
                pairs++;
            }
        }
        return pairs;

        /* Returns the number of pairs in array that differ by diff.
        See problem statement for description of algorithm.
        array: list of unique integers
        diff: integer, the targeted difference
        return: number of pairs realizing the difference */
//        Integer[] array = arrayList.toArray(new Integer[0]);
//        int pairs = 0;
//        int len = array.length;
//        int i = 0;
//        int j = 0;
//        while (j < len) {
//            for (; j < len; ++j) {
//                if (array[j] == array[i] + diff) {
//                    pairs++;
//
//
//                    return pairs;
//
//                }
//            }
//        }
//        return -1;
    }

}

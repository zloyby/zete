package by.zloy.interview;

import java.text.MessageFormat;
import java.util.HashMap;

/**
 * Нам дан массив целых чисел nums и число target. Нужно найти индексы двух чисел в массиве, сумма которых равна target.
 */
public class SumTwoElementsInArray {
    public static void main(String[] args) {
        int[] nums = {100, 2, 2, 7, 11, 15};
        int target = 4;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                System.out.println(MessageFormat.format("[{0}, {1}]", map.get(nums[i]), i));
            } else {
                map.put(target - nums[i], i);
            }
        }
    }
}

package by.zloy.interview;

import java.util.Arrays;

/**
 * Дан отсортированный массив целых чисел nums.
 * Нужно удалить дубликаты на месте (in-place) так, чтобы каждый уникальный элемент встречался только один раз.
 * Метод должен переставить уникальные элементы в начало массива и вернуть их количество k.
 * Дополнительную память выделять нельзя — сложность по памяти должна быть O(1).
 * Пример: nums = [0, 0, 1, 1, 1, 2, 2, 3]
 * Выход: k = 4, при этом первые 4 элемента массива должны быть [0, 1, 2, 3].
 */
public class FastSlowPointers {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3};
//        int[] nums = {0, 1, 1, 1, 1, 2, 2, 3};
//        int[] nums = {0, 0, 0, 1, 1, 2, 2, 3};
//        int[] nums = new int[0];
        System.out.println(removeDuplicatesFromSortedArray(nums));
    }

    private static int removeDuplicatesFromSortedArray(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if(nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }

        int[] ints = Arrays.copyOf(nums, slow + 1);
        System.out.println("Arrays.copyOf " + (slow + 1) + " elements : " + Arrays.toString(ints));
        return slow + 1;
    }
}

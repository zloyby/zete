package by.zloy.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * To solve Find Doubles, count the occurrences of each number using a frequency map or array.
 * For every element "x" in the list, verify if "2x" appears exactly once.
 * Диапазон чисел от 0 до 1000. Элементов в массиве =< 1_000_000.
 */
public class FindDoublesInArray {
    public static void main(String[] args) {
        System.out.println(findDoubles(List.of(0, 1, 2, 3, 4, 5))); // [0, 1, 2]
        System.out.println(findDoubles(List.of(1, 1, 2, 4, 4, 8))); // [1, 1, 4, 4]
    }

    public static List<Integer> findDoubles(List<Integer> nums) {
        // Диапазон чисел от 0 до 1000 (удвоенное максимум 2000)
        int[] freq = new int[2001];

        // 1. Заполняем массив частот
        for (int num : nums) {
            freq[num]++;
        }

        // 2. Отбираем элементы, для которых freq[num * 2] == 1
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (freq[num * 2] == 1) {
                result.add(num);
            }
        }

        // 3. Сортируем результат по возрастанию
        Collections.sort(result);

        return result;
    }
}

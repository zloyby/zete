package by.zloy.interview;

import java.util.HashMap;

/**
 * Дан массив nums и число k. Нужно найти количество непустых подмассивов, сумма элементов которых равна k.
 */
public class PrefixSum {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3, 4, 5}, 6));   // 1 = 1+6
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));         // 2 = 1+1; 1+1
        System.out.println(subarraySum(new int[]{1, 2, 1, 2, 1}, 3));   // 4 = 1+2; 2+1; 1+2; 2+1
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;

        // Хэш-мапа для хранения: <Префиксная_сумма, Количество_её_появлений>
        HashMap<Integer, Integer> prefixMap = new HashMap<>();

        // Базовый случай: префиксная сумма 0 встретилась 1 раз
        prefixMap.put(0, 1);

        for (int num : nums) {
            currentSum += num;

            // Если (currentSum - k) уже встречалась, добавляем её частоту к ответу
            int diff = currentSum - k;
            if (prefixMap.containsKey(diff)) {
                count += prefixMap.get(diff);
            }

            // Сохраняем текущую префиксную сумму в мапу
            prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}

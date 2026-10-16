package by.zloy.interview;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

/**
 * Даны две строки: s1 и s2.
 * Напишите метод, который возвращает true, если строка s2 содержит в себе перестановку (анаграмму) строки s1.
 */
public class AnagramContains {

    public static void main(String[] args) {
        System.out.println(slidingWindowFixedSize("abd", "eaibdaooo")); //t
        System.out.println(slidingWindowFixedSize("abc", "eaidboaoo")); //f
    }

    private static boolean slidingWindowFixedSize(String s1, String s2) {
        // Мы используем только английские буквы, можно использовать [- 'a'] чтобы высчитать бакет
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // 1. Подготовка первого окна
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // 2. Проверка первого окна
        if (Arrays.equals(s1Count, s2Count)) return true;

        // 3. Сдвигаем окно по s2
        for (int i = s1.length(); i < s2.length(); i++) {
            // Добавляем новый символ (справа)
            s2Count[s2.charAt(i) - 'a']++;
            // Удаляем уходящий символ (слева)
            s2Count[s2.charAt(i - s1.length()) - 'a']--;

            // Проверяем сразу после обновления
            if (Arrays.equals(s1Count, s2Count)) return true;
        }

        return false;
    }

    // FAIL: s1 = "adc", s2 = "add" - containsAll вернет true
    // FAIL: containsAll(set2) вынуждена проходить по всем элементам очереди, что сложность O(N*L)
    private static boolean slidingWindowFixedSize2(String s1, String s2) {
        HashSet<Character> set = new HashSet<>();
        int length = s1.length();
        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }

        Queue<Character> set2 = new ArrayDeque<>(length);
        for (int i = 0; i < s2.length(); i++) {
            if (set2.size() >= length) {
                set2.poll();
            }
            set2.add(s2.charAt(i));
            if (set.containsAll(set2)) {
                return true;
            }
        }

        return false;
    }
}

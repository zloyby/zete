package by.zloy.interview;

import java.util.HashMap;

/**
 * Дана строка s. Найдите длину самой длинной подстроки без повторяющихся символов.
 */
public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        System.out.println(slidingWindow("")); // 0
        System.out.println(slidingWindow("abba")); // 2 ba
        System.out.println(slidingWindow("ababa")); // 2 ba
        System.out.println(slidingWindow("ababcc")); // 3 abc
        System.out.println(slidingWindow("abcabcdbb")); // 4 abcd
        System.out.println(slidingWindow("aaabcdeee")); // 5 abcde
    }

    private static int slidingWindow(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1); // abba - нужно max чтобы на последней 'a' не сдвигалось назад
            }
            map.put(c, right);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}

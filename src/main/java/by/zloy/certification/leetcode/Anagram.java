package by.zloy.certification.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        System.out.println(anagram.isAnagram("anagram", "naagmra")); //true
        System.out.println(anagram.isAnagram("anagramяяяффф", "naagmraфяфяфя")); //true
        System.out.println(anagram.isAnagram("cat", "tap")); //false
        System.out.println(anagram.isAnagram("ggii", "eekk")); //false (sum of bytes here is equals)
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arrayS = s.codePoints().sorted().toArray();
        //int[] array1 = s.chars().sorted().toArray();
        int[] arrayT = t.codePoints().sorted().toArray();
        //int[] array2 = t.chars().sorted().toArray();

        return Arrays.equals(arrayS, arrayT);
    }

    // fails with "яяя"
    public boolean isAnagram_UsingArrayOfUsedChars_WrongWithUnicode(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int j : freq) {
            if (j != 0) {
                return false;
            }
        }

        return true;
    }

    // fails as "ggii".codePoints.sum == "eekk".codePoints.sum
    public boolean isAnagram_WrongCodeSums(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        long sum1 = s.codePoints().mapToLong(Long::valueOf).sum();
        long sum2 = t.codePoints().mapToLong(Long::valueOf).sum();

        return sum1 == sum2;
    }
}

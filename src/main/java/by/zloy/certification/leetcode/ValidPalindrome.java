package by.zloy.certification.leetcode;

import java.util.stream.Collectors;

public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama")); //true
        System.out.println(validPalindrome.isPalindrome("race a car")); //false, as "raceacar" is not a palindrome
        System.out.println(validPalindrome.isPalindrome(" ")); //true
        System.out.println(validPalindrome.isPalindromeManual("A man, a plan, a canal: Panama")); //true
        System.out.println(validPalindrome.isPalindromeManual("race a car")); //false, as "raceacar" is not a palindrome
        System.out.println(validPalindrome.isPalindromeManual(" ")); //true
    }

    public boolean isPalindrome(String s) {
        String normalizedOriginal = s.toLowerCase().codePoints()
                .filter(ch -> (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
        StringBuilder sb = new StringBuilder(normalizedOriginal);
        return normalizedOriginal.contentEquals(sb.reverse());
    }

    public boolean isPalindromeManual(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while (start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst)) {
                start++;
            } else if (!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }
}

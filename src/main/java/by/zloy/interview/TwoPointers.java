package by.zloy.interview;

/**
 * Дана строка s. Нужно определить, является ли она палиндромом (читается одинаково слева направо и справа налево).
 * Условие с подвохом: учитываются только буквы и цифры, а регистр символов не имеет значения (пробелы и знаки препинания игнорируются).
 * Пример:
 * Вход: s = "A man, a plan, a canal: Panama"
 * Выход: true (после очистки от знаков и приведения к нижнему регистру получаем "amanaplanacanalpanama")
 */
public class TwoPointers {
    public static void main(String[] args) {
        var s = "A man, a plan, a canal: Panama";
//        var s = ".,, !!";
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {
        int length = s.length();
        int left = 0;
        int right = length - 1;
        while (left < right) {
            if (isInvalidChar(s, left)) {
                left++;
                continue;
            }
            if (isInvalidChar(s, right)) {
                right--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    private static boolean isInvalidChar(String s, int i) {
        return !Character.isLetterOrDigit(s.charAt(i));
    }
}

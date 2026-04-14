package by.zloy.interview;

import com.google.common.base.CharMatcher;
import org.junit.platform.commons.annotation.Testable;

import java.util.*;

public class BalancedBrackets {

    /**
     * Write a method that checks whether a given string contains balanced brackets.
     * The string may include the following bracket types: (), [], {}, <>.
     * Requirements:
     *   Return true if all brackets are correctly balanced and properly nested.
     *   Return false otherwise. Examples:
     *      ()[]{} == true
     *      ([]) == true
     *      ([)] == false
     */

    @Testable
    public static boolean isBalancedRecursion(String s) {
        CharMatcher matcher = CharMatcher.anyOf("()[]{}<>");
        String resultWithBrackets = matcher.retainFrom(s);
        String afterRemoval = removePairs(resultWithBrackets);
        return afterRemoval.isBlank();
    }

    // Recursively remove matching bracket pairs
    private static String removePairs(String s) {
        String cleaned = s.replace("()", "")
                .replace("[]", "")
                .replace("{}", "")
                .replace("<>", "");
        return cleaned.equals(s) ? cleaned : removePairs(cleaned);
    }

    // The most efficient and industry-standard solution uses a Stack (O(n) time, O(n) space).
    // This is better than the recursive pair-removal approach (O(n²))
    @Testable
    public static boolean isBalanced(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> pairs = Map.of(
                ')', '(', ']', '[', '}', '{', '>', '<'
        );

        for (char c : str.toCharArray()) {
            if (pairs.containsValue(c)) {
                stack.push(c);
            } else if (pairs.containsKey(c)) {
                if (stack.isEmpty() || !stack.pop().equals(pairs.get(c))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    @Testable
    public static boolean isBalancedWithHashMap(String s) {
        // Create hashmap to store the pairs...
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        map.put('>', '<');
        // Create stack data structure...
        Stack<Character> stack = new Stack<>();
        CharMatcher matcher = CharMatcher.anyOf("()[]{}<>");
        String str = matcher.retainFrom(s);
        // Traverse each character in input string...
        for (int i = 0; i < str.length(); i++) {
            // If open parentheses are present, push it to stack...
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '<') {
                stack.push(str.charAt(i));
                continue;
            }
            // If the character is closing parentheses, check that the same type opening parentheses is being pushed to the stack or not...
            // If not, we need to return false...
            if (stack.isEmpty() || map.get(str.charAt(i)) != stack.pop()) {
                return false;
            }
        }
        // If the stack is empty, return true...
        return stack.isEmpty();
    }
}

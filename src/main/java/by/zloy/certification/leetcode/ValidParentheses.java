package by.zloy.certification.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("({})[[[]]]{()}")); // true
        System.out.println(validParentheses.isValid("()[]{}")); // true
        System.out.println(validParentheses.isValid("([)]")); // false
        System.out.println(validParentheses.isValid("}[()]{")); // false
        System.out.println(validParentheses.isValid_HashMap("({})[[[]]]{()}")); // true
        System.out.println(validParentheses.isValid_HashMap("()[]{}")); // true
        System.out.println(validParentheses.isValid_HashMap("([)]")); // false
        System.out.println(validParentheses.isValid_HashMap("}[()]{")); // false
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        List<Character> chars = s.chars().mapToObj(c -> (char) c).toList();
        for (Character c : chars) {
            if (stack.isEmpty()) { // put first to stack
                if (c.equals(')') || c.equals('}') || c.equals(']')) { // first element not valid
                    return false;
                }
                stack.push(c);
                continue;
            }

            Character peek = stack.peek();
            switch (c) {
                case '(', '{', '[':
                    stack.push(c);
                    break;
                case ')':
                    if (peek.equals('(')) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                    break;
                case '}':
                    if (peek.equals('{')) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                    break;
                case ']':
                    if (peek.equals('[')) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                    break;
            }
        }

        return stack.isEmpty();
    }

    public boolean isValid_HashMap(String s) {
        // Create hashmap to store the pairs...
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        // Create stack data structure...
        Stack<Character> stack = new Stack<>();
        // Traverse each charater in input string...
        for (int i = 0; i < s.length(); i++) {
            // If open parentheses are present, push it to stack...
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
                continue;
            }
            // If the character is closing parentheses, check that the same type opening parentheses is being pushed to the stack or not...
            // If not, we need to return false...
            if (stack.isEmpty() || map.get(s.charAt(i)) != stack.pop()) {
                return false;
            }
        }
        // If the stack is empty, return true...
        return stack.isEmpty();
    }
}

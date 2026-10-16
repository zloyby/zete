package by.zloy.interview;

import java.util.Arrays;
import java.util.Stack;

/**
 * Дан массив целых чисел nums. Для каждого элемента нужно найти первый элемент справа, который строго больше него.
 * Если такого элемента нет, записать -1.
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 4, 3}; // [4, 2, 4, -1, -1]
        System.out.println(Arrays.toString(runMonotonicStack(nums)));
    }

    private static int[] runMonotonicStack(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int top = stack.pop();
                result[top] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }
}

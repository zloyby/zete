package by.zloy.certification.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoSumsInArray {

    public static void main(String[] args) {
        TwoSumsInArray test = new TwoSumsInArray();
        int[] nums = {6, 2, 13, 2, 7, 11, 15};  // 9==2+7 : [1, 4] or [3, 4]
        System.out.println(Arrays.stream(test.twoSum_Two_For_With_Search_Value(nums, 9)).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(test.twoSum_Sorted_With_Saved_Index(nums, 9)).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(test.twoSum_HashMap(nums, 9)).boxed().collect(Collectors.toList()));
    }

    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public int[] twoSum_Two_For_With_Search_Value(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int search = target - first;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == search) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    // Time Complexity: O(n*log(n)) - because we sorting array
    // Space Complexity: O(n) - because we store additional array
    public int[] twoSum_Sorted_With_Saved_Index(int[] numbers, int target) {
        // Create a copy of the array with indices
        int[][] numbersWithIndices = new int[numbers.length][2];
        for (int i = 0; i < numbers.length; i++) {
            numbersWithIndices[i] = new int[]{numbers[i], i};
        }

        // Sort the array based on values
        Arrays.sort(numbersWithIndices, Comparator.comparingInt(a -> a[0]));

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbersWithIndices[left][0] + numbersWithIndices[right][0];
            if (sum == target) {
                return new int[]{numbersWithIndices[left][1], numbersWithIndices[right][1]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[0]; // Return empty array if no solution found
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int[] twoSum_HashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}

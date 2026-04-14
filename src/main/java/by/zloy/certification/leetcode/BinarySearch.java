package by.zloy.certification.leetcode;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(binarySearch.search(nums, 9)); // 4
        System.out.println(binarySearch.search(nums, 2)); // -1
        System.out.println(binarySearch.recursion(nums, 9, 0, nums.length)); // 4
        System.out.println(binarySearch.recursion(nums, 2, 0, nums.length)); // -1
    }

    public int recursion(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return recursion(nums, target, mid + 1, right);
        } else {
            return recursion(nums, target, left, mid - 1);
        }
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

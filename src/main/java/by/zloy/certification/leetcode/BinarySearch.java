package by.zloy.certification.leetcode;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(new int[]{-1, 0, 3, 5, 9, 12}, 9, 0, 6)); // 4
        System.out.println(binarySearch.search(new int[]{-1, 0, 3, 5, 9, 12}, 2, 0, 6)); // -1
        System.out.println(binarySearch.recursion(new int[]{-1, 0, 3, 5, 9, 12}, 9, 0, 6)); // 4
        System.out.println(binarySearch.recursion(new int[]{-1, 0, 3, 5, 9, 12}, 2, 0, 6)); // -1
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

    public int search(int[] nums, int target, int left, int right) {
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

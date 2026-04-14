package by.zloy.certification.leetcode;

import java.util.Arrays;

public class MedianOfTwoSortedArraysAfterMerge {

    public static void main(String[] args) {
        MedianOfTwoSortedArraysAfterMerge medianOfTwoSortedArraysAfterMerge = new MedianOfTwoSortedArraysAfterMerge();
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6}; // (3+4)/2=3.5
        System.out.println(medianOfTwoSortedArraysAfterMerge.findMedianSortedArrays(a, b));
        System.out.println(medianOfTwoSortedArraysAfterMerge.findMedianSortedArraysOptimized(a, b));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] a = Arrays.copyOf(nums1, m + n);
        System.arraycopy(nums2, 0, a, m, n);
        Arrays.sort(a);

        if (a.length % 2 == 0) {
            int mid1 = a.length / 2;
            int mid2 = a.length / 2 - 1;
            return (double) (a[mid1] + a[mid2]) / 2;
        } else {
            return a[a.length / 2];
        }
    }

    // FIXME: doesn't work with [{1, 2, 3}, {4, 5, 6, 7}] -> 4
    public double findMedianSortedArraysOptimized(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;

        if (m > n) { // small optimization
            return findMedianSortedArraysOptimized(nums2, nums1);
        }

        int left = (m + n + 1) / 2;
        int low = 0, high = m;

        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 < m)
                r1 = nums1[mid1];
            if (mid2 < n)
                r2 = nums2[mid2];
            if (mid1 - 1 >= 0)
                l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = nums2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                if (m + n % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0;
    }
}

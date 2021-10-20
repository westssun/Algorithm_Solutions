package SITE03_leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays
 */
public class M004_leetCode4_median_of_two_sorted_arrays_다른풀이 {
    private int lo, maxLen;

    public static void main(String[] args) {
        M004_leetCode4_median_of_two_sorted_arrays_다른풀이 solution = new M004_leetCode4_median_of_two_sorted_arrays_다른풀이();

        int[] a = new int[]{1, 2};
        int[] b = new int[]{3, 4};

        System.out.println(solution.findMedianSortedArrays(a, b));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length; // nums1 배열의 크기
        int n = nums2.length; // nums2 배열의 크기

        int k = (m + n) / 2; // 위 두 배열의 크기를 2로 나눈 값 (중간값)
        int i = 0;
        int j = k;
        int lo = 0;
        int hi = Math.min(k, m); // k 와 nums1 배열의 크기인 m 의 최소 값 저장

        while (true) {
            /* 각 원소를 비교할 인덱스 i, j */
            i = lo + (hi - lo) / 2;
            j = k - i;

            /* 원소의 크기 비교 */
            /* CASE1. nums1 의 원소가 더 클 경우 */
            if (get(nums1, i) >= get(nums2, j - 1)) {
                /* CASE2. nums2 의 원소가 더 클 경우 */
                if (get(nums2, j) >= get(nums1, i - 1)) {
                    break;
                } else {
                    hi = i - 1;
                }
            } else {
                lo = i + 1;
            }
        }

        /** 홀수일 경우 */
        if ((m + n) % 2 == 1) {
            return Math.min(get(nums1, i), get(nums2, j)); // odd
        }

        /** 짝수일 경우 */
        return (double)(Math.min(get(nums1, i), get(nums2, j))
                        + Math.max(get(nums1, i - 1), get(nums2, j - 1))) / 2; //even
    }

    private int get(int[] nums, int i) {
        /* 0 보다 작은 경우 */
        if (i < 0) {
            return Integer.MIN_VALUE;
        }

        /* i 가 매개변수 nums 의 길이보다 크거나 같으면 */
        if (i >= nums.length) {
            return Integer.MAX_VALUE;
        }

        /* nums 배열에서 i 번째의 값을 리턴 */
        return nums[i];
    }
}

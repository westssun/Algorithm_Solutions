package SITE03_leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays
 */
public class M004_leetCode4_median_of_two_sorted_arrays {
    private int lo, maxLen;

    public static void main(String[] args) {
        M004_leetCode4_median_of_two_sorted_arrays solution = new M004_leetCode4_median_of_two_sorted_arrays();

        int[] a = new int[]{2};
        int[] b = new int[]{};

        System.out.println(solution.findMedianSortedArrays(a, b));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergeArr = new int[nums1.length + nums2.length];
        double sum = 0;

        /* 합치기 */
        int index = 0;
        for (int j : nums1) {
            mergeArr[index] = j;
            index++;
        }

        for (int j : nums2) {
            mergeArr[index] = j;
            index++;
        }

        /* 정렬 */
        Arrays.sort(mergeArr);

        int division = 0;

        /* 가운데 인덱스 뽑기 */
        if (mergeArr.length % 2 == 0) { /* 짝수의 경우 */
            division = 2;
            int target = (mergeArr.length + 1) / 2;

            sum = mergeArr[target - 1] + mergeArr[target];
        } else { /* 홀수의 경우 */
            division = 1;
            int target = (mergeArr.length + 1) / 2;

            sum = mergeArr[target - 1];
        }

        return sum / division;
    }
}

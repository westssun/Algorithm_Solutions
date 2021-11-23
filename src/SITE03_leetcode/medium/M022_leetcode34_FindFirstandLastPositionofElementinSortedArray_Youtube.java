package SITE03_leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class M022_leetcode34_FindFirstandLastPositionofElementinSortedArray_Youtube {
    public static void main(String[] args) {
        M022_leetcode34_FindFirstandLastPositionofElementinSortedArray_Youtube solution = new M022_leetcode34_FindFirstandLastPositionofElementinSortedArray_Youtube();
        // int[] a = new int[]{5,1,5,3,2,2};
        // int[] a = new int[]{5,7,7,8,8,10};
        int[] a = new int[]{1, 1, 2};

        System.out.println(Arrays.toString(solution.searchRange(a, 1)));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];

        result[0] = findStartingIndex(nums, target);
        result[1] = findEndingIndex(nums, target);

        return result;
    }


    public int findStartingIndex(int[] nums, int target) {
        int index = -1;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int midpoint = start + (end - start) / 2;

            if (nums[midpoint] >= target) {
                end = midpoint - 1;
            } else {
                start = midpoint + 1;
            }

            if (nums[midpoint] == target) {
                index = midpoint;
            }
        }

        return index;
    }

    public int findEndingIndex(int[] nums, int target) {
        int index = -1;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int midpoint = start + (end - start) / 2;

            if (nums[midpoint] <= target) {
                start = midpoint + 1;
            } else {
                end = midpoint - 1;
            }

            if (nums[midpoint] == target) {
                index = midpoint;
            }
        }

        return index;
    }
}

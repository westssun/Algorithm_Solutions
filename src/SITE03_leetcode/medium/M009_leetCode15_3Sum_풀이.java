package SITE03_leetcode.medium;

import java.util.*;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/integer-to-roman/
 */
public class M009_leetCode15_3Sum_풀이 {
    public static void main(String[] args) {
        M009_leetCode15_3Sum_풀이 solution = new M009_leetCode15_3Sum_풀이();

        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        //System.out.println(solution.threeSum(new int[]{}));
        //System.out.println(solution.threeSum(new int[]{0}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        if (nums.length == 1) {
            return new ArrayList<>();
        }

        // 정렬
        int[] sorted = Arrays.stream(nums).sorted().toArray();

        for (int start = 0; start < sorted.length; start++) {
            int mid = start + 1;
            int end = nums.length - 1;

            while (mid < end) {
                if (sorted[start] + sorted[mid] + sorted[end] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(sorted[start]);
                    list.add(sorted[mid]);
                    list.add(sorted[end]);

                    Collections.sort(list); // 정렬
                    result.add(list);

                    end = end - 1;
                } else if (sorted[start] + sorted[mid] + sorted[end] < 0) {
                    mid = mid + 1;
                } else if (sorted[start] + sorted[mid] + sorted[end] > 0) {
                    end = end - 1;
                }
            }
        }


        return new ArrayList<>(result);
    }
}

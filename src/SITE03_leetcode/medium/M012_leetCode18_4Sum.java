package SITE03_leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/4sum/submissions/
 */
public class M012_leetCode18_4Sum {

    public static void main(String[] args) {
        M012_leetCode18_4Sum solution = new M012_leetCode18_4Sum();

        System.out.println(solution.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        //System.out.println(solution.fourSum(new int[]{-3, -1, 0, 2, 4, 5}, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> resultSet = new HashSet<>();

        Arrays.sort(nums);

        for (int start = 0; start < nums.length; start++) {
            int end = nums.length - 1;

            while (start < end) {
                // target 에서 뺀 값을 mid 안에서 구해야한다.
                int frontSum = target - (nums[start] + nums[end]);

                int midStart = start + 1;
                int midEnd = end - 1;

                while (midStart < midEnd) {
                    if (nums[midStart] + nums[midEnd] == frontSum) { // 같다면 add
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[start]);
                        list.add(nums[midStart]);
                        list.add(nums[midEnd]);
                        list.add(nums[end]);

                        Collections.sort(list); // 정렬
                        resultSet.add(list);

                        midEnd = midEnd - 1;
                    } else if (nums[midStart] + nums[midEnd] < frontSum) {
                        midStart = midStart + 1;
                    } else if (nums[midStart] + nums[midEnd] > frontSum) {
                        midEnd = midEnd - 1;
                    }
                }

                end = end - 1;
            }
        }

        return new ArrayList<>(resultSet);
    }
}

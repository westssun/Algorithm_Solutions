package SITE03_leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/integer-to-roman/
 */
public class M010_leetCode16_3Sum_Closet_풀이 {

    public static void main(String[] args) {
        M010_leetCode16_3Sum_Closet_풀이 solution = new M010_leetCode16_3Sum_Closet_풀이();

        //System.out.println(solution.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println(solution.threeSumClosest(new int[]{0,2,1,-3}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        // min 저장
        int closest = nums[0] + nums[1] + nums[2];

        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            int mid = start + 1;
            int end = nums.length - 1;

            while (mid < end) {
                sum = nums[start] + nums[mid] + nums[end];

                if (sum < target) { // sum < target 일때는 target 에 가까워지도록 mid + 1
                    mid = mid + 1;
                } else if (sum > target){
                    end = end - 1;
                } else { // 같다면 그대로 출력
                    return sum;
                }

                /* 더 작은 차이일 경우 변수 저장 */
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }
            }
        }

        return closest;
    }
}

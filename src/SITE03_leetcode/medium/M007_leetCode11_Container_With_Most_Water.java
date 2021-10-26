package SITE03_leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class M007_leetCode11_Container_With_Most_Water {

    public static void main(String[] args) {
        M007_leetCode11_Container_With_Most_Water solution = new M007_leetCode11_Container_With_Most_Water();

        System.out.println(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int result = 0;

        int[] dp = new int[height.length];

        int index = 0;

        int startIndex = 0; // start point
        int endIndex = height.length - 1; // end point

        while(index < height.length) {
            /* 더 작은 값이 곱해질 높이 */
            int min = height[endIndex];
            if (height[startIndex] < height[endIndex]) {
                min = height[startIndex];
            }

            /* dp 에 저장 */
            dp[index] = (endIndex - startIndex) * min;

            /** height[startIndex] 가 더 작으면 startIndex 를 +1 해야 더 큰 넓이를 구할 수 있다 */
            if (height[startIndex] < height[endIndex]) {
                startIndex = startIndex + 1;
            } else {
                endIndex = endIndex - 1;
            }

            index++;
        }

        /* max 구하기 */
        result = Arrays.stream(dp).max().getAsInt();
        return result;
    }
}

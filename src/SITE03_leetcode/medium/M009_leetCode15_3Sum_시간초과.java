package SITE03_leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/3Sum/
 */
public class M009_leetCode15_3Sum_시간초과 {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] map;
    static int n;
    static int size;

    public static void main(String[] args) {
        M009_leetCode15_3Sum_시간초과 solution = new M009_leetCode15_3Sum_시간초과();

        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        //System.out.println(solution.threeSum(new int[]{}));
        //System.out.println(solution.threeSum(new int[]{0}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        map = nums;
        n = map.length;
        visited = new boolean[n];

        dfs(0);

        return list;
    }

    public static void dfs(int index) {
        /* sum = 0 일 경우 */
        if (size == 3) {
            List<Integer> local = new ArrayList<>();
            int sum = 0; /* 합계는 0 이여야 한다 */

            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    local.add(map[i]);
                    sum += map[i];
                }
            }

            if (sum == 0) {
                Collections.sort(local); // 오름차순 정렬

                if (!list.contains(local)) {
                    list.add(local);
                }
            }
        }

        for (int i = index; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                size++;

                dfs(i);

                visited[i] = false;
                size--;
            }
        }
    }
}

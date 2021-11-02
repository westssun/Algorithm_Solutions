package SITE03_leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/integer-to-roman/
 */
public class M010_leetCode16_3Sum_Closet_시간초과 {
    static TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    static boolean[] visited;
    static int[] map;
    static int n;
    static int size;

    public static void main(String[] args) {
        M010_leetCode16_3Sum_Closet_시간초과 solution = new M010_leetCode16_3Sum_Closet_시간초과();

        //System.out.println(solution.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println(solution.threeSumClosest(new int[]{1,1,1,0}, -100));
    }

    public int threeSumClosest(int[] nums, int target) {
        map = nums;
        n = map.length;
        visited = new boolean[n];

        dfs(0);

        if (treeMap.size() == 1) {
            return treeMap.firstKey();
        }

        if (treeMap.ceilingKey(target) == null) {
            return treeMap.lastKey();
        }

        int result = 0;

        if (treeMap.floorKey(target) == null) {
            return treeMap.ceilingKey(target);
        }

        if (Math.abs(target - treeMap.ceilingKey(target)) < Math.abs(target - treeMap.floorKey(target))) {
            result = treeMap.ceilingKey(target);
        } else {
            result = treeMap.floorKey(target);
        }

        return result;
    }

    public void dfs(int index) {
        /* sum = 0 일 경우 */
        if (size == 3) {
            int sum = 0; /* 합계는 0 이여야 한다 */

            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sum += map[i];
                }
            }

            treeMap.put(sum, sum);
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

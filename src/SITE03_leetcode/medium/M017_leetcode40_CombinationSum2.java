package SITE03_leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class M017_leetcode40_CombinationSum2 {
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    int target;
    int[] map;
    boolean[] visited;

    public static void main(String[] args) {
        M017_leetcode40_CombinationSum2 solution = new M017_leetcode40_CombinationSum2();

        int[] dx = {10,1,2,7,6,1,5};

        System.out.println(solution.combinationSum2(dx, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        /* 정렬 */
        Arrays.sort(candidates);

        this.map = candidates;
        this.target = target;
        visited = new boolean[map.length];

        List<Integer> addList = new ArrayList<Integer>();
        dfs(addList, 0, 0);
        return resultList;
    }

    public void dfs(List<Integer> addList, int sum, int start) {
        // 탈출조건
        if (sum == target) {
            Collections.sort(addList);
            if (!resultList.contains(addList)) {
                resultList.add(new ArrayList<>(addList));
            }
        }

        // 구현
        for (int i = start; i < map.length; i++) {
            if (!visited[i]) {
                if (sum > target) {
                    break;
                }

                visited[i] = true;
                addList.add(map[i]);

                dfs(addList, sum + map[i], start + 1);

                visited[i] = false;
                addList.remove(addList.size() - 1);
            }
        }
    }
}
package SITE03_leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 */
public class M019_leetcode47_Permutations2 {
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    List<Integer> paramList = new ArrayList<>();
    int[] map;
    int n;
    boolean[] visited;

    public static void main(String[] args) {
        M019_leetcode47_Permutations2 solution = new M019_leetcode47_Permutations2();

        int[] dx = {1,1,2};
        //int[] dx = {0,1};

        System.out.println(solution.permuteUnique(dx));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.map = nums;
        n = nums.length;

        visited = new boolean[n];

        dfs(paramList);

        return resultList;
    }

    public void dfs(List<Integer> paramList) {
        // 탈출 조건
        if (paramList.size() == n) {
            if(!resultList.contains(paramList)) {
                resultList.add(new ArrayList<>(paramList));
                return;
            }
        }

        // 구현
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                paramList.add(map[i]);


                dfs(paramList);

                visited[i] = false;
                paramList.remove(paramList.size() - 1);
            }
        }
    }
}
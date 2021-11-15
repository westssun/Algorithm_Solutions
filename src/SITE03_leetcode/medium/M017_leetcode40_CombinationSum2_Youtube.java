package SITE03_leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class M017_leetcode40_CombinationSum2_Youtube {
    public static void main(String[] args) {
        M017_leetcode40_CombinationSum2_Youtube solution = new M017_leetcode40_CombinationSum2_Youtube();

        int[] dx = {1,3,2,1};

        System.out.println(solution.combinationSum2(dx, 3));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();

        if (candidates == null || candidates.length == 0) { // 예외검사
           return results;
        }

        // 정렬
        Arrays.sort(candidates); // 더 작은것부터 수행해야 탐색에 도움이 된다.

        // 중복 탐색하지 않을것, DFS (깊이우선탐색)
        List<Integer> combination = new ArrayList<>();
        toFindCombinationsToTarget(candidates, results, combination, 0, target);

        return results;
    }

    /**
     * DFS 구현
     * @param candidates 파라미터 배열
     * @param results 결과 리스트
     * @param combination 조합을 담을 리스트
     * @param startIndex 시작인덱스
     * @param target sum
     */
    private void toFindCombinationsToTarget(int[] candidates, List<List<Integer>> results, List<Integer> combination, int startIndex, int target) {
        // 탈출 조건
        if (target == 0) {
            results.add(new ArrayList<>(combination)); // 깊은복사로 추가
            return;
        }

        // 구현
        for (int i = startIndex; i < candidates.length; i++) {
            // 중복을 어떻게 확인할 수 있는가?
            // 검색을 수행하는 첫번째 인덱스가 아니고, 이전 값과 같으면 건너뛴다.
            // candidates[i] == candidates[i - 1]
            // 위 코드는, 이미 [1] 인 배열의 조합을 구한 완료상태일때, 그 다음에 다시 [1]이 나오면 패스해도 된다는 의미다.
            if (i != startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // target 보다 더 크다면 더이상 검색을 중지한다.
            if (candidates[i] > target) {
                break;
            }

            // 위 조건에 걸리지 않을경우 add
            combination.add(candidates[i]);
            toFindCombinationsToTarget(candidates, results, combination, i + 1, target - candidates[i]);

            // 완료시 이전으로 돌아간다.
            combination.remove(combination.size() - 1);
        }
    }
}
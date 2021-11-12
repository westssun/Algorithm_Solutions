package SITE03_leetcode.medium;

import SITE03_leetcode.common.ListNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class M016_leetcode39_CombinationSum {
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    int target;
    int[] map;

    public static void main(String[] args) {
        M016_leetcode39_CombinationSum solution = new M016_leetcode39_CombinationSum();

        int[] dx = {2,7,6,3,5,1};

        System.out.println(solution.combinationSum(dx, 9));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /* 정렬 */
        Arrays.sort(candidates);

        this.map = candidates;
        this.target = target;

        List<Integer> addList = new ArrayList<Integer>();
        dfs(0, 0, addList);
        return resultList;
    }

    public void dfs(int start, int sum, List<Integer> addList) {
        // 탈출조건
        if (sum == target) {
            resultList.add(new ArrayList<>(addList));
        }

        if (sum < target) {
            for (int i = start; i < map.length; i++) {
                sum = sum + map[i];

                if (sum > target) {
                    // 합계가 target 보다 커진다면 아웃
                    break;
                } else {
                    // 합계가 target 보다 작다면 실행
                    addList.add(map[i]);

                    dfs(i, sum, addList);

                    // 호출이 끝나면 다시 되돌리기
                    addList.remove(addList.size() - 1); // add 됬던 addList 제자리
                    sum = sum - map[i]; // 더해졌던 sum 제자리
                }
            }
        }
    }

//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Set<List<Integer>> resultSet = new HashSet<>();
//
//        // 정렬
//        Arrays.sort(candidates);
//
//        for (int i = 0; i < candidates.length; i++) {
//            int current = candidates[i];
//            int num = target / current; // target 이 최대 몇번 들어갈 수 있는지
//
//            // num 만큼 list add 실행
//            List<Integer> list = new ArrayList<>();
//
//            // 처음값이 target 맞춰질 경우 add
//            if (target % current == 0) {
//                list = IntStream.range(0, num).mapToObj(a -> current).collect(Collectors.toList());
//                resultSet.add(list);
//            }
//
//            int sum = num * current; // sum
//
//            while (num > 0) {
//                for (int j = i + 1; j < candidates.length; j++) {
//                    if (sum + candidates[j] < target) { // 작을때
//                        sum = sum + candidates[j];
//                    } else if (sum + candidates[j] == target) {
//                        // resultSet add
//                        list = IntStream.range(0, num).mapToObj(a -> current).collect(Collectors.toList());
//                        list.add(candidates[j]);
//                        resultSet.add(list);
//
//                        break;
//                    } else if (sum + candidates[j] > target) {
//                        break;
//                    }
//                }
//
//                num = num - 1;
//                sum = sum - num;
//            }
//        }
//
//        return new ArrayList<>(resultSet);
//    }
}
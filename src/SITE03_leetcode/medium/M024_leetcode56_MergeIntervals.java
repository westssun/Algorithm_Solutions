package SITE03_leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/group-anagrams/
 */
public class M024_leetcode56_MergeIntervals {
    public static void main(String[] args) {
        M024_leetcode56_MergeIntervals solution = new M024_leetcode56_MergeIntervals();
        int[][] a = new int[][] { {1,3}, {8,10}, {2,6}, {15,18} };

        System.out.println(Arrays.deepToString(solution.merge(a)));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        /* i[0] 기준으로 정렬 수행 */
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();

        /* 반복문 시작전 비교대상 0번째 배열 */
        int[] newInterval = intervals[0];
        result.add(newInterval);

        /* 비교 시작 */
        for (int[] interval : intervals) {
            /* 비교 대상의 arr[1] 과 타겟의 arr[0] 비교 */
            if (newInterval[1] >= interval[0]) { // merge 가능
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}

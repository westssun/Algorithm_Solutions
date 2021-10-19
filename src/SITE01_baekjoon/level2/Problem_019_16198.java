package SITE01_baekjoon.level2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/15658
 */
public class Problem_019_16198 {
    public static List<Integer> list;
    static int N; /* 열 개수 */
    static boolean[] visited; //스킵 판별
    static int resultSum = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 열 개수
        list = new ArrayList<>();
        visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        dfs(1); /* 맨 첫번째 요소 제외 */

        System.out.println(resultSum);
    }

    static void dfs(int value) {

        /* 종료 */
        if (list.size() == 2) {
            return;
        }

        int sum = 0;
        int sumIdx = 0;

        for (int i = value; i < list.size() - 1; i++) {
            int targetSum = list.get(i - 1) * list.get(i + 1);

            if (sum < targetSum) {
                sum = targetSum;
                sumIdx = i;
            } else if (sum == targetSum) {
                if (sumIdx > i) {
                    sumIdx = i;
                }
            }
        }

        /* 제거 */
        resultSum += sum;
        list.remove(sumIdx);

        dfs(1);

    }
}

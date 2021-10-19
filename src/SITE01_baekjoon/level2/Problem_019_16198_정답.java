package SITE01_baekjoon.level2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/15658
 */
public class Problem_019_16198_정답 {
    public static List<Integer> resultList = new ArrayList<>();
    static int N; /* 열 개수 */
    static boolean[] visited; //스킵 판별
    static int resultSum = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 열 개수
        visited = new boolean[N];

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        dfs(list, 0); /* 맨 첫번째 요소 제외 */

        System.out.println(resultList.stream()
                .mapToInt(x -> x)
                .max().getAsInt());
    }

    static void dfs(List<Integer> list, int sum) {

        /* 종료 */
        if (list.size() == 2) {
            if (resultSum < sum) {
                resultSum = sum;
            }

            resultList.add(resultSum);
            resultSum = 0;

            return;
        }

        for (int i = 1; i < list.size() - 1; i++) {
            int temp = list.get(i);
            int targetSum = list.get(i - 1) * list.get(i + 1);

            /* 제거 */
            list.remove(i);

            dfs(list, targetSum + sum);

            list.add(i, temp);
        }

    }
}

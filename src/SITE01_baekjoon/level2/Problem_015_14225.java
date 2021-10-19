package SITE01_baekjoon.level2;

import java.io.IOException;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/14225
 */
public class Problem_015_14225 {
    //static을 이용해 공유 변수를 만든다.
    static int N;
    static int S;
    static int[] arr;
    static Set<Integer> sumSet = new HashSet<>();
    static boolean[] visited; //스킵 판별

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String param = sc.nextLine();

        N = Integer.parseInt(param.split(" ")[0]);
        arr = new int[N];
        visited = new boolean[N];

        /* 집합 S */
        String S = sc.nextLine();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(S.split(" ")[i]);
        }

        dfs(0); /* dfs 호출 */

        List<Integer> sumList = new ArrayList<>(sumSet);
        Collections.sort(sumList); /* 정렬 */

        /* 1,2,3,4 순서일시 5를 담기 위한 설정 */
        int answer = sumList.get(sumList.size() - 1) + 1;
        /* 1보다 큰 수부터 시작일땐 무조건 1 설정 */
        int beforeVal = sumList.get(0);

        if (beforeVal > 1) {
            answer = 1;
        } else {
            /* answer 셋팅 */
            for (int i = 1; i < sumList.size(); i++) {
                if (beforeVal + 1 != sumList.get(i)) {
                    answer = beforeVal + 1;
                    break;
                }

                beforeVal = sumList.get(i);
            }
        }

        System.out.println(answer);
    }

    static void dfs(int value) {

        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (visited[i]) { /* true 일 경우 */
                sum += arr[i];
                /* Set으로 설정하여 중복값 제거 */
                sumSet.add(sum);
            }
        }

        /* 재귀함수 */
        for (int j = value; j < N; j++) {
            visited[j] = true;
            dfs(j + 1);

            visited[j] = false;
        }
    }
}

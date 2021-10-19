package SITE01_baekjoon.level2;

import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/9663
 */
public class Problem_020_9663 {
    static int[] arr;
    static int N = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 열 개수

        arr = new int[N];

        dfs(0);
        System.out.println(count);
    }

    static void dfs(int index) {
        if (index == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) { // 0, 1, 2, 3...
            arr[index] = i;

            /**
             * 결국, 여기서 전부 false 가 나와서 아래 if문을 타지 못하면 그 경우의수는 실패
             */
            if (Possibility(index)) { // if 문 만족시 다음 행
                /* true 라는 것은, 그 위치에 퀸을 둘 수 있다는 것으로, 그 다음 열로 넘어간다. */
                dfs(index + 1);
            }
        }
    }

    /**
     * 놓여질 수 없는 조건
     * @param col
     * @return
     */
    private static boolean Possibility(int col) {
        for (int i = 0; i < col; i++) {
            // 해당 열의 행과 i열의 행이 일치할경우 (같은 행에 존재할 경우)
            if (arr[col] == arr[i]) {
                return false;
            }
            /*
             * 대각선상에 놓여있는 경우
             * (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우다)
             */
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}

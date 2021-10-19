package SITE01_baekjoon.level2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/15658
 */
public class Problem_017_15658 {
    public static int[] arr;
    static int[] opArr;
    static int N; /* 열 개수 */
    public static ArrayList<Integer> resultList = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 열 개수
        arr = new int[N];
        opArr = new int[4];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < 4; i++) {
            opArr[i] = sc.nextInt();
        }

        dfs(1, arr[0]); // 출발 시작

        int max = resultList.stream()
                            .mapToInt(x -> x)
                            .max().getAsInt();

        int min = resultList.stream()
                            .mapToInt(x -> x)
                            .min().getAsInt();

        System.out.println(max); /* 최대값 */
        System.out.println(min); /* 최소값 */
    }

    static void dfs(int value, int sum) {

        for (int i = 0; i < 4; i++) {
            /* value 가 배열의 길이보다 커지는 시점엔 반복문 탈출 */
            if (value > arr.length - 1) {
                break;
            }

            if (opArr[i] != 0) {
                opArr[i]--; /* 연산자 사용 */

                if (i == 0) {
                    dfs(value + 1, sum + arr[value]);
                } else if (i == 1) {
                    dfs(value + 1, sum - arr[value]);
                } else if (i == 2) {
                    dfs(value + 1, sum * arr[value]);
                } else if (i == 3) {
                    dfs(value + 1, sum / arr[value]);
                }

                opArr[i]++; /* 다시 롤백 */
            }
        }

        if (value == N) { /* 식이 완성되었음 */
            resultList.add(sum);
        }
    }
}

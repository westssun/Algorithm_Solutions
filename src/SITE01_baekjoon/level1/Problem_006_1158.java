package SITE01_baekjoon.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1158
 */
public class Problem_006_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder("<");

        Queue<Integer> queue = new LinkedList<>();

        /* queue 에 담기 */
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int rm = 1; /* 위치 (poll 될 위치의 원소) */
        int index = k; /* index 는 +k만큼 증가 */

        while (!queue.isEmpty()) {
            if (rm == index) { /* index 에 도달했다면, poll() */
                Integer target = queue.poll();

                if (!queue.isEmpty()) {
                    sb.append(target).append(", ");
                } else { /* 마지막 원소 */
                    sb.append(target).append(">");
                }

                index = index + k;
            } else {
                /* 현재 차례의 queue 의 원소를 꺼내고, 다시 큐의 마지막에 offer */
                queue.offer(queue.poll());
            }

            rm++;
        }

        System.out.println(sb);
    }
}

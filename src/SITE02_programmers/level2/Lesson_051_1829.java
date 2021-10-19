package SITE02_programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/1829
 */

public class Lesson_051_1829 {
    static int graph[][];
    static boolean[][] visited;
    static int N;
    static int M;
    static int count = 0;

    public static void main(String[] args) {
        Lesson_051_1829 lesson = new Lesson_051_1829();

        int[][] a = new int[][] { {1,1,1,0}, {1,2,2,0}, {1,0,0,1}, {0,0,0,1}, {0,0,0,3}, {0,0,0,3}};
        System.out.println(Arrays.toString(lesson.solution(6, 4, a)));
    }

    public int[] solution(int m, int n, int[][] picture) {
        graph = picture;
        M = m;
        N = n;
         visited = new boolean[M][N];

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                count = 0;

                if (graph[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j);
                    numberOfArea++; /* 영역의 개수 */

                    list.add(count); /* 리스트에 결과 count 요소 add */
                }
            }
        }

        /* max 값 설정 */
        maxSizeOfOneArea = list.stream()
                .mapToInt(x -> x)
                .max().getAsInt();

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        count++; /* 같은 숫자의 개수 */

        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{1, 0, -1, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                /* 같은 색은 같은 구역으로 본다, count 가 증가되지 않는다 */
                if (graph[x][y] != 0 && graph[x][y] == graph[nx][ny]) {
                    if (!visited[nx][ny]) {
                        dfs(nx, ny);
                    }
                }
            }
        }
    }
}
package SITE01_baekjoon.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16197
 */
public class Problem_018_16197_다시 {
    static char[][] map;
    static int[][] coin; /* 2개의 동전의 위치 */
    static int n;
    static int m;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m]; // 세로 n, 가로 m
        coin = new int[2][2];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);

                /* 동전일 경우 동전의 위치를 따로 저장 */
                if (map[i][j] == 'o') {
                    /* (0, 0) (1, 0)*/
                    coin[cnt][0] = i;
                    /* (0, 1), (1, 1)*/
                    coin[cnt][1] = j;

                    cnt = cnt + 1;
                }
            }
        }

        for(char x[] : map) {
			System.out.println(Arrays.toString(x));
		}

		for(int x[] : coin) {
			System.out.println(Arrays.toString(x));
		}

        dfs(coin[0][0], coin[0][1], coin[1][0], coin[1][1], 0);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    private static void dfs(int x1, int y1, int x2, int y2, int depth) {
        // 10회 이상이면 리턴
        if(depth > 10) {
            return;
        }

        // 둘이 동시에 벗어나도 리턴
        if ((!isIn(x1, y1) && !isIn(x2, y2))) {
            return;
        }

        /** 조건 만족) 내부에 있고, 2개의 동전 중 1개는 아웃 */
        if ((isIn(x1, y1) && !isIn(x2, y2)) || (!isIn(x1, y1) && isIn(x2, y2))) {
            /* min 갱신 */
            if (min > depth) {
                min = depth;
            }

            return;
        }

        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{1, 0, -1, 0};

        for (int d = 0; d < 4; d++) {
            int nx1 = x1 + dx[d];
            int ny1 = y1 + dy[d];
            int nx2 = x2 + dx[d];
            int ny2 = y2 + dy[d];

            if(isIn(nx1, ny1) && map[nx1][ny1] == '#') { // 벽만나면 이동 못함 ㅠㅠ
                nx1 = x1;
                ny1 = y1;
            }
            if(isIn(nx2, ny2) && map[nx2][ny2] == '#') { // 벽만나면 이동 못함 ㅠㅠ
                nx2 = x2;
                ny2 = y2;
            }

            dfs(nx1, ny1, nx2, ny2, depth + 1);
        }
    }

    private static boolean isIn(int x, int y) {
        // 세로 n, 가로 m
        return (x >= 0 && y >= 0 && x < n && y < m);
    }
}

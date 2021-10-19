package SITE02_programmers.level2;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12905
 */

public class Lesson_042_12905 {
    public static void main(String[] args) {
        Lesson_042_12905 lesson = new Lesson_042_12905();

        int[][] a = new int[][] { {0,1,1,1}, {1,1,1,1}, {1,1,1,1}, {0,0,1,0}};
        System.out.println(lesson.solution(a));
    }

    public int solution(int[][] board)
    {
        int answer = 0;

        int[][] newBoard = new int[board.length + 1][board[0].length + 1];

        // 새로운 배열 생성
        for(int i=0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                newBoard[i + 1][j + 1] = board[i][j];
            }
        }

        int max = 0;

        // 만들 수 있는 정사각형 검사
        for(int i = 1; i < newBoard.length; i++){
            for(int j = 1; j < newBoard[i].length; j++){
                /* 2x2 사각형의 우측하단 꼭짓점을 기준으로 정사각형이 되는지 체크한다.
                 * 현재 값이 1인경우 좌←, 상↑, 좌상↖ 체크
                 * ←, ↑, ↖ 값이 모두 1인경우 정사각형을 만들 수 있음
                 */
                if (newBoard[i][j] == 1) {
                    int left = newBoard[i-1][j];    // 좌측 값
                    int up = newBoard[i][j-1];      // 상단 값
                    int leftUp = newBoard[i-1][j-1];// 좌측상단(대각선) 값

                    // 0이 있는지 체크 (min = 1 또는 0)
                    int min = Math.min(left, Math.min(up, leftUp));

                    // min = 0 또는 1 이므로 1 또는 2가 들어감
                    newBoard[i][j] = min + 1;

                    max = Math.max(max, min + 1);
                }
            }
        }
        answer = max * max;
        return answer;
    }
}
package SITE02_programmers.level2;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12913
 */

public class Lesson_039_12913 {
    public static void main(String[] args) {
        Lesson_039_12913 lesson = new Lesson_039_12913();

        int[][] a = new int[][] { {4,3,2,1}, {2,2,2,1}, {6,6,6,4}, {8,7,6,5}};
        System.out.println(lesson.solution(a));
    }

    public static int solution(int[][] land) {

        for(int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][1], Math.max(land[i-1][0], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }

        for(int i=0; i<land.length; i++){
            Arrays.sort(land[i]);
        }
        return land[land.length-1][3];
        // return Math.max(land[land.length-1][0], Math.max(land[land.length-1][1], Math.max(land[land.length-1][2], land[land.length-1][3])));
    }

    /**
     * 내가 문제를 보고 이해한 답은 맞지만, 문제 이해를 잘못함
     */
//    int solution(int[][] land) {
//        int answer = 0;
//
//        int target = land[0].length; // 이전 행의 최대값 찾기
//        int maxIndex = 0;
//
//        for (int i = 0; i < land.length; i++) {
//
//            int updateMax = Integer.MIN_VALUE; /* j 번째 update 될 max */
//
//            for (int j = 0; j < land[i].length; j++) {
//
//                // i 번째 열에서 최대값 찾기
//                if (target != j) { // 이전에 찾은 열과 같은 j 번째의 항목이 아니여야한다 (이전의 j : target)
//                    int currentMax = Math.max(updateMax, land[i][j]);
//
//                    if (updateMax != currentMax) {
//                        maxIndex = j;
//                        updateMax = currentMax;
//                    }
//                }
//            }
//
//            target = maxIndex; /* target 에 maxSum의 몇번째인지 */
//            answer += updateMax;
//        }
//
//        return answer;
//    }
}
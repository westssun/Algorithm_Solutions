package SITE04_etc.notion;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Code File Number : 00001
 */
public class Notion_00001 {
    public static void main(String[] args) {
        Notion_00001 lesson = new Notion_00001();

        int[][] a = new int[][] { {100,3}, {200,1}, {50,2} };
        int[][] b = new int[][] { {2500,3}, {700,5}};
        int[][] c = new int[][] { {1500,4}, {500,1}, {50,1}};
        System.out.println(lesson.solution(c));
    }

    public int solution(int[][] arr1) {
        int answer = 0;

        ArrayList<Integer> coinList = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i][1]; j++) { /* length : 2 */
                sum += arr1[i][0];
                coinList.add(arr1[i][0]);
            }
        }

        /* 내림차순 정렬 */
        coinList.sort(Collections.reverseOrder());
        System.out.println("coinList : " + coinList);
        System.out.println("sum : " + sum);

        /* 2명으로 나눴을때의 값 */
        int target = sum / 2;
        System.out.println("target : " + target);

        int sumA = 0; /* 조카 A */
        int sumB = 0; /* 조카 B */

        for (int i = 0; i < coinList.size(); i++) {
            /* target 보다 더한 값이 작을때 덧셈 실행 */
            if (target >= (sumA + coinList.get(i))) {
                sumA += coinList.get(i);
                coinList.set(i, 0); /* 사용했으므로 0으로 값 변경 */
            }
            /* 최대한의 모든 동전을 사용하여 target 가까이 가야한다 */
//            else {
//                System.out.println("sumB : " + sumB);
//                break;
//            }
        }

        for (int i = 0; i < coinList.size(); i++) {
            /* target 보다 더한 값이 작을때 덧셈 실행 */
            if (coinList.get(i) != 0) { /* 위 A 에서 사용되지 않을 경우 */
                if (target >= (sumB + coinList.get(i))) {
                    sumB += coinList.get(i);
                    coinList.set(i, 0); /* 사용했으므로 0으로 값 변경 */
                }
//                else {
//                    System.out.println("sumB : " + sumB);
//                    break;
//                }
            }
        }

        /* 남은 금액 계산 */
        int finalSum = 0;
        for (int i = 0; i < coinList.size(); i++) {
            if (coinList.get(i) != 0) { /* 위 A 에서 사용되지 않을 경우 */
                finalSum += coinList.get(i);
            }
        }

        System.out.println("finalSum : "  + finalSum);

        if (sumA > sumB) {
            answer = sumA - sumB;
        } else {
            answer = sumB - sumA;
        }

        System.out.println("finalSum - answer :"  + (finalSum - answer));
        return finalSum - answer;
    }
}

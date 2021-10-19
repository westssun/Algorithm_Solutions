package SITE02_programmers.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */

public class Lesson_048_42626_시간초과 {
    public static void main(String[] args) {
        Lesson_048_42626_시간초과 lesson = new Lesson_048_42626_시간초과();

        int[] a = new int[]{1,2,3};
        System.out.println(lesson.solution(a, 11));
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        /* Array to List */
        List<Integer> intList = Arrays.stream(scoville).boxed().collect(Collectors.toList());

        while(true) {
            /* 정렬 */
            Collections.sort(intList);

            /* 원소가 1개일 경우 */
            if (intList.size() == 1) {
                if (intList.get(0) >= K) { /* K보다 크거나 같다면 answer 리턴 */
                    return answer;
                } else { /* 그 외는 스코빌 지수를 K 이상으로 만들 수 없음으로 판단 */
                    return -1;
                }
            }

            /* 스코빌 지수 만족 */
            if (intList.get(0) >= K) {
                return answer;
            } else {
                int target = intList.get(0); /* 가장 작은 수 */
                int second = intList.get(1); /* 두번째로 작은 수 */

                int result = target + (second * 2);

                intList.remove(0); /* 가장 작은수 제거 */
                intList.remove(0); /* 가장 작은수 제거 후 0번째는 두번째로 작은 수 제거 */
                intList.add(result);

                answer++;
            }
        }

    }
}
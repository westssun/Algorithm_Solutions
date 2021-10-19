package SITE02_programmers.level2;

import java.util.PriorityQueue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */

public class Lesson_048_42626_우선순위큐 {
    public static void main(String[] args) {
        Lesson_048_42626_우선순위큐 lesson = new Lesson_048_42626_우선순위큐();

        int[] a = new int[]{1,2,3};
        System.out.println(lesson.solution(a, 11));
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        // PriorityQueue를 사용해서 숫자가 작을수록 우선순위를 가지게 저장
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int pri : scoville) {
            pq.offer(pri);
        }

        while(!pq.isEmpty()) {
            /* 원소가 1개일 경우 */
            if (pq.size() == 1) {
                if (pq.peek() >= K) { /* K보다 크거나 같다면 answer 리턴 */
                    return answer;
                } else { /* 그 외는 스코빌 지수를 K 이상으로 만들 수 없음으로 판단 */
                    return -1;
                }
            }

            /* 스코빌 지수 만족 */
            if (pq.peek() >= K) {
                return answer;
            } else {
                int target = pq.poll(); /* 가장 작은 수 */
                int second = pq.poll(); /* 두번째로 작은 수 */

                int result = target + (second * 2);

                pq.offer(result);

                answer++;
            }
        }

        return answer;
    }
}
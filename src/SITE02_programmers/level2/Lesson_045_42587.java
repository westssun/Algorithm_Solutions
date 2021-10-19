package SITE02_programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 */

public class Lesson_045_42587 {
    public static void main(String[] args) {
        Lesson_045_42587 lesson = new Lesson_045_42587();

        int[] a = new int[]{1, 1, 9, 1, 1, 1};
        System.out.println(lesson.solution(a, 0));
    }

    public int solution(int[] priorities, int location) {
        // PriorityQueue를 사용해서 숫자가 높을수록 우선순위를 가지게 저장
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int answer = 0;

        for (int pri : priorities) {
            pq.offer(pri);
        }

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;

                    if (location == i) {
                        pq.clear();
                        break;
                    }
                }
            }
        }
        return answer;
    }

//    public int solution(int[] priorities, int location) {
//        int answer = 0;
//
//        // Stack<Integer> stack = new Stack<>();
//        Queue<Integer> queue = new LinkedList<>();
//
//        int[] temp = new int[priorities.length];
//
//        for (int i = 0; i < priorities.length; i++) {
//            temp[i] = priorities[i];
//            int target = priorities[i];
//
//            for (int j = i; j < priorities.length; j++) {
//                /* 하나라도 큰게 있으면 */
//                if (target < priorities[j]) {
//                    priorities[i] = 0;
//                    queue.offer(target);
//
//                    break;
//                }
//            }
//        }
//
//        int[] result = new int[priorities.length];
//        int index = 0;
//        for (int priority : priorities) {
//            if (priority != 0) {
//                result[index] = priority;
//                index++;
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            result[index++] = queue.poll();
//        }
//
//        boolean isTest = false;
//
//        for (int i = 0; i < temp.length; i++) {
//            int target = temp[i];
//
//            for (int j = 0; j < result.length; j++) {
//                if (target == result[j]) {
//                    answer++;
//
//                    if (i == location) {
//                        isTest = true;
//                        break;
//                    }
//                }
//            }
//
//            if (isTest) {
//                break;
//            }
//        }
//
////        for (int i = 0; i < result.length; i++) {
////            int target = result[i];
////
////            for (int j = 0; j < temp.length; j++) {
////                if (target == temp[j]) {
////                    answer++;
////
////                    if (j == location) {
////                        isTest = true;
////                        break;
////                    }
////                }
////            }
////
////            if (isTest) {
////                break;
////            }
////        }
//
//        return answer;
//    }
}
package SITE02_programmers.level1;

/**
 * 소수찾기
 * https://programmers.co.kr/learn/courses/30/lessons/12921
 */
public class Lesson_020_12921 {
    public static void main(String[] args) {
        Lesson_020_12921 lesson = new Lesson_020_12921();
        System.out.println(lesson.solution(10));
    }

    public int solution(int n) {
        int answer = 1; /* 2는 무조건 소수 */

        for (int i = 3; i <= n; i += 2) {
            if (isPrimeNumber(i)) {
                answer += 1;
            }
        }

        return answer;
    }

    public static boolean isPrimeNumber(int target) {
        boolean result = true;

        for (int i = 3; i <= Math.sqrt(target); i += 2) {
            if (target % i == 0) {
                result = false;
                break;
            }
        }

        return result;
    }
}
package SITE02_programmers.level1;

/**
 * 약수의 합
 * https://programmers.co.kr/learn/courses/30/lessons/12928
 */
public class Lesson_016_12928 {
    public static void main(String[] args) {
        Lesson_016_12928 lesson = new Lesson_016_12928();
        System.out.println(lesson.solution(12));
    }

    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }

        return answer;
    }

//    public int solution(int n) {
//        int answer = 0;
//
//        for (int i = 1; i < n + 1; i++) {
//            if (n % i == 0) {
//                answer += (i + (n / i));
//            }
//        }
//
//        return answer / 2;
//    }
}
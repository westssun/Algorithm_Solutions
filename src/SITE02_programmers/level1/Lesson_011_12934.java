package SITE02_programmers.level1;

/**
 * 정수 제곱근 판별
 * https://programmers.co.kr/learn/courses/30/lessons/12934
 */
public class Lesson_011_12934 {
    public static void main(String[] args) {
        Lesson_011_12934 lesson = new Lesson_011_12934();
        System.out.println(lesson.solution(3));
    }

    public long solution(long n) {
        long answer = 0;

        long result = (long) Math.sqrt(n);
        long num = result + 1;

        if (result * result != n) {
            answer = -1;
        } else {
            answer = num * num;
        }

        return answer;
    }
}
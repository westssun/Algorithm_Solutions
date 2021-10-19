package SITE02_programmers.level2;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/62048
 */

public class Lesson_052_62048 {
    public static void main(String[] args) {
        Lesson_052_62048 lesson = new Lesson_052_62048();

        System.out.println(lesson.solution(8, 12));
    }

    public long solution(int w, int h) {
        long answer = 1;

        int gcd = gcd(w, h);

        /* (w + h - gcd) : 겹치는 도형 */
        /**
         * [(W/최대공약수) + (H/최대공약수) -1] == (w + h - gcd)
         */
        answer = (long) w * (long) h - (w + h - gcd);
        return answer;
    }

    static int gcd (int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
package SITE02_programmers.level2;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12953
 */

public class Lesson_032_12953 {
    public static void main(String[] args) {
        Lesson_032_12953 lesson = new Lesson_032_12953();
        int[] arr = new int[4];
        arr[0] = 2;
        arr[1] = 6;
        arr[2] = 8;
        arr[3] = 14;
        System.out.println(lesson.solution(arr));
    }

    public int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }

    /**
     * 최대공약수 구하는 함수
     * @param a
     * @param b
     * @return
     */
    static int gcd (int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    /**
     * 최대공배수 구하는 함수
     * @param a
     * @param b
     * @return
     */
    static int lcm(int a, int b) {
        return a * b / gcd(a,b);
    }
}
package SITE02_programmers.level2;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12911
 */

public class Lesson_040_12911 {
    public static void main(String[] args) {
        Lesson_040_12911 lesson = new Lesson_040_12911();

        System.out.println(lesson.solution(78));
    }

    public int solution(int n) {
        int answer = 0;

        String binaryString = Integer.toBinaryString(n); //2진수

        // 1 의 개수 세기
        int cnt = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                cnt += 1;
            }
        }

        System.out.println(cnt);

        int value = n + 1;
        while (true) {
            String valueString = Integer.toBinaryString(value); //2진수

            int valueCnt = 0;
            for (int i = 0; i < valueString.length(); i++) {
                if (valueString.charAt(i) == '1') {
                    valueCnt += 1;
                }
            }

            if (cnt == valueCnt) {
                answer = Integer.parseInt(valueString, 2);
                break;
            }

            value++;
        }
        return answer;
    }
}
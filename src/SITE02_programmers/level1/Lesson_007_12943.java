package SITE02_programmers.level1;

/**
 * 콜라츠 추측
 * https://programmers.co.kr/learn/courses/30/lessons/12940
 */
public class Lesson_007_12943 {
    public int solution(int num) {
        int answer = 0;

        long result = num;
        while (result != 1) {
            answer++;

            if (answer == 500) {
                answer = -1;
                break;
            }

            if (result % 2 == 0) {
                result = result / 2;
            } else {
                result = (result * 3) + 1;
            }
        }

        return answer;
    }
}
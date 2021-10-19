package SITE02_programmers.level1;

/**
 * 부족한 금액 계산하기
 * https://programmers.co.kr/learn/courses/30/lessons/82612
 */
public class Lesson_030_82612 {
    public long solution(int price, int money, int count) {
        long answer = -1;

        long sum = 0;
        for (int i = 1; i < count + 1; i++) {
            sum += (long) price * i;
        }

        if (sum > money) {
            answer = (sum - money);
        } else {
            answer = 0;
        }

        return answer;
    }
}
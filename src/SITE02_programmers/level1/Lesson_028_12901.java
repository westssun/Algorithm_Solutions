package SITE02_programmers.level1;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * 2016년
 * https://programmers.co.kr/learn/courses/30/lessons/12901
 */
public class Lesson_028_12901 {
    public static void main(String[] args) {
        Lesson_028_12901 lesson = new Lesson_028_12901();

        System.out.println(lesson.solution(5, 24));
    }

    public String solution(int a, int b) {
        String answer = "";

        // yyyy : 2016, mm : a, dd : b
        LocalDate localDate = LocalDate.of(2016, a, b);

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int dayOfWeekNumber = dayOfWeek.getValue(); // 월 ~ 일 (1 ~ 7)

        String[] arr = new String[]{"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        answer = arr[dayOfWeekNumber - 1];

        return answer;
    }
}
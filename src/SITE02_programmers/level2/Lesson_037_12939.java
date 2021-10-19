package SITE02_programmers.level2;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12939
 */

public class Lesson_037_12939 {
    public static void main(String[] args) {
        Lesson_037_12939 lesson = new Lesson_037_12939();

        System.out.println(lesson.solution("1 2 3 4"));
    }

    public String solution(String s) {
        String answer = "";

        String[] arr = s.split(" ");

        int min_value = Integer.MAX_VALUE;
        int max_value = Integer.MIN_VALUE;

        for (int j = 0; j < arr.length; j++) {
            min_value = Math.min(min_value, Integer.parseInt(arr[j]));
            max_value = Math.max(max_value, Integer.parseInt(arr[j]));
        }

        answer = min_value + " " + max_value;

        return answer;
    }
}
package SITE02_programmers.level1;

/**
 * 서울에서 김서방 찾기
 * https://programmers.co.kr/learn/courses/30/lessons/12919
 */
public class Lesson_021_12919 {
    public static void main(String[] args) {
        Lesson_021_12919 lesson = new Lesson_021_12919();

        String[] arr = new String[3];
        arr[0] = "Jane";
        arr[1] = "Kim";

        System.out.println(lesson.solution(arr));
    }

    public String solution(String[] seoul) {
        String answer = "";

        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                answer = "김서방은 " + i + "에 있다";
                break;
            }
        }

        return answer;
    }
}
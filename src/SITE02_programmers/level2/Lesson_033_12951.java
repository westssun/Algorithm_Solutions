package SITE02_programmers.level2;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12951
 */

public class Lesson_033_12951 {
    public static void main(String[] args) {
        Lesson_033_12951 lesson = new Lesson_033_12951();
        System.out.println(lesson.solution("3people unFollowed  me"));
    }

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        /* 첫번째 문자 여부 */
        boolean isFirst = true;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer.append(s.charAt(i));
                isFirst = true; /* 공백 다음엔 첫번째 문자 */
            } else {
                if (isFirst) { /* 첫번째 문자의 경우 */
                    answer.append(String.valueOf(s.charAt(i)).toUpperCase());
                    isFirst = false; /* 첫번째 문자가 아님 */
                } else {
                    answer.append(String.valueOf(s.charAt(i)).toLowerCase());
                }
            }
        }

        return answer.toString();
    }

//    public String solution(String s) {
//        StringBuilder answer = new StringBuilder();
//
//        String[] arr = s.split(" ");
//
//        for (String value : arr) {
//            char first = value.charAt(0);
//
//            answer.append(String.valueOf(first).toUpperCase()).append(value.substring(1).toLowerCase()).append(" ");
//        }
//
//
//        return answer.toString().trim();
//    }
}
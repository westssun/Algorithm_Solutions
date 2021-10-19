package SITE02_programmers.level1;

/**
 * 시저 암호
 * https://programmers.co.kr/learn/courses/30/lessons/12926
 */
public class Lesson_017_12926 {
    public static void main(String[] args) {
        Lesson_017_12926 lesson = new Lesson_017_12926();
        System.out.println(lesson.solution("AaZz", 25));
    }

    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            /* 1) 공백일 경우 */
            if (s.charAt(i) == ' ') {
                answer.append(' ');
            } else if ((65 <= s.charAt(i)) && (s.charAt(i) <= 90)) { /* 2) 대문자일 경우 */
                if (s.charAt(i) + n < 91) { /* 'Z' 이전 */
                    answer.append((char) (s.charAt(i) + n));
                } else { // 'Z'를 넘는 경우
                    answer.append((char) (s.charAt(i) +n - 26));
                }
            } else if ((97 <= s.charAt(i)) && (s.charAt(i) <= 122)) { /* 3) 소문자일 경우 */
                if (s.charAt(i) + n < 123) { /* 'z' 이전 */
                    answer.append((char) (s.charAt(i) + n));
                } else { // 'Z'를 넘는 경우
                    answer.append((char) (s.charAt(i) +n - 26));
                }
            }
        }

        return answer.toString();
    }
}
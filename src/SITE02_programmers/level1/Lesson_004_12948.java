package SITE02_programmers.level1;

/**
 * 핸드폰 번호 가리기
 * https://programmers.co.kr/learn/courses/30/lessons/12948
 */
public class Lesson_004_12948 {
    public String solution(String phone_number) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        sb.append(phone_number);

        for (int i = 0; i < phone_number.length() - 4; i++) {
            sb.replace(i, i + 1, "*");
        }

        answer = sb.toString();
        return answer;
    }

    /**
     * 다른 방법
     * @param phone_number
     * @return
     */
    public String solution2(String phone_number) {
        String answer = "";

        for(int i = 0 ; i < phone_number.length() - 4; i++){
            answer += "*";
        }

        answer += phone_number.substring(phone_number.length() - 4);

        return answer;
    }
}
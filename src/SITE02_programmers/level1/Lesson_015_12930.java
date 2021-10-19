package SITE02_programmers.level1;

/**
 * 이상한 문자 만들기
 * https://programmers.co.kr/learn/courses/30/lessons/12930
 */
public class Lesson_015_12930 {
    public static void main(String[] args) {
        Lesson_015_12930 lesson = new Lesson_015_12930();
        System.out.println(lesson.solution("try hello world"));
    }

    public String solution(String s) {
        String answer = getResult(s);
        return answer;
    }

    String getResult(String inputString) {
        /** -1 일 경우 공백도 포함하게 된다 */
        String[] array = inputString.split(" ", -1);

        for (int j = 0; j < array.length; j++) {
            String s = array[j];
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                String word = String.valueOf(s.charAt(i));

                if (i % 2 == 0) {
                    result.append(word.toUpperCase().charAt(0));
                } else {
                    result.append(word.toLowerCase().charAt(0));
                }
            }

            array[j] = result.toString();
        }

        return String.join(" ", array);
    }
}
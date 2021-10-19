package SITE02_programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 문자열 내 마음대로 정렬하기
 * https://programmers.co.kr/learn/courses/30/lessons/12915
 */
public class Lesson_025_12915 {
    public static void main(String[] args) {
        Lesson_025_12915 lesson = new Lesson_025_12915();

        String[] arr = new String[2];
        arr[0] = "sun";
        arr[1] = "yun";

        System.out.println(Arrays.toString(lesson.solution(arr, 1)));
    }

    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s1.charAt(n) + s1).compareTo(((s2.charAt(n)) + s2));
            }
        });

        for(int i = 0; i < strings.length; i++){
            answer[i] = strings[i];
        }

        return answer;
    }
}
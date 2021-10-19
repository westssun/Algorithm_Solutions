package SITE02_programmers.level1;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 문자열 내림차순으로 배치하기
 * https://programmers.co.kr/learn/courses/30/lessons/12917
 */
public class Lesson_023_12917 {
    public static void main(String[] args) {
        String result = solution("Zbcdefg");
        System.out.println(result);
    }

    public static String solution(String s) {
        return Stream.of(s.split("")) // 스트림 생성
                .sorted(Comparator.reverseOrder()) // 문자열 역순정렬
                .collect(Collectors.joining());
    }
}
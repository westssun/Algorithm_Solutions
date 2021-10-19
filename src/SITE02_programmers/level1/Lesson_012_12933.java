package SITE02_programmers.level1;

/**
 * 정수 내림차순으로 배치하기
 * https://programmers.co.kr/learn/courses/30/lessons/12933
 */
public class Lesson_012_12933 {
    public static void main(String[] args) {
        Lesson_012_12933 lesson = new Lesson_012_12933();
        System.out.println(lesson.solution(118372));
    }

    public long solution(long n) {
        long answer = 0;

        /* long n 을 String 타입 배열 변환 */
        String param = String.valueOf(n);
        String[] arr = param.split("");

        /* int 타입 배열 변환 */
        int[] intArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }

        /* 선택정렬 사용 */
        for (int i = 0; i < intArr.length; i++) {
            for (int j = i; j < intArr.length; j++) {
                if (intArr[i] < intArr[j]) {
                    int temp = intArr[i];
                    intArr[i] = intArr[j];
                    intArr[j] = temp;
                }
            }
        }

        StringBuilder s = new StringBuilder();
        for (int num : intArr) {
            s.append(String.valueOf(num));
        }

        return Long.parseLong(s.toString());
    }
}
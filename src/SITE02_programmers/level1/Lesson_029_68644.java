package SITE02_programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 두개 뽑아서 더하기
 * https://programmers.co.kr/learn/courses/30/lessons/68644
 */
public class Lesson_029_68644 {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (!list.contains(numbers[i] + numbers[j])) {
                    list.add(numbers[i] + numbers[j]);
                }
            }
        }

        int[] answer = new int[list.size()];

        int size = 0;
        for (Integer temp : list) {
            answer[size] = temp;
            size++;
        }

        Arrays.sort(answer);

        return answer;
    }
}
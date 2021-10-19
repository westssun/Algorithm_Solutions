package SITE02_programmers.level2;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 */

public class Lesson_050_42888 {
    public static void main(String[] args) {
        Lesson_050_42888 lesson = new Lesson_050_42888();

        String[] a = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(lesson.solution(a)));
    }

    public String[] solution(String[] record) {
        /* key: userId, value: 닉네임을 셋팅할 Map 선언 */
        Map<String, String> member = new HashMap<>();
        /* 최종적으로 출력을 위해 담을 queue */
        Queue<String> queue = new LinkedList<>();

        /* 파라미터 record 반복문 실행 */
        for (String target : record) {
            String[] targetArr = target.split(" ");
            String startWord = targetArr[0];

            /* 키워드에 따른 분기 처리 */
            if ("Enter".equals(startWord)) {
                member.put(targetArr[1], targetArr[2]);
                queue.offer(target);
            } else if ("Leave".equals(startWord)) {
                queue.offer(target);
            } else if ("Change".equals(startWord)) {
                /* 같은 key 일 경우 value change */
                member.put(targetArr[1], targetArr[2]);
            }
        }

        String[] answer = new String[queue.size()];
        int index = 0;

        /* queue 만큼 반복문 */
        while (!queue.isEmpty()) {
            String target = queue.poll();
            String[] targetArr = target.split(" ");
            String startWord = targetArr[0];

            /* 출력 */
            if ("Enter".equals(startWord)) {
                answer[index] = member.get(targetArr[1]) + "님이 들어왔습니다.";
            } else if ("Leave".equals(startWord)) {
                answer[index] = member.get(targetArr[1]) + "님이 나갔습니다.";
            }

            index++;
        }

        return answer;
    }
}
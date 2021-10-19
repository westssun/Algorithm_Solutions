package SITE02_programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12936
 */

public class Lesson_055_12936_참고 {
    public static void main(String[] args) {
        Lesson_055_12936_참고 lesson = new Lesson_055_12936_참고();

        System.out.println(Arrays.toString(lesson.solution(3, 5)));
    }

    public int[] solution(int n, long k) {
        ArrayList<Integer> arr = new ArrayList<>();

        int[] ans = new int[n];
        int fn = fact(n); /* n! = 6 */

        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }

        /* ans 는 0 부터 시작이므로, k - 1 셋팅 */
        k = k -1;

        int idx = 0;

        while (n > 0) {
            fn = fn / n; // 6 / 3 = 2

            int targetIdx = ((int) k / fn); // 4 / 2 = 2
            ans[idx] = arr.get(targetIdx);
            idx = idx + 1;

            arr.remove(targetIdx); /* 해당 값은 넣었으므로 삭제 */

            k = k % fn;
            n = n - 1;
        }

        return ans;
    }

    public static int fact(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fact(n-1) * n;
        }
    }
}
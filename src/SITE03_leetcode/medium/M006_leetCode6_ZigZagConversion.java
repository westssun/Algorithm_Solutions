package SITE03_leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class M006_leetCode6_ZigZagConversion {
    private int lo, maxLen;

    public static void main(String[] args) {
        M006_leetCode6_ZigZagConversion solution = new M006_leetCode6_ZigZagConversion();

        System.out.println(solution.convert("PAYPALISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder();

        if (numRows == 1) { /* 1 일땐 문자열 그대로 */
            return s;
        }

        /* String to Array */
        String[] arr = s.split("");
        int[] dp = new int[arr.length];

        int index = 0; // 0,1,2,3,2,1,0,1,2,3,2,1,0,1
        boolean isAdded = true;
        int value = 0;

        /* dp array setting */
        while (index < arr.length) {
            dp[index] = value;

            if (value + 1 == numRows) { // value가 최대치면 뺄셈
                isAdded = false;
            } else if (value == 0) { // value 가 0이면 덧셈
                isAdded = true;
            }

            if (!isAdded) {
                value = value - 1;
            } else {
                value = value + 1;
            }

            index++;
        }

        int order = 0;
        while (order < numRows) {
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] == order) { // 0, 1, 2 순으로 찾아서 문자열 append
                    result.append(arr[i]);
                }
            }

            order++;
        }

        return result.toString();
    }
}

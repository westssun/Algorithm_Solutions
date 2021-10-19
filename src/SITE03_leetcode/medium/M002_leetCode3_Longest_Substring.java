package SITE03_leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class M002_leetCode3_Longest_Substring {
    ListNode resultNode = new ListNode();

    public static void main(String[] args) {
        M002_leetCode3_Longest_Substring solution = new M002_leetCode3_Longest_Substring();
        //System.out.println(solution.lengthOfLongestSubstring("dvdf"));
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        /* 중복 데이터가 들어가지않는 Set 사용 */
        Set<Character> set = new HashSet<Character>();
        int size = s.length();

        int start = 0;
        int end = 0;

        int[] dp = new int[size];

        while (end < size) {
            if (set.contains(s.charAt(end))) { /* 현재 target 이 이미 담겨져있을 경우 */
                set.remove(s.charAt(start)); /* start 지점의 문자 제거 */
                start = start + 1;
            } else { /* 새로운 문자의 경우 */
                set.add(s.charAt(end)); /* Set 에 문자를 담고 */
                end = end + 1; /* target 을 그 다음으로 넘기고 */
                dp[end - 1] = end - start; /* end - start (현재의 문자열 개수) 를 dp 에 담는다 */
            }
        }

        return Arrays.stream(dp).max().getAsInt(); /* 최대값 추출 */
    }

//    public int lengthOfLongestSubstring(String s) {
//        int size = s.length();
//
//        if (size == 0) {
//            return 0;
//        }
//
//        int[] dp = new int[size];
//
//        int start = 0;
//        int end = 0;
//
//        dp[0] = 1;
//
//        List<Character> chars = new ArrayList<>();
//        chars.add(s.charAt(0));
//
//        for (int i = 1; i < size; i++) {
//            if (chars.contains(s.charAt(i))) {
//                start = start + 1;
//                end = end + 1;
//            } else {
//                chars.add(s.charAt(i));
//                end = end + 1;
//            }
//
//            dp[i] = end - start + 1;
//        }
//
//        return Arrays.stream(dp).max().getAsInt();
//    }

//    public int lengthOfLongestSubstring(String s) {
//        int size = s.length();
//
//        if (size == 0) {
//            return 0;
//        }
//
//        int[] dp = new int[size];
//
//        int length = 0;
//        List<Character> chars = new ArrayList<>();
//        for (int i = 0; i < size; i++) {
//            char target = s.charAt(i);
//
//            if (chars.size() != 0 && chars.contains(target)) {
//                length = 1;
//                dp[i] = length;
//            } else {
//                chars.add(target);
//                length++;
//
//                dp[i] = length;
//            }
//        }
//
//        return Arrays.stream(dp).max().getAsInt();
//    }
}

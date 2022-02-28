package SITE03_leetcode.easy;

import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/implement-strstr/
 */
public class E005_leetCode28_ImplementStr {
    public static void main(String[] args) {
        E005_leetCode28_ImplementStr solution = new E005_leetCode28_ImplementStr();

        System.out.println(solution.strStr("hello", "ll"));
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

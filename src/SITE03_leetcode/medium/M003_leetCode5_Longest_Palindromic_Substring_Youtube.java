package SITE03_leetcode.medium;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class M003_leetCode5_Longest_Palindromic_Substring_Youtube {
    private int lo, maxLen;

    public static void main(String[] args) {
        M003_leetCode5_Longest_Palindromic_Substring_Youtube solution = new M003_leetCode5_Longest_Palindromic_Substring_Youtube();
        //System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        //System.out.println(solution.longestPalindrome("a"));
        //System.out.println(solution.longestPalindrome("ac"));
        //System.out.println(solution.longestPalindrome("aa"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // two case
            // "racecar"
            // "aabbaa"
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }

        return s.substring(start, end + 1);
    }

    public int expandFromMiddle(String s, int left, int right) {
        if (s == null || left > right) {
            return 0;
        }

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left + 1;
    }
}
/*

"babad"

"b"
"ba"
"bab"
"baba"
"babad"

"a
"ab"
"aba"
"abad"

"b"
"ba"
"bad"

"a"
"ad"


 */

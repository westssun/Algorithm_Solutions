package SITE03_leetcode.medium;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class M003_leetCode5_Longest_Palindromic_Substring_다른풀이 {
    private int lo, maxLen;

    public static void main(String[] args) {
        M003_leetCode5_Longest_Palindromic_Substring_다른풀이 solution = new M003_leetCode5_Longest_Palindromic_Substring_다른풀이();
        //System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        //System.out.println(solution.longestPalindrome("a"));
        //System.out.println(solution.longestPalindrome("ac"));
        //System.out.println(solution.longestPalindrome("aa"));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }

        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }

        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}

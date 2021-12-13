package SITE03_leetcode.easy;

import java.util.Objects;

/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class E004_leetCode58_LengthofLastWord {
    public static void main(String[] args) {
        E004_leetCode58_LengthofLastWord solution = new E004_leetCode58_LengthofLastWord();

        System.out.println(solution.lengthOfLastWord2("   fly me   to   the moon  "));
    }

    public int lengthOfLastWord(String s) {
        int result = 0;
        boolean isInit = false;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (!Objects.equals(String.valueOf(s.charAt(i)), " ")) {
                isInit = true;
                result++;
            } else {
                if (isInit) {
                    break;
                }
            }
        }

        return result;
    }

    public int lengthOfLastWord2(String s) {
        if (null == s || s.trim().length() == 0) return 0;

        //"   fly me   to   the moon  "
        s = s.trim();
        // "fly me   to   the moon" - 양 옆의 공백 제거

        // 마지막 공백 기준으로 자르기
        String lastWord = s.substring(s.lastIndexOf(" ") + 1);

        return lastWord.length();
    }
}

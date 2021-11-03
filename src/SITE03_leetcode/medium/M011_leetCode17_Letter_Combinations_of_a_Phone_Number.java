package SITE03_leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class M011_leetCode17_Letter_Combinations_of_a_Phone_Number {

    Map<String, String> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    int size = 0;

    public static void main(String[] args) {
        M011_leetCode17_Letter_Combinations_of_a_Phone_Number solution = new M011_leetCode17_Letter_Combinations_of_a_Phone_Number();

        //System.out.println(solution.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println(solution.letterCombinations("23"));
        //System.out.println(solution.letterCombinations("234"));
    }

    public List<String> letterCombinations(String digits) {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        size = digits.length();

        // 빈 문자열의 경우 빈 리스트 리턴
        if (size == 0) {
            return new ArrayList<>();
        }

        dfs(digits, "");

        return result;
    }

    public void dfs(String digits, String words) {
        /* size (기존 문자열의 길이) 와 동일할 경우 */
        if (size == words.length()) {
            result.add(words); // 만들어진 문자열 add
            return;
        }

        // 매개변수 digits 의 첫번째 원소의 알파벳 구하기
        String target = map.get(String.valueOf(digits.charAt(0)));

        // 알파벳만큼 반복문
        for (int i = 0; i < target.length(); i++) {
            // 1 인덱스부터 잘라서 넘기기
            dfs(digits.substring(1), words + target.charAt(i));
        }
    }
}

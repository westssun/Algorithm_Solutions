package SITE03_leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class M011_leetCode17_Letter_Combinations_of_a_Phone_Number_Youtube_2 {

    Map<String, String> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    int size = 0;

    public static void main(String[] args) {
        M011_leetCode17_Letter_Combinations_of_a_Phone_Number_Youtube_2 solution = new M011_leetCode17_Letter_Combinations_of_a_Phone_Number_Youtube_2();

        //System.out.println(solution.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println(solution.letterCombinations("23"));
        //System.out.println(solution.letterCombinations("234"));
    }

    public List<String> letterCombinations(String digits) {
       List<String> result = new ArrayList<>();

       // 오류제어
       if (digits == null || digits.length() == 0) {
           return result;
       }

        // 2 ~ 9 까지만 사용
        String[] mappings = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs"
                , "tuv", "wxyz"};

       letterCombinationsRecursive(result, digits, "", 0, mappings);

       return result;
    }

    private void letterCombinationsRecursive(List<String> result, String digits, String current, int index, String[] mappings) {
        // 같으면 조합 완료
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        // 같지 않으면 계속 재귀함수 호출
        String letters = mappings[digits.charAt(index) - '0']; // abc

        for (int i = 0; i < letters.length(); i++) { // a, b, c
            letterCombinationsRecursive(result, digits, current + letters.charAt(i), index + 1, mappings);
        }

    }
}

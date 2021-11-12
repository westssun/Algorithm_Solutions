package SITE03_leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class M011_leetCode17_Letter_Combinations_of_a_Phone_Number_Youtube {

    Map<String, String> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    int size = 0;

    public static void main(String[] args) {
        M011_leetCode17_Letter_Combinations_of_a_Phone_Number_Youtube solution = new M011_leetCode17_Letter_Combinations_of_a_Phone_Number_Youtube();

        //System.out.println(solution.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println(solution.letterCombinations("23"));
        //System.out.println(solution.letterCombinations("234"));
    }

    public List<String> letterCombinations(String digits) {
        LinkedList<String> output_arr = new LinkedList<>();

        if (digits.length() == 0) {
            return output_arr;
        }

        output_arr.add("");

        // 2 ~ 9 까지만 사용
        String[] char_map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs"
                                            , "tuv", "wxyz"};

        // digits = "23"
        for (int i = 0; i < digits.length(); i++) {
            // 2, 3
            int index = Character.getNumericValue(digits.charAt(i));

            // i = 0, 1
            while (output_arr.peek().length() == i) {
                // remove : 첫번째 요소 제거 후 제거된 문자열을 permutation 에 담는다.
                String permutation = output_arr.remove();

                for (char c : char_map[index].toCharArray()) { // a, b, c
                    output_arr.add(permutation + c);
                }
            }
        }

        return output_arr;
    }
}

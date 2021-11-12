package SITE03_leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class M014_leetCode22_Generate_Parentheses_Youtube {
    public static void main(String[] args) {
        M014_leetCode22_Generate_Parentheses_Youtube solution = new M014_leetCode22_Generate_Parentheses_Youtube();

        System.out.println(solution.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> output_arr = new ArrayList<>();
        // ( 개수, ) 개수
        backtrack(output_arr, "", 0, 0, n);
        return output_arr;
    }

    public void backtrack(List<String> output_arr, String current_string, int open, int close, int max) {
        // () 한쌍이므로 * 2
        if (current_string.length() == max * 2) { // some base case
            output_arr.add(current_string);
            return;
        }

        if (open < max) { // 여는 괄호는 최대개수보다 작아야 추가가 가능하다.
            backtrack(output_arr, current_string + "(", open + 1, close, max);
        }

        if (close < open) { // 닫는 괄호는 여는 괄호보다 작게 있을때 추가가 가능하다.
            backtrack(output_arr, current_string + ")", open, close + 1, max);
        }
        
    }
}

/*

// problem test case n = 2

current = "";
[];

n = 2;
max = 2;

open = 0;
close = 0;

if (open < max) {
    current = "(";
    [];

    n = 2;
    max = 2;

    open = 1;
    close = 0;

    if (open < max) { // recursive call
           current = "((";
           [];

           n = 2;
           max = 2;

           open = 2;
           close 0;

           if (open < max) {} // false
    }

    if (close < open) { // recursive call
        current = "()";
        [];

        n = 2;
        max = 2;

        open = 1;
        close = 1;

        if (open < max) { // recursive call
            current = "()(";
            [];

            n = 2;
            max = 2;

            open = 2;
            close = 1;

            if (open < max) {} // false
            if (close < open) {
                current = "()()";
                [];

                n = 2;
                max = 2;

                open = 2;
                close = 2;
            }
        }

        if (close < open) {} // false
 */

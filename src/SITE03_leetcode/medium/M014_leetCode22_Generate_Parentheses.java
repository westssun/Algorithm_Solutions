package SITE03_leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class M014_leetCode22_Generate_Parentheses {
    public static void main(String[] args) {
        M014_leetCode22_Generate_Parentheses solution = new M014_leetCode22_Generate_Parentheses();

        System.out.println(solution.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, n, result, "");
        return result;
    }

    private void dfs(int left, int right, List<String> result, String s) {
        if (left == 0 && right == 0) {
            result.add(s);
        } else {
            if (left > 0) {
                dfs(left - 1, right, result, s + "(");
            }

            if (right > left) {
                dfs(left, right - 1, result, s + ")");
            }
        }
    }
}
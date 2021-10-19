package SITE03_leetcode.medium;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class M003_leetCode5_Longest_Palindromic_Substring {
    String param; /* 문자열을 파라미터로 보내지않을 것 */
    int maxLength = 0; /* maxLength 로 if 문 처리하여 max 일때 resultStart, resultEnd 변경해줄 것 */
    int resultStart = 0; /* 결과를 뽑아낼 index start */
    int resultEnd = 0; /* 결과를 뽑아낼 index end */

    public static void main(String[] args) {
        M003_leetCode5_Longest_Palindromic_Substring solution = new M003_leetCode5_Longest_Palindromic_Substring();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("a"));
        System.out.println(solution.longestPalindrome("ac"));
        System.out.println(solution.longestPalindrome("aa"));
    }

    public String longestPalindrome(String s) {
        String result = "";
        param = s;

        /* CASE1. 1글자의 경우 */
        if (param.length() == 1) {
            return String.valueOf(param.charAt(0));
        }

        /* CASE2. 2글자의 경우, 두글자가 서로 다른 문자일 때 */
        if (param.length() == 2) {
            if (param.charAt(0) != param.charAt(1)) {
                return String.valueOf(param.charAt(0));
            }
        }

        /* 반복문 수행하여, 각각 함수 호출 */
        for (int i = 0; i < s.length(); i++) {
            /* 홀수 */
            checkMaxLength(i, i);

            /* 짝수 */
            checkMaxLength(i, i + 1);
        }

        /* 결과 resultStart, resultEnd 로 문자열 자르기 */
        result = param.substring(resultStart, resultEnd + 1);
        return result;
    }

    public void checkMaxLength(int start, int end) {
        /* 문자열이 같은 시점의 index 를 저장하는 변수 */
        int startR = -1;
        int endR = -1;

        /* 반복문 실행 */
        while (start >= 0 && end < param.length()
                    && (param.charAt(start) == param.charAt(end))) {
            /* 문자가 같을 경우 해당 시점의 인덱스 저장 */
            if (param.charAt(start) == param.charAt(end)) {
                startR = start;
                endR = end;
            }

            /**
             * 홀수 : (1, 1) -> (0, 2) [0, 1, 2]
             * 짝수 : (1, 2) -> (0, 3) [0, 1, 2, 3]
             */
            start = start - 1;
            end = end + 1;
        }

        /* startR 이 0보다 작다는 것은 문자열이 같지 않다는 의미와 같다 */
        if (startR >= 0) {
            if (maxLength < (endR - startR + 1)) { /* maxLength 일 경우 */
                maxLength = endR - startR + 1;
                resultStart = startR; /* 결과 인덱스 start 저장 */
                resultEnd = endR; /* 결과 인덱스 end 저장 */
            }
        }
    }
}

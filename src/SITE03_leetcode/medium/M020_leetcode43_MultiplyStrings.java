package SITE03_leetcode.medium;

/**
 * https://leetcode.com/problems/multiply-strings/
 */
public class M020_leetcode43_MultiplyStrings {
    public static void main(String[] args) {
        M020_leetcode43_MultiplyStrings solution = new M020_leetcode43_MultiplyStrings();

        System.out.println(solution.multiply("123", "456"));
        // System.out.println(solution.multiply("9", "99")); // iPow + 1
        // System.out.println(solution.multiply("98", "9")); //  iPow + 2
    }

    /*
            1 2 3 n1 i
            4 5 6 n2 j
            length n1 + n2 + 1
            9 * 9 = 81 (length1 * length1 = length2)

            123 * 6
            123 * 5
            123 * 4

            123 * 6

              7 3 8
            6 1 5
          4 9 2


         */

    public String multiply(String num1, String num2) {
        int[] ans = new int[num1.length() + num2.length()];

        for (int i = num2.length() - 1; i >= 0; i--) {
            for (int j = num1.length() - 1; j >= 0; j--) {
                int valueIdx = i + j + 1;
                int remainderIdx = i + j;
                int product = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');

                product = product + ans[valueIdx];

                ans[valueIdx] = product % 10;
                ans[remainderIdx] += product / 10;
            }
        }

        boolean precedingZeros = true;
        StringBuilder result = new StringBuilder("");

        for (int i = 0; i < ans.length; i++) {
            int value = ans[i];

            if (value != 0) {
                precedingZeros = false;
            }

            if (!precedingZeros) {
                result.append(value);
            }
        }

        return result.toString();
    }

//    public String multiply(String num1, String num2) {
//
//        if (num1.length() == 1 && num2.length() == 1) {
//            return String.valueOf((num2.charAt(0) - '0') * (num1.charAt(0) - '0'));
//        }
//
//        int resultSum = 0;
//
//        int iPow = 0;
//        for (int i = num2.length() - 1; i >= 0; i--) {
//            int target = num2.charAt(i) - '0';
//
//            int targetSum = 0;
//            int value = 0; // 나머지
//            int remain = 0; // 몫
//            int pow = 0;
//
//            for (int j = num1.length() - 1; j >= 0; j--) {
//
//                int sum = target * (num1.charAt(j) - '0'); // 18
//
//                value = sum % 10; // 8
//
//                if (j == num1.length() - 1) {
//                    targetSum = targetSum + value;
//                } else {
//                    if (remain > 0) {
//                        targetSum = (int) (targetSum + ((value + remain) * (Math.pow(10, pow))));
//                    } else {
//                        targetSum = (int) (targetSum + (value * ((Math.pow(10, pow)))));
//                    }
//                }
//
//                remain = sum / 10; // 1
//                pow++;
//
//            }
//
//            if (remain > 0) {
//                resultSum += (int) ((remain * (Math.pow(10, iPow + (num1.length()))))) + targetSum * (Math.pow(10, iPow));
//            } else {
//                resultSum += (int) (targetSum * (Math.pow(10, (num2.length() - 1 - i))));
//            }
//
//            iPow++;
//        }
//
//        return String.valueOf(resultSum);
//    }
}
package SITE03_leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/integer-to-roman/
 */
public class M008_leetCode12_Integer_to_Roman {

    public static TreeMap<Integer, String> map = new TreeMap<>();

    static {
        map.put(1,"I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
    }

    public static void main(String[] args) {
        M008_leetCode12_Integer_to_Roman solution = new M008_leetCode12_Integer_to_Roman();

        //System.out.println(solution.intToRomanFail(4));
        //System.out.println(solution.intToRomanFail(9));
        //System.out.println(solution.intToRomanFail(58));
        System.out.println(solution.intToRoman(20));
    }

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        while (num != 0) {
            // 제공된 키 값보다 같거나 작은 값 중 가장 큰 키의 Entry 를 반환
            Map.Entry<Integer, String> entry = map.floorEntry(num);
            result.append(entry.getValue());
            num -= entry.getKey();
        }

        return result.toString();
    }

//    public String intToRomanFail(int num) {
//        String result;
//
//        String[] alpha = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//        int[] number = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//
//        List<String> list = new ArrayList<>();
//
//        boolean isTarget = true;
//
//        while (num != 0) {
//            int target = 0;
//
//            for (int i = 0; i < number.length; i++) {
//                if (num == number[i]) {
//                    if (isTarget) {
//                        list.clear();
//                    }
//
//                    list.add(alpha[i]);
//                    target = number[i];
//
//                    num = num - target;
//                    break;
//                } else if (number[i] < num){
//                    list.add(alpha[i]);
//                    target = number[i];
//
//                    num = num - target;
//                    isTarget = false;
//
//                    if (num == target) {
//                        break;
//                    }
//                }
//            }
//
//            isTarget = false;
//        }
//
//        // list.sort(Collections.reverseOrder());
//        result = list.stream().collect(Collectors.joining());
//
//        return result;
//    }
}

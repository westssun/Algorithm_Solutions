package SITE03_leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/group-anagrams/
 */
public class M023_leetcode49_GroupAnagrams {
    public static void main(String[] args) {
        M023_leetcode49_GroupAnagrams solution = new M023_leetcode49_GroupAnagrams();
        String[] a = new String[]{"", ""};

        System.out.println(solution.groupAnagrams(a));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        if (strs.length == 1) {
            result.add(List.of(strs));
            return result;
        }

        Map<String, String> map = new HashMap<>();
        for (String target : strs) {
            if ("".equals(target)) {
                target = " ";
            }

            // key : 사전순
            String key = getKey(target);
            if (!map.containsKey(key)) {
                map.put(key, target);
            } else {
                map.put(key, map.get(key) + "," + target);
            }
        }

        // 꺼내기
        for (Map.Entry<String, String> entry : map.entrySet()) {
            // "," 구분자로 배열 변환
            String[] targetArr = entry.getValue().split(",");
            Arrays.sort(targetArr);

            // array to List (trim : 공백의 경우 위에서 넣어줬기 때문)
            List<String> list = Arrays.stream(targetArr).map(String::trim).collect(Collectors.toList());
            result.add(list);
        }

        return result;
    }

    public String getKey(String target) {
        char[] charArr = target.toCharArray(); // String to Char Array
        Arrays.sort(charArr); // Char Array 알파벳 순 정렬

        return String.valueOf(charArr);
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            /* 배열 변환 후 정렬 */
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            /* key 추출 (사전순) */
            String key = String.valueOf(chars);

            /* computeIfAbsent() 메서드를 사용하여 key가 존재 유무에 따라 설정 */
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}

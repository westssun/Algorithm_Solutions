package SITE03_leetcode.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/majority-element/
 */
public class E001_leetCode169_Majority_element {
    public static void main(String[] args) {
        E001_leetCode169_Majority_element solution = new E001_leetCode169_Majority_element();

        int[] a = new int[]{2,2,1,1,1,2,2};

        System.out.println(solution.majorityElement(a));
        System.out.println(solution.majorityElement2(a));
    }

    public int majorityElement(int[] nums) {
        int target = nums.length / 2;

        Map<Integer, Integer> map = new HashMap<>();
        for (int key : nums) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        Set<Integer> set = map.entrySet().stream()
                // key 에 해당하는 value 중 target 보다 큰 것으로 필터링
                .filter(key -> key.getValue() > target)
                // 필터링 된 Entry 의 key 추출
                .map(Map.Entry::getKey)
                // Set 으로 변경 (중복제거)
                .collect(Collectors.toSet());

        // 최대값 추출
        return set.stream().max(Integer::compareTo).get();
    }

    public int majorityElement2(int[] nums) {

        // Assume, there are many persons with same face
        // And one person (side person) is taking care of a countBox of person name
        // If same person comes, he increases the count
        // Otherwise decreases the count

        // Understand it this way,
        // [3,2,3] == Mohan, Sohan, Mohan

        // All three of them are standing in a Queue
        // If CountBox is Empty, he adds the first person name ticket into the Box
        // If he finds same person again, he adds another same ticket

        // **** -> When he finds a different person, he doesn't add different name ticket
        // He actually removes a ticket from the box

        // Logic : When same person comes, count increases
        // When another person comes, count decreases
        // This way, the person which has the majority will last in the countBox

        int countBox = 0;
        int person = 0;

        for(int num : nums){

            if(countBox == 0){ // countBox is Empty
                person = num; // First Person in the Queue will be added to the Box
            }

            if(num == person){// If the same person comes again
                countBox++;
            }else{
                countBox--; // If different person comes
            }
        }
        return person; // Last Person who remains in the box
    }
}

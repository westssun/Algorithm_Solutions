package SITE05_thisiscodingtest.part03.Q25_FailureRate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main2 {
    public static void main(String[] args) {
        Map<Integer, Double> map = new HashMap<>();
        map.put(1, 0.2);
        map.put(2, 0.4);
        map.put(3, 0.4);
        map.put(4, 0.4);

        Integer key = map.entrySet().stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get()
                .getKey();

        Optional<Integer> first = map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Collections.reverseOrder())) /* value 정렬 */
                        .map(Map.Entry::getKey) /* key String type */
                        .sorted()
                        .findFirst();

        System.out.println(first.get());
    }
}

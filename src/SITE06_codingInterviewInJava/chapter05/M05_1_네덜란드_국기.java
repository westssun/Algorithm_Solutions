package SITE06_codingInterviewInJava.chapter05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 배열 A와 피벗 i 가 주어졌다.
 *
 * 피벗보다 작은원소, 피벗과 같은 원소, 피벗보다 큰 원소
 * 이 순서로 원소를 재배열하자.
 */
public class M05_1_네덜란드_국기 {
    public static void main(String[] args) {
        M05_1_네덜란드_국기 main = new M05_1_네덜란드_국기();
        main.solution(List.of(0, 1, 2, 0, 2, 1, 1), 2);

        main.book1(getList(), 2);
        main.book2(getList(), 2);
        main.book3(getList(), 2);
    }

    /**
     * 나의 풀이
     * @param list
     * @param pivotIndex
     */
    private void solution(List<Integer> list, int pivotIndex) {
        Integer pivot = list.get(pivotIndex);

        // 작은거
        List<Integer> small = list.stream()
                .filter(i -> i < list.get(pivot))
                .sorted()
                .collect(Collectors.toList());

        // 큰거
        List<Integer> big = list.stream()
                .filter(i -> i >= list.get(pivot))
                .sorted()
                .collect(Collectors.toList());

        // List merge
        List<Integer> result = new ArrayList<>();
        result.addAll(small);
        result.addAll(big);

        System.out.println(result);
    }

    /**
     * 해설1
     * 공간복잡도 O(1), 시간복잡도 O(n제곱)
     * @param list
     * @param pivotIndex
     */
    private void book1(List<Integer> list, int pivotIndex) {
        Integer pivot = list.get(pivotIndex);

        /* 작은 원소 구하기 */
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < pivot && list.get(i) > list.get(j)) {
                    Collections.swap(list, i, j);
                    break;
                }
            }
        }

        /* 큰 원소 구하기 */
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) >= pivot) {
                // 큰 원소를 찾는다.
                // 피벗보다 작은 원소가 나오면 즉시 멈춘다.
                // -> 위 단계에서 피벗보다 작은 원소들은 이미 A의 앞쪽으로 이동했다.
                for (int j = i - 1; j >= 0; j--) {
                    if (list.get(j) >= pivot) {
                        if (list.get(j) > pivot) {
                            Collections.swap(list, i, j);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(list);
    }

    /**
     * 해설2
     * 공간복잡도 O(1), 시간복잡도 O(1)
     * @param list
     * @param pivotIndex
     */
    private void book2(List<Integer> list, int pivotIndex) {
        Integer pivot = list.get(pivotIndex);

        /* 작은 원소 구하기 */
        int smaller = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < pivot) {
                Collections.swap(list, smaller++, i);
            }
        }

        /* 큰 원소 구하기 */
        int larger = list.size() - 1;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) >= pivot) {
                if (list.get(i) < pivot) {
                    Collections.swap(list, larger--, i);
                }
            }
        }

        System.out.println(list);
    }

    /**
     * 해설3
     * @param list
     * @param pivotIndex
     */
    private void book3(List<Integer> list, int pivotIndex) {
        Integer pivot = list.get(pivotIndex);

        /*
         * 분류할때마다 다음 불변식을 만족해야한다.
         * 피벗보다 작은 원소 그룹: list.subList(0, smaller)
         * 피벗과 같은 원소 그룹 : list.subList(smaller, equal)
         * 미분류 원소 그룹 : list.subList(equal, larger)
         * 피벗보다 큰 원소 그룹 : list.subList(larger, list.size())
         */
        int smaller = 0;
        int equal = 0;
        int larger = list.size();

        // 분류되지 않은 원소가 있는 동안 계속 순회한다.
        while (equal < larger) {
            // list.get(equal)는 분류되지 않은 원소다.
            if (list.get(equal) < pivot) {
                Collections.swap(list, smaller++, equal++);
            } else if (Objects.equals(list.get(equal), pivot)) {
                ++equal;
            } else { // list.get(equal) > pivot
                Collections.swap(list, equal, --larger);
            }
        }

        System.out.println(list);
    }

    private static List<Integer> getList() {
        List<Integer> paramList = new ArrayList<>();
        paramList.add(0);
        paramList.add(1);
        paramList.add(2);
        paramList.add(0);
        paramList.add(2);
        paramList.add(1);
        paramList.add(1);

        return paramList;
    }
}

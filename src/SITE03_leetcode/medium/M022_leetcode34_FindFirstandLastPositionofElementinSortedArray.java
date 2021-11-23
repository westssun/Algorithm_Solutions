package SITE03_leetcode.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class M022_leetcode34_FindFirstandLastPositionofElementinSortedArray {
    public static void main(String[] args) {
        M022_leetcode34_FindFirstandLastPositionofElementinSortedArray solution = new M022_leetcode34_FindFirstandLastPositionofElementinSortedArray();
        // int[] a = new int[]{5,1,5,3,2,2};
        // int[] a = new int[]{5,7,7,8,8,10};
        int[] a = new int[]{1, 1, 2};

        System.out.println(Arrays.toString(solution.searchRange(a, 1)));
    }

    public int[] searchRange(int[] nums, int target) {
        // 이진 탐색 수행 결과 출력

        return binarySearch(nums, target, 0, nums.length - 1);
    }

    // 순차 탐색 소스코드 구현
    public int[] binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            // 중간점 찾기
            int mid = (start + end) / 2;

            if (arr[mid] == target) { // 찾은 경우 중간점 인덱스 반환
                int minus = mid;
                int plus = mid;

                /* mid 보다 작을 경우 체크 */
                while (true) {
                    if (minus - 1 >= 0) {
                        if (arr[minus - 1] != target) {
                            break;
                        } else {
                            /* 동일할 경우 계속 왼쪽으로 진행 */
                            minus = minus - 1;
                        }
                    } else {
                        break;
                    }
                }

                /* mid 보다 클 경우 체크 */
                while (true) {
                    if (plus + 1 <= arr.length - 1) {
                        if (arr[plus + 1] != target) {
                            break;
                        } else {
                            /* 동일할 경우 계속 오른쪽으로 진행 */
                            plus = plus + 1;
                        }
                    } else {
                        break;
                    }
                }

                return new int[]{minus, plus};
            } else if (arr[mid] > target) { // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
                end = mid - 1;
            } else {
                start = mid + 1; // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            }
        }

        return new int[]{-1, -1};
    }
}

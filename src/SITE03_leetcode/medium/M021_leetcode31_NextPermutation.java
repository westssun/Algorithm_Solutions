package SITE03_leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/multiply-strings/
 */
public class M021_leetcode31_NextPermutation {
    public static void main(String[] args) {
        M021_leetcode31_NextPermutation solution = new M021_leetcode31_NextPermutation();
        // int[] a = new int[]{5,1,5,3,2,2};
        int[] a = new int[]{1, 3, 2};

        solution.nextPermutation(a);
    }

    /*
        2 1 3 5 4
        -> 5 > 4 : 3 은 종료 (3 <-> 4 swap)
        -> 2 1 4 5 3
        -> 5, 3 은 정렬 -> 2 1 4 3 5

        2 1 4 3 5 6
        -> 5 < 6 : 3일때 종료 아님 (5 <-> 6 swap)
        -> 2 1 4 3 6 5

        5 1 5 3 2 2
        -> 2 = 2
        -> 3 > 2 : 5 는 종료
        -> (5 <-> 2 swap) -> 5 > 2 면 5 앞의 1은 종료 (이때, 2는 1보다 큰 수들중 가장 작은수)
        -> (1 <-> 2 swap) -> 5 2 5 3 2 1 (1 index 뒤에는 이미 역순정렬 되어있다 , 5 -> 3-> 2-> 1)
        -> 2 뒤로는 정렬 ->  5 2 1 2 3 5

        1) swap 될 target 을 찾는다.
        : 배열의 뒤에서부터 볼때 바로 왼쪽의 인덱스의 값 < 인덱스의 값 인 최초의 지점
          (arr[i - 1] < arr[i] 인 지점)
        2) target 뒤의 가장 작은 숫자(target 보다 큰) 와 swap
        3) 이때 target 뒤의 배열은 역순 정렬 되어있다. 그 뒤는 reverse (뒤집는다.)
     */
    public void nextPermutation(int[] nums) {
        int targetIndex = 0;

        // 5 1 5 3 2 2
        boolean isTarget = false;
        for (int i = nums.length - 1; i >= 0; i--) { // i = 5, 4, 3, 2, 1, 0 ...
            // target 을 찾지 못했을때만 실행
            if (!isTarget && i > 0) {
                if (nums[i - 1] < nums[i]) {
                    targetIndex = i - 1;
                    isTarget = true;
                }
            }
        }

        // 해당 if문 은 위에 targetIndex 를 찾았을 경우 수행 (isTarget true)
        if (targetIndex > 0 || isTarget) {
            // targetIndex 다음 순열부터 수행
            int min = nums[targetIndex + 1];
            int minIndex = targetIndex + 1;

            for (int i = targetIndex + 2; i < nums.length; i++) {
                /**
                 * 조건 1. min 찾기 (>= 을때)
                 * 조건 2. nums[targetIndex] 보단 커야함
                 */
                if (min >= nums[i] && nums[i] > nums[targetIndex]) {
                    min = nums[i];
                    minIndex = i;
                }
            }

            // swap
            swap(nums, targetIndex, minIndex);

            // sort
            reverse(nums, targetIndex + 1, nums.length - 1);
        } else {
            // targetIndex 를 찾지 못한 경우는 맨 첫 정렬 리턴
            reverse(nums, targetIndex, nums.length - 1);
        }

        System.out.println(Arrays.toString(nums));
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i, j);

            i = i + 1;
            j = j - 1;
        }
    }
}
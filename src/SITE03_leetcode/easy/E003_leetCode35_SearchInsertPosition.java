package SITE03_leetcode.easy;

/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class E003_leetCode35_SearchInsertPosition {
    public static void main(String[] args) {
        E003_leetCode35_SearchInsertPosition solution = new E003_leetCode35_SearchInsertPosition();

        int[] a = new int[]{1,3,5,6};
        System.out.println(solution.searchInsert2(a, 5));
    }

    public int searchInsert(int[] nums, int target) {
        int result = 0;

        /* 경우의수. 마지막 원소보다 target 이 큰 경우 */
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        int beforeTarget = nums[0];

        /* 경우의 수. 첫번째 원소와 target 이 동일한 경우 */
        if (beforeTarget == target) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (beforeTarget <= target && target <= nums[i]) {
                result = i;
                break;
            } else {
                beforeTarget = nums[i];
            }
        }

        return result;
    }

    // binary search
    public int searchInsert2(int[] A, int target) {
        // error check
        if(A == null) {
            return 0;
        }

        // special cases
        if(target < A[0]) {
            return 0;
        }

        if(target > A[A.length - 1]) {
            return A.length;
        }

        // perform binary search
        int left = 0;
        int right = A.length - 1;

        while(left <= right) {
            int mid = (right - left) / 2 + left;
            if(A[mid] == target) {
                return mid;
            }
            else if(target < A[mid]) {
                right = mid - 1;
            }
            else { // target > A[mid]
                left = mid + 1;
            }
        }

        return left;
    }

}

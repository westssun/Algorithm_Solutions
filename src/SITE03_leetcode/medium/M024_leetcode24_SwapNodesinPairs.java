package SITE03_leetcode.medium;

import SITE03_leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class M024_leetcode24_SwapNodesinPairs {
    public static void main(String[] args) {
        M024_leetcode24_SwapNodesinPairs solution = new M024_leetcode24_SwapNodesinPairs();

        ListNode listNode1 = new ListNode();
        listNode1.val = 1;
        listNode1.next = new ListNode();
        listNode1.next.val = 2;
        listNode1.next.next = new ListNode();
        listNode1.next.next.val = 3;
        listNode1.next.next.next = new ListNode();
        listNode1.next.next.next.val = 4;

        System.out.println(solution.swapPairs(listNode1));
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode point = dummy;

        while(point.next != null && point.next.next != null) {
            ListNode swap1 = point.next;
            ListNode swap2 = point.next.next;

            point.next = swap2;

            swap1.next = swap2.next;
            swap2.next = swap1;

            point = swap1;
        }

        return dummy.next;
    }
}
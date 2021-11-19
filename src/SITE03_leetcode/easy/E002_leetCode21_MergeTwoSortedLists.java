package SITE03_leetcode.easy;

import SITE03_leetcode.common.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class E002_leetCode21_MergeTwoSortedLists {
    public static void main(String[] args) {
        E002_leetCode21_MergeTwoSortedLists solution = new E002_leetCode21_MergeTwoSortedLists();

        ListNode listNode1 = new ListNode();
        listNode1.val = 1;
        listNode1.next = new ListNode();
        listNode1.next.val = 2;
        listNode1.next.next = new ListNode();
        listNode1.next.next.val = 4;

        ListNode listNode2 = new ListNode();
        listNode2.val = 1;
        listNode2.next = new ListNode();
        listNode2.next.val = 3;
        listNode2.next.next = new ListNode();
        listNode2.next.next.val = 4;

        System.out.println(solution.mergeTwoLists(listNode1, listNode2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode head = temp;

        while (true) {
            /* null check */
            if (l1 == null) {
                temp.next = l2;
                break;
            } else if (l2 == null) {
                temp.next = l1;
                break;
            }

            // 더 작은 노드를 설정
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        return head.next;
    }
}

package SITE03_leetcode.medium;

import SITE03_leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class M015_leetcode24_SwapNodesinPairs_Youtube {
    public static void main(String[] args) {
        M015_leetcode24_SwapNodesinPairs_Youtube solution = new M015_leetcode24_SwapNodesinPairs_Youtube();

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
        // 가짜 노드 생성 (주소를 교환)
        ListNode temp = new ListNode(0);
        // head 에 대한 일종의 참조를 가지기 위해
        temp.next = head;

        ListNode current = temp;

        // target Node : current
        while(current.next != null && current.next.next != null) {
            ListNode first_node = current.next; // head의 타겟노드 와 동일
            ListNode second_node = current.next.next; // head 의 타겟 노드가 가르키는 노드와 동일

            // switch 를 위해 실행
            first_node.next = second_node.next;
            current.next = second_node;
            current.next.next = first_node;
            current = current.next.next;
        }

        return temp.next;

    }
}
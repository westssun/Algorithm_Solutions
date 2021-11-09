package SITE03_leetcode.medium;

import SITE03_leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/4sum/submissions/
 */
public class M019_Remove_Nth_Node_From_End_of_List {
    public static void main(String[] args) {
        M019_Remove_Nth_Node_From_End_of_List solution = new M019_Remove_Nth_Node_From_End_of_List();

        ListNode listNode1 = new ListNode();
        listNode1.val = 1;
        listNode1.next = new ListNode();
        listNode1.next.val = 2;
        listNode1.next.next = new ListNode();
        listNode1.next.next.val = 3;
        listNode1.next.next.next = new ListNode();
        listNode1.next.next.next.val = 4;
        listNode1.next.next.next.next = new ListNode();
        listNode1.next.next.next.next.val = 5;

        System.out.println(solution.removeNthFromEnd(listNode1, 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode paramNode = head;

        // remove index 찾기
        int length = 0;
        while (head.next != null) {
            head = head.next;
            length = length + 1;
        }

        int removeIndex = length - n + 1;

        // 해당 노드 remove
        return deleteAtIndex(paramNode, removeIndex);
    }

    public ListNode deleteAtIndex(ListNode paramNode, int index) {
        if (paramNode == null) {
            return new ListNode();
        }

        ListNode prev = null;
        ListNode cur = paramNode; /* paramNode 를 cur 에 복사 */

        /* index (삭제할 노드를 찾는다) */
        for (int i = 0; i < index; i++) {
            if (cur.next == null) {
                return new ListNode();
            }

            prev = cur; // prev : 삭제할 노드의 이전 노드가 최종적으로 저장됨
            cur = cur.next; // cur : 삭제할 노드가 최종적으로 저장됨
        }

        ListNode next = cur.next; // 삭제할 노드의 다음 노드가 최종적으로 저장됨

        if (prev == null) { // prev == null) 첫 노드라는 것으로, 다음 노드로 변경해주면 된다.
            paramNode = paramNode.next;
        } else {
            prev.next = next; // '삭제할 노드의 이전 노드의 다음 노드' 를 '삭제할 노드의 다음 노드' 로 설정
        }

        return paramNode; // 최종 결과 노드 (prev, cur 설정에 따라 paramNode 가 만들어짐)
    }
}
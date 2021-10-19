package SITE03_leetcode.medium;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class M001_addTwoNumbers_SUCCESS {
    ListNode resultNode = new ListNode();

    public static void main(String[] args) {
        M001_addTwoNumbers_SUCCESS solution = new M001_addTwoNumbers_SUCCESS();
        ListNode listNode1 = new ListNode();
        listNode1.val = 2;
        listNode1.next = new ListNode();
        listNode1.next.val = 4;
        listNode1.next.next = new ListNode();
        listNode1.next.next. val = 3;

        ListNode listNode2 = new ListNode();
        listNode2.val = 5;
        listNode2.next = new ListNode();
        listNode2.next.val = 6;
        listNode2.next.next = new ListNode();
        listNode2.next.next.val = 4;

        solution.addTwoNumbers(listNode1, listNode2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        ListNode node = answer;

        int quot = 0;

        while (l1 != null || l2 != null) {
            int sum = quot;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            quot = sum / 10; /* 10으로 나눈 몫이 다음 덧셈때 더해질 값 */
            sum %= 10; /* 나머지가 현재의 sum */

            ListNode temp = new ListNode(sum);
            node.next = temp; /* node.next 설정하면 같은 주소인 answer.next 도 동일하게 변경 */
            node = node.next; /* node 엔 다음 노드를 저장시킨다 / 다음 노드를 가르켜야하는 노드가 필요했으므로 node 를 처음에 2개 생성 */
        }

        /* 마지막 덧셈 결과에서도 quot 가 나올 시 처리 */
        if (quot > 0) {
            ListNode temp = new ListNode(quot);
            node.next = temp;
        }

        return answer.next;
    }
}
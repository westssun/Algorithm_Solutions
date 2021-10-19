package SITE03_leetcode.medium;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class M001_addTwoNumbers {
    public static void main(String[] args) {
        M001_addTwoNumbers solution = new M001_addTwoNumbers();
        ListNode listNode1 = new ListNode();
        listNode1.val = 2;
        listNode1.next = new ListNode();
        listNode1.next.val = 4;
        listNode1.next.next = new ListNode();
        listNode1.next.next.val = 3;

        ListNode listNode2 = new ListNode();
        listNode2.val = 5;
        listNode2.next = new ListNode();
        listNode2.next.val = 6;
        listNode2.next.next = new ListNode();
        listNode2.next.next.val = 4;

        solution.addTwoNumbers(listNode1, listNode2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();

        /* Node to Number */
        long number1 = nodeToNumber(l1);
        long number2 = nodeToNumber(l2);

        /* sum */
        long sum = number1 + number2;

        /* Result Number to Node */
        listNode = numberToNode(sum);

        return listNode;
    }

    public long nodeToNumber(ListNode node) {
        StringBuilder s1 = new StringBuilder();

        while (node != null) {
            s1.append(node.val);
            node = node.next;
        }

        return Integer.parseInt(s1.reverse().toString());
    }

    public ListNode numberToNode(long value) {
        String sValue = String.valueOf(value);


        ListNode head = null;

        for (int i = sValue.length() - 1; i >= 0; i--) {
            ListNode newNode = new ListNode(sValue.charAt(i) - '0');

            if (head == null) {
                head = newNode;
            } else {
                ListNode tempNode = head;

                while (tempNode.next != null) {
                    tempNode = tempNode.next;
                }

                tempNode.next = newNode;
            }
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

package leetcode.common;

public class LianbiaoUtil {
    public static ListNode buildLianbian() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        return node1;
    }

    public static void soutLianbiao(ListNode head) {
        if (head == null) {
            System.out.println(head);
        }
        ListNode cur = head;
        StringBuilder result = new StringBuilder();
        while (cur != null) {
            result.append(cur.val).append(",");
            cur = cur.next;
        }
        System.out.println(result);
    }
}

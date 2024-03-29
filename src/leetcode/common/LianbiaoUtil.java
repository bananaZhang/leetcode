package leetcode.common;

public class LianbiaoUtil {
    public static ListNode buildLiaobian(Integer... values) {
        ListNode pre = null;
        ListNode head = null;
        for (int i = 0; i < values.length; i ++) {
            ListNode node = new ListNode(values[i], null);
            if (pre != null) {
                pre.next = node;
            }
            if (pre == null) {
                head = node;
            }
            pre = node;
        }
        return head;
    }

    public static ListNode buildLiaobian() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

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

package leetcode;

import leetcode.common.LianbiaoUtil;
import leetcode.common.ListNode;

/**
 * 排序链表（归并排序）
 * */
public class Leetcode148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 断开链表
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        ListNode root = new ListNode(0);
        ListNode cur = root;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null ? right : left;
        return root.next;
    }

    public static void main(String[] args) {
        ListNode head = LianbiaoUtil.buildLiaobian(4,2,1,3);
        ListNode newHead = new Leetcode148().sortList(head);
        LianbiaoUtil.soutLianbiao(newHead);
    }
}

package leetcode;

import leetcode.common.ListNode;

/**
 * 环形链表返回相交点
 * @author: ZJY
 * @date: 2022/5/2 10:21 下午
 */
public class Leetcode142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            slow = slow.next;
            // 无环的情况
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}

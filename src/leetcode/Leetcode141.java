package leetcode;

import leetcode.common.ListNode;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * @author: ZJY
 * @date: 2021/11/27 1:07 下午
 */
public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

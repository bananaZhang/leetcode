package leetcode;

import leetcode.common.ListNode;

/**
 * 相交链表
 * @author: ZJY
 * @date: 2022/2/19 8:28 下午
 */
public class Leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}

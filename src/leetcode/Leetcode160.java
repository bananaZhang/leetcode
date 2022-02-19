package leetcode;

import leetcode.common.ListNode;

/**
 * 相交链表
 * @author: ZJY
 * @date: 2022/2/19 8:28 下午
 */
public class Leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        int count = 2;
        // 下面可以优化，没有相交的话，最后也是 curA == curB == null，相交的话，返回的 curA 或者 curB 就是相交点
        while (count >= 0) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
            if (curA == null) {
                curA = headB;
                count--;
            }
            if (curB == null) {
                curB = headA;
                count--;
            }
        }
        return null;
    }
}

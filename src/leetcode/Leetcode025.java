package leetcode;

import leetcode.common.LianbiaoUtil;
import leetcode.common.ListNode;

/**
 * K个一组反转链表
 * 字节题
 * @author: ZJY
 * @date: 2022/3/1 10:11 下午
 */
public class Leetcode025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            // 终止条件
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        // [head, tail)区间包含k个待反转元素
        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = LianbiaoUtil.buildLiaobian();
        LianbiaoUtil.soutLianbiao(new Leetcode025().reverseKGroup(head, 3));
    }
}

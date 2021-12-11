package leetcode;

import leetcode.common.LianbiaoUtil;
import leetcode.common.ListNode;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * @author: ZJY
 * @date: 2021/12/11 9:06 下午
 */
public class Leetcode024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode head = LianbiaoUtil.buildLiaobian();
        ListNode newHead = new Leetcode024().swapPairs(head);
        LianbiaoUtil.soutLianbiao(newHead);
    }
}

package leetcode;

import leetcode.common.LianbiaoUtil;
import leetcode.common.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * 重排链表
 * @author: ZJY
 * @date: 2022/5/4 6:58 下午
 */
public class Leetcode143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 找到链表中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反转后半段链表，后半段链表的起点是slow.next，如果不把slow.next赋值为null，会造成死循环
        ListNode head2 = slow.next;
        slow.next = null;
        slow = head2;
        ListNode pre = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        // 合并两个链表
        ListNode cur1 = head;
        ListNode cur2 = pre;
        while (cur1 != null && cur2 != null) {
            ListNode next1 = cur1.next;
            ListNode next2 = cur2.next;
            cur1.next = cur2;
            cur2.next = next1;
            cur1 = next1;
            cur2 = next2;
        }
    }

    public static void main(String[] args) {
        ListNode node = LianbiaoUtil.buildLiaobian(1, 2, 3, 4, 5, 6, 7, 8);
        new Leetcode143().reorderList(node);
        LianbiaoUtil.soutLianbiao(node);
    }
}

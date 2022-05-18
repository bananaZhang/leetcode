package leetcode;

import leetcode.common.LianbiaoUtil;
import leetcode.common.ListNode;

/**
 * 删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @author: ZJY
 * @date: 2021/11/27 1:23 下午
 */
public class Leetcode019 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 快慢指针，快指针先走n步，再同时走，快指针到队尾时，慢指针的下个节点就是倒数第n个节点
        ListNode fast = head;
        ListNode slow = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = LianbiaoUtil.buildLiaobian();
        head = removeNthFromEnd(head, 1);
        LianbiaoUtil.soutLianbiao(head);

        head = LianbiaoUtil.buildLiaobian();
        head = removeNthFromEnd(head, 4);
        LianbiaoUtil.soutLianbiao(head);

        head = LianbiaoUtil.buildLiaobian();
        head = removeNthFromEnd(head, 7);
        LianbiaoUtil.soutLianbiao(head);
    }
}

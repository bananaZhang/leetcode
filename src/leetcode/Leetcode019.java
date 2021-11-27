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
        ListNode last = head;
        // 链表中节点的数量
        int count = 0;
        while (last != null) {
            count ++;
            last = last.next;
        }
        ListNode cur = head;
        ListNode pre = null;
        for (int i = 1; i <= count - n; i++) {
            pre = cur;
            cur = cur.next;
        }
        // 表明删除头节点
        if (pre == null) {
            head = head.next;
        } else {
            pre.next = cur.next;
        }
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

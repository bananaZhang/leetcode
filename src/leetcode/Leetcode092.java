package leetcode;

import leetcode.common.LianbiaoUtil;
import leetcode.common.ListNode;

/**
 * 反转链表
 * @author: ZJY
 * @date: 2022/1/23 9:18 下午
 */
public class Leetcode092 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode cur = head;
        ListNode prev = null;
        for (int i = 1; i < left; i++) {
            prev = cur;
            cur = cur.next;
        }
        if (prev == null) {
            return reverse(cur, right - left + 1);
        }
        prev.next = reverse(cur, right - left + 1);
        return head;
    }

    private ListNode reverse(ListNode head, int count) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null && count-- > 0) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = cur;
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = LianbiaoUtil.buildLiaobian();
        LianbiaoUtil.soutLianbiao(new Leetcode092().reverseBetween(head, 2, 5));
    }
}

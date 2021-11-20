package leetcode;

import leetcode.common.LianbianUtil;
import leetcode.common.ListNode;

/**
 * 反转链表
 * @author: ZJY
 * @date: 2021/11/20 8:11 下午
 */
public class Leetcode206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = LianbianUtil.buildLianbian();
        LianbianUtil.soutLianbiao(head);

        LianbianUtil.soutLianbiao(new Leetcode206().reverseList(head));
    }
}

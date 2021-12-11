package leetcode;

import leetcode.common.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @author: ZJY
 * @date: 2020/8/15 5:56 下午
 */
public class Leetcode021 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode root = new ListNode(0);
        ListNode tail = root;
        while (list1 != null && list2 != null) {
            int v1 = list1.val;
            int v2 = list2.val;
            if (v1 >= v2) {
                ListNode node = new ListNode(v2);
                list2 = list2.next;
                tail.next = node;
                tail = node;
            }
            if (v1 <= v2) {
                ListNode node = new ListNode(v1);
                list1 = list1.next;
                tail.next = node;
                tail = node;
            }
        }
        if (list1 != null) {
            tail.next = list1;
        }
        if (list2 != null) {
            tail.next = list2;
        }
        return root.next;
    }

    public static void main(String[] args) {

    }
}



import java.util.ArrayList;
import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @author ZJY
 * @date 2019/1/22 20:00
 */
public class Leetcode002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        int addOne = 0;
        while (l1 != null || l2 != null) {
            int num = 0;
            if (null != l1) {
                num += l1.val;
                l1 = l1.next;
            }
            if (null != l2) {
                num += l2.val;
                l2 = l2.next;
            }
            num += addOne;
            if (num > 9) {
                list.add(num % 10);
                addOne = 1;
            } else {
                list.add(num);
                addOne = 0;
            }
        }
        if (addOne > 0) {
            list.add(addOne);
        }
        ListNode head = null;
        ListNode cur = null;
        for (Integer num : list) {
            if (head == null) {
                head = cur = new ListNode(num);
            } else {
                ListNode node = new ListNode(num);
                cur.next = node;
                cur = node;
            }
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
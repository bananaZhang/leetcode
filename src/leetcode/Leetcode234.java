package leetcode;

import leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 * @author: ZJY
 * @date: 2022/7/6 9:46 上午
 */
public class Leetcode234 {
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        List<Integer> valueList = new ArrayList<>();
        while (cur != null) {
            valueList.add(cur.val);
            cur = cur.next;
        }
        for (int i = 0, j = valueList.size() - 1; i < j; ) {
            if (!valueList.get(i).equals(valueList.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

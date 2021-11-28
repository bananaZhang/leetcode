package leetcode;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * @author: ZJY
 * @date: 2021/11/28 9:31 下午
 */
public class Leetcode155 {
    TempNode head = null;

    public Leetcode155() {
    }

    public void push(int val) {
        int min = head == null ? val : Math.min(head.min, val);
        head = new TempNode(val, min, head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    public static class TempNode {
        public int val;
        public int min;
        public TempNode next;

        public TempNode(int val, int min, TempNode next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

package leetcode;

import leetcode.common.LianbiaoUtil;
import leetcode.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并K个升序列表
 * @author: ZJY
 * @date: 2022/4/30 7:48 下午
 */
public class Leetcode023 {

    public ListNode mergeKLists(ListNode[] lists) {
        // PriorityQueue队列默认自然顺序排列（小顶堆）,队首是最小的元素
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        // 先把每个链表中最小的入队
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.offer(listNode);
            }
        }
        ListNode head = new ListNode(0, null);
        ListNode cur = head;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = node;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = LianbiaoUtil.buildLiaobian(1,3,4,6,8,9,12);
        ListNode node2 = LianbiaoUtil.buildLiaobian(1,2,5,7,11,21,24);
        ListNode node3 = LianbiaoUtil.buildLiaobian(-4,0,4,7,10,14,22,29);
        LianbiaoUtil.soutLianbiao(new Leetcode023().mergeKLists(new ListNode[]{node1, node2, node3}));
    }
}

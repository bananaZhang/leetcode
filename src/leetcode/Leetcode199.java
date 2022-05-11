package leetcode;

import leetcode.common.TreeNode;

import java.util.*;

/**
 * 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 字节题
 * @author: ZJY
 * @date: 2022/5/10 11:09 下午
 */
public class Leetcode199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> resultList = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            while (size > 0) {
                TreeNode node = stack.poll();
                if (node.left != null) {
                    stack.offer(node.left);
                }
                if (node.right != null) {
                    stack.offer(node.right);
                }
                size--;
                if (size == 0) {
                    resultList.add(node.val);
                }
            }
        }
        return resultList;
    }
}

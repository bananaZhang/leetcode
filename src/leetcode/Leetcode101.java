package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 对称二叉树：给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * */
public class Leetcode101 {
    // 还可以用递归
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                list.add(node);
                if (node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if (!isListSymmetric(list)) {
                return false;
            }
        }
        return true;
    }

    private boolean isListSymmetric(List<TreeNode> list) {
        for (int i = 0, j = list.size()-1; i < j; i++, j--) {
            TreeNode left = list.get(i);
            TreeNode right = list.get(j);
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
        }
        return true;
    }
}

package leetcode;

import leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的最大深度
 * @author: ZJY
 * @date: 2022/5/22 4:59 下午
 */
public class Leetcode104 {
    public int maxDepth(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int count = queue.size();
            while (count-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return level;
    }
}

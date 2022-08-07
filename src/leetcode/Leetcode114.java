package leetcode;

import leetcode.common.TreeNode;

import java.util.Stack;

/**
 * 二叉树展开为链表
 * @author: ZJY
 * @date: 2022/8/7 6:06 下午
 */
public class Leetcode114 {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root.left);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                TreeNode rightNode = node.right;
                node.right = node.left;
                node.left = null;
                while (node.right != null) {
                    node = node.right;
                }
                node.right = rightNode;
                root = rightNode;
            }
        }
    }
}

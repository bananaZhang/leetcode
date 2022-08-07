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
                stack.add(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                TreeNode tmp = node.right;
                // 右节点设置为左节点的值
                node.right = node.left;
                // 左节点设置为null
                node.left = null;
                // 左节点已经是链表了，找到链表尾部
                while (node.right != null) {
                    node = node.right;
                }
                // 原来的右节点放到尾部
                node.right = tmp;
                // 右节点下面可能也要转换成链表，所以需要把右节点也放入栈中处理
                root = tmp;
            }
        }
    }
}

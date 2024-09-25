package leetcode;

import leetcode.common.TreeNode;
import leetcode.common.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中第 K 小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 */
public class Leetcode230 {
    private int result = -1;
    private int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        traverse(root);
        return result;
    }

    // 中序遍历k次就可以得到结果
    private void traverse(TreeNode node) {
        if (k == 0) {
            return;
        }
        if (node.left != null) {
            traverse(node.left);
        }
        if (--k == 0) {
            result = node.val;
        }
        if (node.right != null) {
            traverse(node.right);
        }
    }

    public static void main(String[] args) {

        System.out.println(new Leetcode230().kthSmallest(TreeUtil.buildBinaryTree(), 1));
    }
}

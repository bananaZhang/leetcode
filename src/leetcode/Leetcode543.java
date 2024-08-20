package leetcode;


import leetcode.common.TreeNode;

/**
 * 二叉树的直径
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 * @author: ZJY
 * @date: 2022/6/5 7:19 下午
 */
public class Leetcode543 {
    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    /*
     * root为根节点的最大深度
     */
    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        int leftDepth = 0;
        if (root.left != null) {
            leftDepth = dfs(root.left) + 1;
        }
        int rightDepth = 0;
        if (root.right != null) {
            rightDepth = dfs(root.right) + 1;
        }
        max = Math.max(max, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth);
    }
}

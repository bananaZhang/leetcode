package leetcode;


import leetcode.common.TreeNode;

/**
 * 二叉树的直径
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

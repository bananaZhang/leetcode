package leetcode;

import leetcode.common.TreeNode;

/**
 * 翻转二叉树
 * @author: ZJY
 * @date: 2022/5/22 5:08 下午
 */
public class Leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(right);
        return root;
    }
}

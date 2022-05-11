package leetcode;

import leetcode.common.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
 * 字节题
 * 递归
 * @author: ZJY
 * @date: 2022/4/10 10:37 下午
 */
public class Leetcode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 自下而上，找到p或q节点了，或者到叶子节点了，都直接返回
        if (root == p || root == q || root == null) {
            return root;
        }
        // 左子树中找p或q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 右子树中找p或q
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 都不为null，说明左右子树分别找到了p和q
        if (left != null && right != null) {
            return root;
        }
        // 左子树不为null，说明左子树中找到了公共祖先
        if (left != null) {
            return left;
        }
        // 右子树不为null，说明右子树中找到了公共祖先
        if (right != null) {
            return right;
        }
        return null;
    }
}

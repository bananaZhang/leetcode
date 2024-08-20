package leetcode;

import leetcode.common.TreeNode;
/**
 * 二叉树的最大路径和
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * @author: ZJY
 * @date: 2022/5/17 10:46 下午
 */
public class Leetcode124 {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        scan(root);
        return max;
    }

    /**
     * 先明确一点：能组成最大路径和的节点肯定也是一颗二叉树
     */
    private int scan(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 左子树最大值，如果小于0，那么没必要加入计算了
        int left = Math.max(scan(node.left), 0);
        // 右子树最大值，如果小于0，那么没必要加入计算了
        int right = Math.max(scan(node.right), 0);
        // 计算以当前节点为根节点的最大值
        max = Math.max(max, node.val + left + right);
        // 如果是(根)或(根+左)或(根+右)的组合，则还可以向上找，组成更大的二叉树
        return Math.max(left, right) + node.val;
    }
}

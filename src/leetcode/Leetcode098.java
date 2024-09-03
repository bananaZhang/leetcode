package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证二叉搜索树
 * @author: ZJY
 * @date: 2022/6/5 1:10 下午
 */
public class Leetcode098 {
    public boolean isValidBST(TreeNode root) {
        return judge(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // lower：节点值的下界
    // upper：节点值的上界
    public boolean judge(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return judge(node.left, lower, node.val) && judge(node.right, node.val, upper);
    }

    public static void main(String[] args) {

    }
}

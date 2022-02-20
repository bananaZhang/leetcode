package leetcode;

import leetcode.common.TreeNode;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * @author: ZJY
 * @date: 2022/2/20 5:15 下午
 */
public class Leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Stack<TreeNode> stackOdd = new Stack<>();
        Stack<TreeNode> stackEven = new Stack<>();
        stackOdd.add(root);
        int level = 1;
        while (!stackOdd.isEmpty() || !stackEven.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (level % 2 == 1 && !stackOdd.isEmpty()) {
                TreeNode node = stackOdd.pop();
                list.add(node.val);
                if (node.left != null) {
                    stackEven.add(node.left);
                }
                if (node.right != null) {
                    stackEven.add(node.right);
                }
            }
            while (level % 2 == 0 && !stackEven.isEmpty()) {
                TreeNode node = stackEven.pop();
                list.add(node.val);
                if (node.right != null) {
                    stackOdd.add(node.right);
                }
                if (node.left != null) {
                    stackOdd.add(node.left);
                }
            }
            level ++;
            resultList.add(list);
        }
        return resultList;
    }
}

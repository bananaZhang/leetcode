package leetcode;

import leetcode.common.TreeNode;
import leetcode.common.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序遍历，左中右
 * @author: ZJY
 * @date: 2021/12/11 8:31 下午
 */
public class Leetcode094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preTraversal(root, result);
        return result;
    }

    public void preTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        preTraversal(node.left, list);
        list.add(node.val);
        preTraversal(node.right, list);
    }

    /*
     * 栈解法
     */
    public List<Integer> inorderTraversalWithStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildBinaryTree();
        List<Integer> result = new Leetcode094().inorderTraversalWithStack(root);
        System.out.println(result);
    }
}

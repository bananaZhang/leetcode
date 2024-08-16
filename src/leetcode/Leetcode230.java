package leetcode;

import leetcode.common.TreeNode;
import leetcode.common.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class Leetcode230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        traverse(list, root, k);
        return list.get(k-1);
    }

    private void traverse(List<Integer> list, TreeNode root, int k) {
        if (root.left != null) {
            traverse(list, root.left, k);
        }
        list.add(root.val);
        if (root.right != null) {
            traverse(list, root.right, k);
        }
    }

    public static void main(String[] args) {

        System.out.println(new Leetcode230().kthSmallest(TreeUtil.buildBinaryTree(), 1));
    }
}

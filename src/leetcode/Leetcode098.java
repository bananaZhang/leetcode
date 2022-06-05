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
    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        traverse(root);
        boolean result = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i-1)) {
                return false;
            }
        }
        return result;
    }

    public void traverse(TreeNode root) {
        if (root.left != null) {
            traverse(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            traverse(root.right);
        }
    }

    public static void main(String[] args) {

    }
}

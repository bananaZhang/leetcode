package leetcode.common;

public class TreeUtil {

    public static TreeNode buildBinaryTree(Integer... nums) {
        TreeNode[] nodes = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = nums[i] == null ? null : new TreeNode(nums[i]);
        }
        for (int i = nodes.length-1; i >= 0; i--) {
            if (nodes[i] == null) {
                continue;
            }
            if (i % 2 == 0) {
                int rootIdx = (i-2) / 2;
                if (rootIdx >= 0 && nodes[rootIdx] != null) {
                    TreeNode root = nodes[rootIdx];
                    root.right = nodes[i];
                }
            } else {
                int rootIdx = (i-1) / 2;
                TreeNode root = nodes[rootIdx];
                root.left = nodes[i];
            }
        }
        return nodes[0];
    }

    /**
     *              1
     *             / \
     *            2   3
     *           / \   \
     *          4   5   6
     *             / \  /
     *            7   8 9
     */
    public static TreeNode buildBinaryTree() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;
        treeNode5.left = treeNode7;
        treeNode5.right = treeNode8;
        treeNode6.left = treeNode9;

        return treeNode1;
    }
}

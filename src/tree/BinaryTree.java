package tree;

import java.util.Stack;

/**
 * @author ZJY
 * @ClassName: BinaryTree
 * @Description: BinaryTree
 * @date 2019/3/27 16:10
 */
public class BinaryTree {

    public static void main(String[] args) {
        BiNode node = createTree();
        System.out.println("前序遍历递归:");
        preTraverse(node);
        System.out.println("中序遍历递归:");
        midTraverse(node);
        System.out.println("后序遍历递归:");
        lastTraverse(node);
    }

    /************* 递归三种遍历 start **************/
    public static void preTraverse(BiNode root) {
        System.out.println(root.value);
        if (null != root.left) {
            preTraverse(root.left);
        }
        if (null != root.right) {
            preTraverse(root.right);
        }
    }

    public static void midTraverse(BiNode root) {
        if (null != root.left) {
            midTraverse(root.left);
        }
        System.out.println(root.value);
        if (null != root.right) {
            midTraverse(root.right);
        }
    }

    public static void lastTraverse(BiNode root) {
        if (null != root.left) {
            lastTraverse(root.left);
        }
        if (null != root.right) {
            lastTraverse(root.right);
        }
        System.out.println(root.value);
    }
    /************* 递归三种遍历 end **************/

    /************* 栈三种遍历 start **************/
    public static void preTraverseStack(BiNode root) {
        Stack<String> stack = new Stack<>();
        while (root != null) {
            System.out.println(root.value);
        }
    }

    private static BiNode createTree() {
        BiNode node1 = new BiNode("1");
        BiNode node2 = new BiNode("2");
        BiNode node3 = new BiNode("3");
        BiNode node4 = new BiNode("4");
        BiNode node5 = new BiNode("5");
        BiNode node6 = new BiNode("6");
        BiNode node7 = new BiNode("7");

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        return node1;
    }
}

/**
 * 二叉树节点
 */
class BiNode {
    String value;
    BiNode left;
    BiNode right;

    BiNode(String value) {
        this.value = value;
    }
}


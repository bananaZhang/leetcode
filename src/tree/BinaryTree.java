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
        System.out.print("\n前序遍历递归: ");
        preTraverse(node);
        System.out.print("\n前序遍历栈:   ");
        preTraverseStack(node);
        System.out.print("\n中序遍历递归: ");
        midTraverse(node);
        System.out.print("\n中序遍历栈:   ");
        midTraverseStack(node);
        System.out.print("\n后序遍历递归: ");
        lastTraverse(node);
        System.out.print("\n后序遍历栈:   ");
        lastTraverseStack(node);
    }

    /************* 递归三种遍历 start **************/
    public static void preTraverse(BiNode root) {
        System.out.print(root.value + " ");
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
        System.out.print(root.value + " ");
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
        System.out.print(root.value + " ");
    }
    /************* 递归三种遍历 end **************/

    /************* 栈三种遍历 start **************/
    public static void preTraverseStack(BiNode root) {
        Stack<BiNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            // 先访问根节点
            BiNode cur = stack.peek();
            System.out.print(cur.value + " ");
            stack.pop();
            // 先放入右节点再放入左节点，因为栈的特性，先进后出
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public static void midTraverseStack(BiNode root) {
        Stack<BiNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            BiNode cur = stack.peek();
            // 进入当前节点的最左节点
            while (cur.left != null) {
                stack.push(cur.left);
                cur = cur.left;
            }
            while (!stack.empty()) {
                cur = stack.peek();
                System.out.print(cur.value + " ");
                stack.pop();
                if (cur.right != null) {
                    stack.push(cur.right);
                    break;// 跳出该层循环，进入外层循环干到刚进栈右节点的最左节点
                }
            }
        }
    }

    public static void lastTraverseStack(BiNode root) {
        Stack<BiNode> stack = new Stack<>();
        stack.push(root);
        BiNode lastPop = null;// 上一次出栈的节点
        while (!stack.empty()) {
            BiNode cur = stack.peek();
            // 进入当前节点的最左节点
            while (cur.left != null) {
                stack.push(cur.left);
                cur = cur.left;
            }
            while (!stack.empty()) {
                cur = stack.peek();
                // 需要判断右节点是不是上次出栈的节点，否则会不停的将右节点压入栈中
                if (cur.right != null && cur.right != lastPop) {
                    stack.push(cur.right);
                    break;// 跳出该层循环，进入外层循环干到刚进栈右节点的最左节点
                }
                System.out.print(cur.value + " ");
                lastPop = cur;
                stack.pop();
            }
        }
    }

    /************* 栈三种遍历 end **************/

    private static BiNode createTree() {
        BiNode node1 = new BiNode("1");
        BiNode node2 = new BiNode("2");
        BiNode node3 = new BiNode("3");
        BiNode node4 = new BiNode("4");
        BiNode node5 = new BiNode("5");
        BiNode node6 = new BiNode("6");
        BiNode node7 = new BiNode("7");
        BiNode node8 = new BiNode("8");
        BiNode node9 = new BiNode("9");

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;

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


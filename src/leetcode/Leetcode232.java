package leetcode;

import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）
 * @author: ZJY
 * @date: 2021/11/28 9:33 下午
 */
public class Leetcode232 {

    Stack<Integer> storageStack;
    Stack<Integer> readStack;

    public Leetcode232() {
        storageStack = new Stack<>();
        readStack = new Stack<>();
    }

    public void push(int x) {
        if (storageStack.isEmpty() && !readStack.isEmpty()) {
            copyStack(readStack, storageStack);
        }
        storageStack.push(x);
    }

    public int pop() {
        if (readStack.isEmpty()) {
            copyStack(storageStack, readStack);
        }
        return readStack.pop();
    }

    public int peek() {
        if (readStack.isEmpty()) {
            copyStack(storageStack, readStack);
        }
        return readStack.peek();
    }

    public boolean empty() {
        return readStack.isEmpty() && storageStack.isEmpty();
    }

    private void copyStack(Stack<Integer> source, Stack<Integer> target) {
        while (!source.isEmpty()) {
            target.push(source.pop());
        }
    }
}

package leetcode;

import java.util.Stack;

/**
 * 每日温度
 * 单调栈
 * @author: ZJY
 * @date: 2022/4/29 10:44 下午
 */
public class Leetcode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        // 倒着往栈里面放
        for (int i = temperatures.length - 1; i >= 0; i--) {
            // 栈顶元素比自己小，就踢走
            while (!stack.empty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            // 如果栈内没有比自己更大的，证明从i往后自己就是最大的，否则求出比自己大的元素和自己的距离
            res[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}

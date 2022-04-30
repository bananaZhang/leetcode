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
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.empty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}

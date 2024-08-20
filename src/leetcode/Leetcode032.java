package leetcode;

import java.util.Stack;

/**
 * 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * @author: ZJY
 * @date: 2022/5/21 9:06 下午
 */
public class Leetcode032 {
    /**
     * 用栈模拟一遍，将所有无法匹配的括号的位置全部置1
     * 转化为求数组中最长连续0的长度
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] mark = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add(i);
            } else {
                // 多余的右括号不要
                if (stack.isEmpty()) {
                    mark[i] = 1;
                } else {
                    stack.pop();
                }
            }
        }
        // 多余的左括号不要
        while (!stack.isEmpty()) {
            mark[stack.pop()] = 1;
        }
        int max = 0;
        int count = 0;
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] == 1) {
                count = 0;
            } else {
                count++;
                max = Math.max(count, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "(()";
        System.out.println(new Leetcode032().longestValidParentheses(s));
    }
}

package leetcode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * @author: ZJY
 * @date: 2020/8/15 5:18 下午
 */
public class Leetcode020 {
    public boolean isValid(String s) {
        if (s.trim().length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (c == ')') {
                char topChar = stack.pop();
                if (topChar != '(') {
                    return false;
                }
            }
            if (c == ']') {
                char topChar = stack.pop();
                if (topChar != '[') {
                    return false;
                }
            }
            if (c == '}') {
                char topChar = stack.pop();
                if (topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode020().isValid("()[[]{]]}"));
    }
}

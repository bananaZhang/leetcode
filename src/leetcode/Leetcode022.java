package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 回溯法
 * @author: ZJY
 * @date: 2022/1/2 10:46 下午
 */
public class Leetcode022 {
    private List<String> resultList = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, n, "");
        return resultList;
    }

    private void backtrack(int left, int right, String str) {
        if (left == 0 && right == 0) {
            resultList.add(str);
            return;
        }
        if (left > 0) {
            backtrack(left - 1, right, str + "(");
        }
        if (right > left) {
            backtrack(left, right - 1, str + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode022().generateParenthesis(2));
    }
}

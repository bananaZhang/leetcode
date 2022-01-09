package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 回溯法
 * @author: ZJY
 * @date: 2022/1/9 7:08 下午
 */
public class Leetcode077 {
    private List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(k, 0, n, new ArrayList<>());
        return resultList;
    }

    private void backtrack(int k, int start, int n, List<Integer> list) {
        if (k == 0) {
            resultList.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < n; i++) {
            list.add(i + 1);
            backtrack(k - 1, i + 1, n, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode077().combine(4, 2));
    }
}

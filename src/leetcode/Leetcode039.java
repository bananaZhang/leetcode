package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * 回溯法
 * @author: ZJY
 * @date: 2022/1/3 12:20 下午
 */
public class Leetcode039 {

    private List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>());
        return resultList;
    }

    private void backtrack(int[] candidates, int target, int begin, List<Integer> result) {
        int sum = result.stream().reduce(Integer::sum).orElse(0);
        if (sum == target) {
            resultList.add(new ArrayList<>(result));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                return;
            }
            result.add(candidates[i]);
            backtrack(candidates, target, i, result);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        System.out.println(new Leetcode039().combinationSum(candidates, 7));
    }
}

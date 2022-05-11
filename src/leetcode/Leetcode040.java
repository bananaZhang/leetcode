package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 回溯法
 * 字节题
 * @author: ZJY
 * @date: 2022/1/3 7:24 下午
 */
public class Leetcode040 {
    private List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>());
        return resultList;
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> result) {
        if (target == 0) {
            resultList.add(new ArrayList<>(result));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                return;
            }
            // 这一步去重判断非常重要，对排好序的数组来说，如果后一个index的数和前一个相同，那么肯定存在了
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            result.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, result);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(new Leetcode040().combinationSum2(candidates, 8));
    }
}

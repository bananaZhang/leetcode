package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 回溯法
 * @author: ZJY
 * @date: 2022/1/8 4:51 下午
 */
public class Leetcode046 {
    private List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, 0, new ArrayList<>(nums.length));
        return resultList;
    }

    private void backtrack(int[] nums, int index, List<Integer> result) {
        if (index == nums.length) {
            resultList.add(new ArrayList<>(result));
            return;
        }
        for (int num : nums) {
            if (result.contains(num)) {
                continue;
            }
            result.add(num);
            backtrack(nums, index + 1, result);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Leetcode046().permute(nums));
    }
}

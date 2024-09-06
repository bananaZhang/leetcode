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
        int[] visited = new int[nums.length];
        backtrack(nums, visited, new ArrayList<>(nums.length));
        return resultList;
    }

    private void backtrack(int[] nums, int[] visited, List<Integer> result) {
        if (result.size() == nums.length) {
            resultList.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            result.add(nums[i]);
            visited[i] = 1;
            backtrack(nums, visited, result);
            result.remove(result.size() - 1);
            visited[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Leetcode046().permute(nums));
    }
}

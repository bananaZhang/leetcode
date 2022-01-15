package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 回溯法
 * @author: ZJY
 * @date: 2022/1/9 8:15 下午
 */
public class Leetcode090 {
    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, false, new ArrayList<>());
        return resultList;
    }

    /**
     * 自己总结的：当前一个数和当前数相同，且前一个数选择了没放入，那么当前数肯定也不能放入
     */
    private void backtrack(int[] nums, int index, boolean isStore, List<Integer> list) {
        if (nums.length == index) {
            resultList.add(new ArrayList<>(list));
            return;
        }
        int preNum = index > 0 ? nums[index - 1] : Integer.MIN_VALUE;
        // 当前数字不算入组合中
        backtrack(nums, index + 1, false, list);
        if (preNum != nums[index] || isStore) {
            // 当前数字算入组合中
            list.add(nums[index]);
            backtrack(nums, index + 1, true, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        System.out.println(new Leetcode090().subsetsWithDup(nums));
    }
}

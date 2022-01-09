package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 回溯法
 * @author: ZJY
 * @date: 2022/1/9 7:20 下午
 */
public class Leetcode078 {
    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return resultList;
    }

    private void backtrack(int[] nums, int index, List<Integer> list) {
        if (nums.length == index) {
            resultList.add(new ArrayList<>(list));
            return;
        }
        // 当前数字不算入组合中
        backtrack(nums, index + 1, list);
        // 当前数字算入组合中
        list.add(nums[index]);
        backtrack(nums, index + 1, list);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Leetcode078().subsets(nums));
    }
}

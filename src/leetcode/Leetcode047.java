package leetcode;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 回溯法
 * 字节题
 * @author ZJY
 * @date 2019/3/11 19:04
 */
public class Leetcode047 {

    private List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return resultList;
    }

    /**
     * 其实这个全排列算法就是固定一个数的位置(index)，然后从下一位数再开始全排列(递归过程)...直到最后一位数，
     * 模拟手动全排列的过程。所以如果要去重的话，只要控制每次排列时，固定的那个数是不一样的就行了。
     * 因为固定的数不一样，那从这个数开始产生的全排列就不一样。所以只要让每次的index位置的数不一样就行
     */
    private void backtrack(int[] nums, int index, List<Integer> result) {
        if (index == nums.length) {
            resultList.add(new ArrayList<>(result));
            return;
        }
        // 存储位于过index位置的数
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            // index位置没有存在过该数才走下面的递归流程
            if (i != index && set.contains(nums[i])) {
                continue;
            }
            result.add(nums[i]);
            set.add(nums[i]);
            swap(nums, index, i);
            backtrack(nums, index + 1, result);
            swap(nums, index, i);
            result.remove(result.size() - 1);
        }
    }

    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1};
        System.out.println(new Leetcode047().permuteUnique(nums));
    }
}

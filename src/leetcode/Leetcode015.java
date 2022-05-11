package leetcode;

import java.util.*;

/**
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 * 字节题
 * @author: ZJY
 * @date: 2022/2/12 7:53 下午
 */
public class Leetcode015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        // 如果排序后的第一个数大于0，那么就不可能存在三元组
        if (nums.length == 0 || nums[0] > 0) {
            return resultList;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            // 构建双指针
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left ++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right --;
                } else {
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
                    while (nums[right] == nums[right-1] && left < right) {
                        right--;
                    }
                    while (nums[left] == nums[left+1] && left < right) {
                        left ++;
                    }
                    // 找到答案时，双指针同时收缩
                    left ++;
                    right --;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = new Leetcode015().threeSum(nums);
        System.out.println(list);
    }
}

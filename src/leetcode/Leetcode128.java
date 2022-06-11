package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * @author: ZJY
 * @date: 2022/6/11 10:10 下午
 */
public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            // 剪枝，如果nums[i]的前一个值存在，那么就不需要重复计算了
            if (set.contains(nums[i] - 1)) {
                continue;
            }
            int target = nums[i] + 1;
            int len = 1;
            while (set.contains(target)) {
                target++;
                len++;
            }
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }
}

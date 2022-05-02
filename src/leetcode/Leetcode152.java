package leetcode;

import java.util.Arrays;

/**
 * 乘积最大子数组
 * 动态规划（两个dp数组）
 * @author: ZJY
 * @date: 2022/5/2 10:22 下午
 */
public class Leetcode152 {
    public int maxProduct(int[] nums) {
        int[] minDp = Arrays.copyOf(nums, nums.length);
        int[] maxDp = Arrays.copyOf(nums, nums.length);
        // 由于nums[i]可能是负数，所以有可能最小值与其相乘会得到一个很大的值
        // dp公式：dp[i]=max(nums[i], dp[i-1].min * nums[i], dp[i-1].max * nums[i]);
        for (int i = 1; i < nums.length; i++) {
            maxDp[i] = Math.max(maxDp[i - 1] * nums[i], Math.max(nums[i], minDp[i - 1] * nums[i]));
            minDp[i] = Math.min(minDp[i - 1] * nums[i], Math.min(nums[i], maxDp[i - 1] * nums[i]));
        }
        return Arrays.stream(maxDp).max().getAsInt();
    }
}

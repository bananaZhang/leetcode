package leetcode;

/**
 * 最大连续子数组的和
 * 动态规划
 * @author: ZJY
 * @date: 2022/1/15 9:43 下午
 */
public class Leetcode053 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            // 如果sum大于0，证明前面子序列的和大于0，可以再加上当前num；sum小于0则可以放弃前面的子序列了
            if (sum >= 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(sum, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,-1,-3,-4,-1,-2,-1,-5,-4};
        System.out.println(new Leetcode053().maxSubArray(nums));
    }
}

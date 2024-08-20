package leetcode;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 * @author: ZJY
 * @date: 2021/12/19 9:33 下午
 */
public class Leetcode209 {
    // 用滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minLength = nums.length + 1;
        int sum = nums[left];
        while (left < nums.length) {
            if (sum < target) {
                if (right < nums.length - 1) {
                    right++;
                    sum += nums[right];
                } else {
                    break;
                }
            } else {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return (minLength == nums.length + 1) ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
//        System.out.println(new Leetcode209().minSubArrayLen(7, nums));

        nums = new int[]{1,2,3,4,5};
        System.out.println(new Leetcode209().minSubArrayLen(15, nums));
    }
}

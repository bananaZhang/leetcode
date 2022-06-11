package leetcode;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * @author: ZJY
 * @date: 2022/6/11 9:16 下午
 */
public class Leetcode016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestValue = Integer.MAX_VALUE;
        int result = closestValue;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int threeSum = nums[left] + nums[right] + nums[i];
                if (threeSum < target) {
                    left++;
                } else if (threeSum > target) {
                    right--;
                } else {
                    return target;
                }
                if (Math.abs(target - threeSum) <= closestValue) {
                    closestValue = Math.abs(target - threeSum);
                    result = threeSum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 1, -3};
        System.out.println(new Leetcode016().threeSumClosest(nums, 1));
    }
}

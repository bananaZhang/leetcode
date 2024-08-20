package leetcode;

/**
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * @author: ZJY
 * @date: 2021/12/19 8:37 下午
 */
public class Leetcode162 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,3,5,6,4};
        System.out.println(new Leetcode162().findPeakElement(nums));// 5

        nums = new int[]{1,2};
        System.out.println(new Leetcode162().findPeakElement(nums));// 1

        nums = new int[]{1,2,3,1};
        System.out.println(new Leetcode162().findPeakElement(nums));// 2
    }
}

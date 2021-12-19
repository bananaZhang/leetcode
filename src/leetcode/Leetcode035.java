package leetcode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * @author: ZJY
 * @date: 2021/12/19 3:31 下午
 */
public class Leetcode035 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        // 当target小于nums[end]的时候，end=-1
        // 当target大于nums[end]的时候，end=length
        return end + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3};
        int target = 0;
        System.out.println(new Leetcode035().searchInsert(nums, target));
    }
}

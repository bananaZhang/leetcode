package leetcode;

/**
 * 剑指 Offer 53 - 统计一个数字在排序数组中出现的次数（二分查找）。
 * @author: ZJY
 * @date: 2021/12/13 10:15 下午
 */
public class Offer053 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int start = findFirstIndex(nums, target);
        if (start == -1) {
            return 0;
        }
        int end = findLastIndex(nums, target);
        return end - start + 1;
    }

    private int findFirstIndex(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] == target) {
                // [left, mid]
                right = mid;
            } else {
                // [left, mid-1]
                right = mid - 1;
            }
        }
        if (nums[left] != target) {
            return -1;
        }
        return left;
    }

    private int findLastIndex(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] < target) {
                // [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] == target) {
                // [mid, right]
                left = mid;
            } else {
                // [left, mid-1]
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,7,7,8,8,10};
        System.out.println(new Offer053().search(arr, 8));
    }
}

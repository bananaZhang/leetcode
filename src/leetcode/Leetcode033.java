package leetcode;

/**
 * 搜索旋转排序数组
 * @author: ZJY
 * @date: 2022/4/16 10:08 下午
 */
public class Leetcode033 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 前半段有序
            if (nums[mid] > nums[right]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            // 后半段有序
            } else {
                // 后半段最大值比target小
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(new Leetcode033().search(nums, 0));
    }
}

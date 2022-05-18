package leetcode;

/**
 * 二分查找
 * @author: ZJY
 * @date: 2022/5/18 10:00 下午
 */
public class Leetcode704 {
    public int search(int[] nums, int target) {
        int p = 0;
        int q = nums.length - 1;
        while (p <= q) {
            int mid = p + (q - p) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                p = mid + 1;
            } else {
                q = mid - 1;
            }
        }
        return -1;
    }
}

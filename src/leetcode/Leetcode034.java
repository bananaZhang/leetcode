package leetcode;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * @author: ZJY
 * @date: 2022/4/30 10:13 下午
 */
public class Leetcode034 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                int i = mid - 1;
                while (i >= 0 && target == nums[i]) {
                    i--;
                }
                res[0] = i + 1;
                int j = mid + 1;
                while (j < nums.length && target == nums[j]) {
                    j++;
                }
                res[1] = j - 1;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        System.out.println(new Leetcode034().searchRange(nums, 8));

    }
}

package leetcode;

/**
 * 寻找两个正序数组的中位数
 * @author: ZJY
 * @date: 2022/4/24 10:32 下午
 */
public class Leetcode004 {
    /**
     * hard题，有个比较牛b的方法使用二分法，但我不会写
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] nums = new int[len / 2 + 1];
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length && i+j < nums.length) {
            if (nums1[i] > nums2[j]) {
                nums[i+j] = nums2[j];
                j++;
            } else {
                nums[i+j] = nums1[i];
                i++;
            }
        }
        // 没有填充满nums数组的情况
        if (nums[nums.length - 1] == 0) {
            if (i == nums1.length) {
                while (i+j < nums.length) {
                    nums[i+j] = nums2[j++];
                }
            } else {
                while (i+j < nums.length) {
                    nums[i+j] = nums1[i++];
                }
            }
        }
        if (len % 2 > 0) {
            return nums[nums.length - 1];
        }
        return ((double)nums[nums.length - 1] + (double)nums[nums.length - 2]) / 2;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 2, 4, 4};
        int[] nums2 = new int[]{2, 2, 4, 4};
        System.out.println(new Leetcode004().findMedianSortedArrays(nums1, nums2));
    }
}

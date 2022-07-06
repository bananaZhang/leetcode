package leetcode;

/**
 * 多数元素：摩尔投票法
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * @author: ZJY
 * @date: 2022/7/6 9:41 上午
 */
public class Leetcode169 {
    public int majorityElement(int[] nums) {
        int ret = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != ret) {
                count--;
            } else {
                count++;
            }
            if (count < 0) {
                ret = nums[i];
                count = 1;
            }
        }
        return ret;
    }
}

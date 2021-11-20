package leetcode;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * @author: ZJY
 * @date: 2021/11/20 9:02 下午
 */
public class Leetcode027 {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[j++] = nums[i];
        }
        return j;
    }
}

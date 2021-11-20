package leetcode;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @author: ZJY
 * @date: 2020/8/22 9:57 下午
 */
public class Leetcode026 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return nums.length;
        }
        // i为快指针，用来扫描
        // j为慢指针，指向可以复制的位置
        int j = 0;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 2, 3, 3,3,4,4,5,6,6,7,7};
        int j = new Leetcode026().removeDuplicates(arr);
        for (int i = 0; i < j; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

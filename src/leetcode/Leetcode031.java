package leetcode;

import java.util.Arrays;

/**
 * 下一个排列
 * @author: ZJY
 * @date: 2022/5/21 8:08 下午
 */
public class Leetcode031 {
    /*
     * 找到nums[i - 1] < nums[i]，再找i~end中比nums[i - 1]大的最小值与nums[i - 1]交换，
     * 最后对i~end排序， 没找到就反转nums
     *
     * 例如 2, 6, 3, 5, 4, 1 这个排列， 我们想要找到下一个刚好比他大的排列，
     * 于是可以从后往前看 我们先看后两位 4, 1 能否组成更大的排列，答案是不可以，
     * 同理 5, 4, 1也不可以 直到3, 5, 4, 1这个排列，因为 3 < 5，
     * 我们可以通过重新排列这一段数字，来得到下一个排列 因为我们需要使得新的排列尽量小，
     * 所以我们从后往前找第一个比3更大的数字，发现是4 然后，我们调换3和4的位置，
     * 得到4, 5, 3, 1这个数列 因为我们需要使得新生成的数列尽量小，于是我们可以对5, 3, 1进行排序，
     * 可以发现在这个算法中，我们得到的末尾数字一定是倒序排列的，
     * 于是我们只需要把它反转即可 最终，我们得到了4, 1, 3, 5这个数列 完整的数列则是2, 6, 4, 1, 3, 5
     */
    public void nextPermutation(int[] nums) {
        int swap1 = -1;
        // 找到需要交换的第一个值的坐标
        for (int i = nums.length - 1; i >= 0; i--) {
            // 此时不会组成下一个排列
            if (i > 0 && nums[i] <= nums[i-1]) {
                continue;
            }
            swap1 = i - 1;
            break;
        }
        // 没有找到直接反转数组返回
        if (swap1 == -1) {
            Arrays.sort(nums);
            return;
        }
        // 找到需要交换的第二个值的坐标
        int swap2 = -1;
        for (int i = nums.length - 1; i >= swap1; i--) {
            if (nums[i] > nums[swap1]) {
                swap2 = i;
                break;
            }
        }
        // 交换swap1和swap2
        int temp = nums[swap1];
        nums[swap1] = nums[swap2];
        nums[swap2] = temp;
        // 对swap1后的元素进行排序
        Arrays.sort(nums, swap1+1, nums.length);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,9,8,7,6};
        new Leetcode031().nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }
}

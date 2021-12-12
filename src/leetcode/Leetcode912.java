package leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * @author: ZJY
 * @date: 2021/12/12 8:58 下午
 */
public class Leetcode912 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int index = partition(nums, start, end);
            quickSort(nums, start, index - 1);
            quickSort(nums, index + 1, end);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int p = start;
        int q = end;
        while (p < q) {
            // 这里必须要把 q 放在前面，否则循环完的 p 位置不对
            if (nums[q] >= pivot) {
                q --;
                continue;
            }
            if (nums[p] <= pivot) {
                p ++;
                continue;
            }
            swap(nums, p, q);
        }
        swap(nums, start, p);
        return p;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 8, 1, 3, 5, 2, 6, 9, 0, 4, 1, 6};
        new Leetcode912().sortArray(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}

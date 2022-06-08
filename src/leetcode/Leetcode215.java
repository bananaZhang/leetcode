package leetcode;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 滴滴题、字节题
 * @author: ZJY
 * @date: 2021/12/12 8:24 下午
 */
public class Leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        return find(nums, 0, nums.length - 1, k);
    }

    private int find(int[] nums, int start, int end, int k) {
        int index = findPartition(nums, start, end);
        if (nums.length - index == k) {
            return nums[index];
        }
        if (nums.length - index > k) {
            return find(nums, index + 1, end, k);
        } else {
            return find(nums, start, index - 1, k);
        }
    }

    private int findPartition(int[] nums, int start, int end) {
        int p = start;
        int q = end;
        int pivot = nums[start];
        while (p < q) {
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
        int[] arr = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(new Leetcode215().findKthLargest(arr, 4));
    }
}

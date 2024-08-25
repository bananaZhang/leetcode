package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 滑动窗口最大值 单调队列
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * @author: ZJY
 * @date: 2022/6/12 4:38 下午
 */
public class Leetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return nums;
        }
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 需要添加的元素比队尾元素大，需要将队尾元素出队，保持队列单调递减
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
            // 队头元素和当前元素距离大于k了，需要将队头元素出队
            if (i - queue.peek() >= k) {
                queue.poll();
            }
            // 计算窗口最大值
            if (i - k + 1 >= 0) {
                res[i-k+1] = nums[queue.peek()];
            }
        }
        return res;
    }

    /**
     * 解法2: 使用优先级队列
     * */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, nums[i]);
            queue.add(new int[]{nums[i], i});
        }
        int[] maxArr = new int[nums.length-k+1];
        maxArr[0] = max;
        for (int left = 1, right = k; right < nums.length; left++, right++) {
            queue.add(new int[]{nums[right], right});
            while (queue.peek()[1] <= right - k) {
                queue.poll();
            }
            maxArr[left] = queue.peek()[0];
        }
        return maxArr;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] res = new Leetcode239().maxSlidingWindow(nums, 3);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}

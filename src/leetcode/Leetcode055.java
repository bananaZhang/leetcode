package leetcode;

/**
 * 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 我这里用的是dp，leetcode上大神的解答思路没看懂
 * @author: ZJY
 * @date: 2022/1/16 5:42 下午
 */
public class Leetcode055 {
    private boolean[] canReach;

    public boolean canJump(int[] nums) {
        canReach = new boolean[nums.length];
        canReach[0] = true;
        jump(nums, 0);
        return canReach[nums.length - 1];
    }

    public void jump(int[] nums, int pos) {
        for (int i = 1; i <= nums[pos]; i++) {
            // 确认可以跳到后就不跳了
            if (canReach[nums.length - 1]) {
                return;
            }
            // 跳出去或跳过当前位置也不跳了
            if (pos + i > nums.length - 1 || canReach[pos + i]) {
                continue;
            }
            canReach[pos + i] = true;
            jump(nums, pos + i);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        System.out.println(new Leetcode055().canJump(nums));
    }
}

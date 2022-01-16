package leetcode;

/**
 * 跳跃游戏
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

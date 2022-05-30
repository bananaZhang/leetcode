package leetcode;

/**
 * 跳跃游戏2
 * 贪心
 * @author: ZJY
 * @date: 2022/5/30 9:42 下午
 */
public class Leetcode045 {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; ) {
            // 当前位置可以跳到的最远位置
            int jumpDis = i + nums[i];
            if (jumpDis >= nums.length - 1) {
                count++;
                break;
            } else {
                // 跳到[i+1, jumpDis]中的最大值
                int next = i + 1;
                for (int j = i + 1; j <= jumpDis; j++) {
                    next = nums[next] + next > nums[j] + j ? next : j;
                }
                i = next;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,8,7,6,5,4,3,2,1,1,0};
        System.out.println(new Leetcode045().jump(nums));
    }
}

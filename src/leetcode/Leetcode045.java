package leetcode;

/**
 * 跳跃游戏2 贪心
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
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

package leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * 动态规划
 * @author: ZJY
 * @date: 2022/1/10 10:19 下午
 */
public class Leetcode322 {
    private int[] minStep;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        minStep = new int[amount + 1];
        Arrays.fill(minStep, Integer.MAX_VALUE);// 填充默认值
        backtrack(coins, amount, 0);
        if (minStep[0] == Integer.MAX_VALUE) {
            return -1;
        }
        return minStep[0];
    }

    private void backtrack(int[] coins, int amount, int step) {
        if (amount == 0) {
            minStep[amount] = Math.min(minStep[amount], step);
            return;
        }
        for (int coin : coins) {
            int remain = amount - coin;
            // 剪枝
            if (remain >= 0 && (step+1 < minStep[remain])) {
                minStep[remain] = step + 1;
                backtrack(coins, amount - coin, step + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        System.out.println(new Leetcode322().coinChange(coins, 100));
    }
}

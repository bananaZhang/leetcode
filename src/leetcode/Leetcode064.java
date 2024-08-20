package leetcode;

/**
 * 最小路径和 动态规划
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * @author: ZJY
 * @date: 2022/5/1 10:06 下午
 */
public class Leetcode064 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }
                if (i > 0 && j == 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
                if (i == 0 && j > 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}

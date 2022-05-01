package leetcode;

/**
 * 最小路径和
 * 动态规划
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

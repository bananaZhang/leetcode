package leetcode;

/**
 * 最长公共子序列
 * @author: ZJY
 * @date: 2022/6/8 9:56 下午
 */
public class Leetcode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j], Math.max(dp[i+1][j], dp[i][j+1]));
                }
            }
        }
        return dp[len1][len2];
    }
}

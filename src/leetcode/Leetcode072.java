package leetcode;

/**
 * 最小编辑距离
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 你可以对一个单词进行如下三种操作：插入一个字符、删除一个字符、替换一个字符
 * 动态规划
 * @author: ZJY
 * @date: 2022/5/26 10:31 下午
 */
public class Leetcode072 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 要从两个字符串的第一个字符开始遍历
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int min = Math.min(dp[i-1][j], dp[i][j-1]);
                    dp[i][j] = Math.min(min, dp[i-1][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {

    }
}

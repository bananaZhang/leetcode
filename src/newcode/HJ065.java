package newcode;

import java.util.Scanner;

/**
 * 查找两个字符串a,b中的最长公共子串
 * 输入：
 * abcdefghijklmnop
 * abcsafjklmnopqrstuvw
 * @author: ZJY
 * @date: 2022/4/23 12:48 下午
 */
public class HJ065 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        int[][] dp = new int[str1.length()][str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i > 0 && j > 0) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    index = i;
                }
            }
        }
        System.out.println(str1.substring(index - max + 1, index + 1));
    }
}

package leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 动态规划
 * @author: ZJY
 * @date: 2019/6/6 下午1:56
 */
public class Leetcode005 {

    public String longestPalindrome(String s) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        String result = "";
        char[] charArr = s.toCharArray();
        // 回文字串的左边界和右边界
        int left = 0, right = 0;
        for (int i = 0; i < charArr.length; i++) {
            for (int j = i; j < charArr.length; j++) {
                // 边界内就不需要再判断了
                if (i >= left && j <= right) {
                    continue;
                }
                // 如果比已经求出的回文串长，则更新
                if (isPalindrome(i, j, charArr) && ((j-i+1) > result.length())) {
                    result = s.substring(i, j+1);
                    left = i;
                    right = j;
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(int i, int j, char[] chars) {
        if (i == j) {
            return true;
        }
        while (j >= i) {
            if (chars[i++] != chars[j--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode005().longestPalindrome("a"));
    }
}

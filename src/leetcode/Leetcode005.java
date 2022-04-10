package leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @author: ZJY
 * @date: 2022/4/10 10:04 下午
 */
public class Leetcode005 {

    private int maxLen = 1;
    private int start = 0;
    private int end = 0;

    public String longestPalindrome(String s) {
        char[] charArr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            // 以i为中心
            isPalindrome(charArr, i, i, s.length());
            // 以i和i+1为中心
            isPalindrome(charArr, i, i+1, s.length());
        }
        return s.substring(start, end + 1);
    }

    private void isPalindrome(char[] charArr, int i, int j, int n) {
        // 双指针判断
        while (i >= 0 && j < n && charArr[i] == charArr[j]) {
            int length = j - i + 1;
            // 只有超过最大回文的长度才记录
            if (length > maxLen) {
                maxLen = length;
                start = i;
                end = j;
            }
            i--;
            j++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode005().longestPalindrome("a"));
    }
}

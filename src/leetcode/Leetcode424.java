package leetcode;

import java.util.Arrays;

/**
 * 替换后的最长重复字符 滑动窗口
 * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
 * 在执行上述操作后，返回 包含相同字母的最长子字符串的长度。
 * @author: ZJY
 * @date: 2022/5/31 10:38 下午
 */
public class Leetcode424 {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int[] countArr = new int[26];
        int maxCount = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            countArr[c - 'A']++;
            int max = Arrays.stream(countArr).max().getAsInt();
            while (r-l+1 - max > k && l < r) {
                char delC = s.charAt(l);
                countArr[delC - 'A']--;
                max = Arrays.stream(countArr).max().getAsInt();
                l++;
            }
            maxCount = Math.max(maxCount, r - l + 1);
            r++;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode424().characterReplacement("ABABBBBABBA", 2));
    }
}

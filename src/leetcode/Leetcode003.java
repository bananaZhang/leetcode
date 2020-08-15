package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Leetcode003 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = 1;
        Set<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
            int len = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (set.contains(arr[j])) {
                    set.clear();
                    break;
                } else {
                    set.add(arr[j]);
                    len++;
                }
            }
            length = Math.max(len, length);
        }
        return length;
    }

    // 可使用滑动窗口解法，时间复杂度O(n)

    public static void main(String[] args) {
        System.out.println(new Leetcode003().lengthOfLongestSubstring("au"));
    }
}

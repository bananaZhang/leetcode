package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Leetcode003 {

    /**
     * 滑动窗口解法, O(n)
     */
    public int lengthOfLongestSubstring2(String s) {
        int l = 0;
        int r = 0;
        int maxLen = 0;
        List<Character> list = new ArrayList<>();
        while (r < s.length()) {
            char c = s.charAt(r);
            while (list.contains(c)) {
                list.remove(0);
                l++;
            }
            list.add(c);
            maxLen = Math.max(maxLen, list.size());
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode003().lengthOfLongestSubstring2(""));
    }
}

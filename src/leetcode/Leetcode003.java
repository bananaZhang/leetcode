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
     * O(nlogn)解法
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int length = 0;
        for (int left = 0; left < s.length(); left++) {
            for (int right = left; right < s.length(); right++) {
                if (set.contains(s.charAt(right))) {
                    break;
                } else {
                    set.add(s.charAt(right));
                }
            }
            length = Math.max(set.size(), length);
            set.clear();
        }
        return length;
    }

    /**
     * 滑动窗口解法, O(n)
     */
    public int lengthOfLongestSubstring2(String s) {
        List<Character> list = new ArrayList<>();
        int right = 0;
        int length = 0;
        while (right < s.length()) {
            // 滑动窗口
            if (list.contains(s.charAt(right))) {
                length = Math.max(list.size(), length);
                list.remove(0);
            // 扩大right
            } else {
                list.add(s.charAt(right));
                right ++;
            }
        }
        length = Math.max(list.size(), length);
        return length;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode003().lengthOfLongestSubstring2(""));
    }
}

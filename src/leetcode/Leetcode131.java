package leetcode;

import java.util.ArrayList;
import java.util.List;

/***
 * 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
 */
public class Leetcode131 {
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        find(s, 0, 0, new ArrayList<>());
        return result;
    }

    // 在split和split+1中间分割或不分割
    private void find(String s, int start, int split, List<String> list) {
        if (split == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        // split==length-1时一定要分割
        if (split < s.length() - 1) {
            find(s, start, split+1, list);
        }
        if (isPalindrome(s, start, split)) {
            list.add(s.substring(start, split+1));
            find(s, split+1, split+1, list);
            list.remove(list.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> ll = new Leetcode131().partition("aab");
        for (List<String> list : ll) {
            System.out.println(list);
        }
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * */
public class Leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] scount = new int[26];
        int[] pcount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            scount[s.charAt(i) - 'a']++;
            pcount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(scount, pcount)) {
            result.add(0);
        }
        for (int i = 0; i < s.length() - p.length(); i++) {
            scount[s.charAt(i) - 'a']--;
            scount[s.charAt(i + p.length()) - 'a']++;
            if (Arrays.equals(scount, pcount)) {
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = new Leetcode438().findAnagrams("cbaebabacd", "abc");
        System.out.println(result);
    }
}

package leetcode;

import java.util.stream.Stream;

/**
 * 所有元音按顺序排布的最长子字符串 滑动窗口
 * 当一个字符串满足如下条件时，我们称它是 美丽的 ：
 * 1、所有 5 个英文元音字母（'a' ，'e' ，'i' ，'o' ，'u'）都必须 至少 出现一次。
 * 2、这些元音字母的顺序都必须按照 字典序 升序排布（也就是说所有的 'a' 都在 'e' 前面，所有的 'e' 都在 'i' 前面，以此类推）
 * 比方说，字符串 "aeiou" 和 "aaaaaaeiiiioou" 都是 美丽的 ，但是 "uaeio" ，"aeoiu" 和 "aaaeeeooo" 不是美丽的 。
 * 给你一个只包含英文元音字母的字符串 word ，请你返回 word 中 最长美丽子字符串的长度 。如果不存在这样的子字符串，请返回 0 。
 * 子字符串 是字符串中一个连续的字符序列。
 * @author: ZJY
 * @date: 2022/4/24 10:20 下午
 */
public class Leetcode1839 {
    public int longestBeautifulSubstring(String word) {
        int type = 1;
        int maxLen = 0;
        int left = 0;
        int right = 1;
        while (right < word.length()) {
            char c = word.charAt(right);
            if (c > word.charAt(right - 1)) {
                type ++;
            } else if (c < word.charAt(right - 1)) {
                left = right;
                type = 1;
            }
            // 因为只有aeiou组成，所以必须type==5才算有美丽数
            if (type == 5) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right ++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode1839().longestBeautifulSubstring("aeeeiiiioooauuuaeiou"));
        Stream.of(1, 2, 5, 8).mapToInt(Integer::intValue).max();
    }
}

package leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 所有元音按顺序排布的最长子字符串
 * 滑动窗口
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

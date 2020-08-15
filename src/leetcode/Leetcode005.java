package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @author: ZJY
 * @date: 2019/6/6 下午1:56
 */
public class Leetcode005 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        List<String> resultList = new ArrayList<>();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            int left = Math.max(i - 1, 0);
            int right = Math.min(i + 1, charArr.length - 1);
            if (charArr[left] == charArr[right]) {
                left --;
                right ++;
            } else {

            }
        }
        return "";
    }

    public String calc(int index, char[] charArr) {
//        int left = index;
//        int right = index;
//        while (right < charArr.length && charArr[left] == charArr[right]) {
//            right ++;
//        }
//        while (left > 0 && )
        return "";
    }

}

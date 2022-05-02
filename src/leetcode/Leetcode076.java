package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 * 滑动窗口
 * @author: ZJY
 * @date: 2022/5/1 10:12 下午
 */
public class Leetcode076 {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        // 需要的字符数
        Map<Character, Integer> needMap = new HashMap<>();
        // 窗口中包含的字符数
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Integer num = needMap.getOrDefault(t.charAt(i), 0);
            needMap.put(t.charAt(i), ++num);
        }
        int matchNum = 0;
        int l = 0;
        int r = 0;
        String result = "";
        int winSize = Integer.MAX_VALUE;
        while (r < s.length()) {
            Character c = s.charAt(r);
            if (needMap.containsKey(c)) {
                Integer num = countMap.getOrDefault(c, 0);
                num++;
                if (num.equals(needMap.get(c))) {
                    matchNum++;
                }
                countMap.put(c, num);
            }
            while (matchNum == needMap.size() && l <= r) {
                c = s.charAt(l);
                if (needMap.containsKey(c)) {
                    Integer num = countMap.get(c);
                    num--;
                    if (num < needMap.get(c)) {
                        matchNum--;
                    }
                    countMap.put(c, num);
                    if (winSize > r - l + 1) {
                        winSize = r - l + 1;
                        result = s.substring(l, r + 1);
                    }
                }
                l++;
            }
            r++;
        }
        return winSize == Integer.MAX_VALUE ? "" : result;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode076().minWindow("aa", "a"));
    }
}

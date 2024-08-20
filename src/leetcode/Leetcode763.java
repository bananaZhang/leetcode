package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 划分字母区间（贪心）
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 * */
public class Leetcode763 {
    public List<Integer> partitionLabels(String s) {
        // 出现过的char中，最靠后的位置
        int maxIdx = 0;
        // 上一次分段的位置
        int lastIdx = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int idx = s.lastIndexOf(s.charAt(i));
            if (i > maxIdx) {
                result.add(i - lastIdx);
                lastIdx = i;
                maxIdx = 0;
            }
            if (idx > maxIdx) {
                maxIdx = idx;
            }
        }
        result.add(s.length() - lastIdx);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode763().partitionLabels("eccbbbbdec"));
    }
}

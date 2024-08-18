package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 划分字母区间（贪心）
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

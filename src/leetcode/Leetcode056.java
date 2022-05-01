package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 合并区间
 * @author: ZJY
 * @date: 2022/5/1 10:06 下午
 */
public class Leetcode056 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[][] res = new int[intervals.length][2];
        int j = 0;
        res[j][0] = intervals[0][0];
        res[j][1] = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 区间start小于上一区间的end
            if (intervals[i][0] <= res[j][1]) {
                res[j][1] = Math.max(res[j][1], intervals[i][1]);
            } else {
                j++;
                res[j][0] = intervals[i][0];
                res[j][1] = intervals[i][1];
            }
        }
        return Arrays.copyOf(res, j + 1);
    }
}

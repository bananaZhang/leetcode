package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
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

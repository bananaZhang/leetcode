package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，
 * 并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
 * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
 * 返回插入之后的 intervals。
 * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 * 字节题
 * @author: ZJY
 * @date: 2022/5/11 10:34 下午
 */
public class Leetcode057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        List<int[]> resList = new ArrayList<>();
        boolean isInsert = false;
        for (int[] interval : intervals) {
            // 区间左边界大于right
            if (interval[0] > right) {
                // 这里只能插一次，否则数据重复
                if (!isInsert) {
                    resList.add(new int[]{left, right});
                    isInsert = true;
                }
                resList.add(interval);
            } else if (interval[1] < left) {
                resList.add(interval);
            } else {
                left = Math.min(interval[0], left);
                right = Math.max(interval[1], right);
            }
        }
        // 没有插入过left right则插入
        if (!isInsert) {
            resList.add(new int[]{left, right});
        }
        int[][] resultArr = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            resultArr[i][0] = resList.get(i)[0];
            resultArr[i][1] = resList.get(i)[1];
        }
        return resultArr;
    }
}

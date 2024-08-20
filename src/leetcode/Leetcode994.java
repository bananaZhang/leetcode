package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 腐烂的橘子 bfs
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * */
public class Leetcode994 {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        int all = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] != 0) {
                    all ++;
                }
            }
        }
        if (all == 0) {
            return 0;
        }
        int count = 0;
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] site = queue.poll();
                int x = site[0];
                int y = site[1];
                if (x-1 >= 0 && grid[x-1][y] == 1) {
                    grid[x-1][y] = 2;
                    queue.offer(new int[]{x-1, y});
                }
                if (x+1 < grid.length && grid[x+1][y] == 1) {
                    grid[x+1][y] = 2;
                    queue.offer(new int[]{x+1, y});
                }
                if (y-1 >= 0 && grid[x][y-1] == 1) {
                    grid[x][y-1] = 2;
                    queue.offer(new int[]{x, y-1});
                }
                if (y+1 < grid[0].length && grid[x][y+1] == 1) {
                    grid[x][y+1] = 2;
                    queue.offer(new int[]{x, y+1});
                }
                sum++;
                size--;
            }
            count ++;
        }
        return all == sum ? count-1 : -1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1}};
        System.out.println(new Leetcode994().orangesRotting(grid));
    }
}

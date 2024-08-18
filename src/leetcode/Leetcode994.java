package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 腐烂的橘子 bfs
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

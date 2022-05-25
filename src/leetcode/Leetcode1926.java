package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode1926 {
    private int[] dx = new int[]{0, 0, -1, 1};
    private int[] dy = new int[]{1, -1, 0, 0};

    public int nearestExit(char[][] maze, int[] entrance) {
        Deque<Point> queue = new LinkedList<>();
        queue.offer(new Point(entrance[0], entrance[1], 0));
        int[][] visited = new int[maze.length][maze[0].length];
        visited[entrance[0]][entrance[1]] = 1;
        // 初始化可能是出口的数组
        int[][] entrances = new int[maze.length][maze[0].length];
        for (int i = 0; i < entrances.length; i++) {
            entrances[i][0] = 1;
            entrances[i][entrances[0].length - 1] = 1;
        }
        for (int i = 0; i < entrances[0].length; i++) {
            entrances[0][i] = 1;
            entrances[entrances.length - 1][i] = 1;
        }
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];
                if (newX >= 0 && newX < maze.length
                        && newY >= 0 && newY < maze[0].length
                        && visited[newX][newY] == 0 && maze[newX][newY] == '.') {
                    visited[newX][newY] = 1;
                    if (entrances[newX][newY] == 1) {
                        min = Math.min(min, point.step + 1);
                        continue;
                    }
                    Point newPoint = new Point(newX, newY, point.step + 1);
                    queue.offer(newPoint);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static class Point {
        public int x;
        public int y;
        public int step;

        public Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
}

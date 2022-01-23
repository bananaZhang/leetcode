package leetcode;

/**
 * 岛屿数量
 * @author: ZJY
 * @date: 2022/1/23 11:45 上午
 */
public class Leetcode200 {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count ++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i >= grid.length || i < 0
                || j >= grid[0].length || j < 0
                || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        System.out.println(new Leetcode200().numIslands(grid));
    }
}

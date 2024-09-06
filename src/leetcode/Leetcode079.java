package leetcode;

/**
 * 单词搜索 回溯
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * @author: ZJY
 * @date: 2022/1/9 7:33 下午
 */
public class Leetcode079 {
    private boolean result;

    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                find(board, i, j, 0, word, visited);
            }
        }
        return result;
    }

    private void find(char[][] board, int x, int y, int index, String word, int[][] visited) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y] == 1 || result) {
            return;
        }
        char target = word.charAt(index);
        if (board[x][y] != target) {
            return;
        }
        if (index == word.length() - 1) {
            result = true;
            return;
        }
        visited[x][y] = 1;
        find(board, x+1, y, index+1, word, visited);
        find(board, x-1, y, index+1, word, visited);
        find(board, x, y+1, index+1, word, visited);
        find(board, x, y-1, index+1, word, visited);
        visited[x][y] = 0;
    }
}

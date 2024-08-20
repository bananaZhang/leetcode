package leetcode;

/**
 * 单词搜索 回溯
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * @author: ZJY
 * @date: 2022/1/9 7:33 下午
 */
public class Leetcode079 {
    private boolean[][] used;

    public boolean exist(char[][] board, String word) {
        used = new boolean[board.length][board[0].length];
        char c =  word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (c == board[i][j]) {
                    used[i][j] = true;
                    if (find(i, j, board, word, 1)) {
                        return true;
                    }
                    used[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean find(int row, int col, char[][] board, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        char target = word.charAt(index);
        // 上
        if (row > 0) {
            char c = board[row - 1][col];
            if (c == target && !used[row - 1][col]) {
                used[row - 1][col] = true;
                if (find(row - 1, col, board, word, index + 1)) {
                    return true;
                };
                used[row - 1][col] = false;
            }
        }
        // 下
        if (row < board.length - 1) {
            char c = board[row + 1][col];
            if (c == target && !used[row + 1][col]) {
                used[row + 1][col] = true;
                if (find(row + 1, col, board, word, index + 1)) {
                    return true;
                }
                used[row + 1][col] = false;
            }
        }
        // 左
        if (col > 0) {
            char c = board[row][col - 1];
            if (c == target && !used[row][col - 1]) {
                used[row][col - 1] = true;
                if (find(row, col - 1, board, word, index + 1)) {
                    return true;
                }
                used[row][col - 1] = false;
            }
        }
        // 右
        if (col < board[0].length - 1) {
            char c = board[row][col + 1];
            if (c == target && !used[row][col + 1]) {
                used[row][col + 1] = true;
                if (find(row, col + 1, board, word, index + 1)) {
                    return true;
                }
                used[row][col + 1] = false;
            }
        }
        return false;
    }
}

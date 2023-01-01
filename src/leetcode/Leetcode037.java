package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 解数独
 * @author: ZJY
 * @date: 2023/1/1 9:54 下午
 */
public class Leetcode037 {
    private boolean[][] rowExist = new boolean[9][10];// 每行数字放置情况
    private boolean[][] columnExist = new boolean[9][10];// 每列数字放置情况
    private boolean[][][] blockExist = new boolean[3][3][10];// 每一小块数字放置情况
    private List<int[]> spaceList = new ArrayList<>();// 可以填入数字的坐标

    private boolean valid = false;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaceList.add(new int[]{i, j});
                } else {
                    int num = board[i][j] - '0';
                    rowExist[i][num] = true;
                    columnExist[j][num] = true;
                    blockExist[i/3][j/3][num] = true;
                }
            }
        }
        dfs(0, board);
    }

    private void dfs(int pos, char[][] board) {
        if (pos == spaceList.size()) {
            valid = true;
            return;
        }
        int x = spaceList.get(pos)[0];
        int y = spaceList.get(pos)[1];
        for (int i = 1; i <= 9 && !valid; i++) {
            if (!rowExist[x][i] && !columnExist[y][i] && !blockExist[x/3][y/3][i]) {
                rowExist[x][i] = true;
                columnExist[y][i] = true;
                blockExist[x/3][y/3][i] = true;
                board[x][y] = (char) (i + '0');
                dfs(pos + 1, board);
                rowExist[x][i] = false;
                columnExist[y][i] = false;
                blockExist[x/3][y/3][i] = false;
            }
        }
    }

    public static void main(String[] args) {

    }
}

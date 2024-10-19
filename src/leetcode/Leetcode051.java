package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N皇后
 * 'Q' 和 '.' 分别代表了皇后和空位
 * */
public class Leetcode051 {
    private char[][] pos;
    private List<List<String>> resList = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        pos = new char[n][n];
        for (char[] po : pos) {
            Arrays.fill(po, '.');
        }
        put(0, n);
        return resList;
    }

    private void put(int row, int n) {
        if (row == n) {
            List<String> result = new ArrayList<>();
            for (char[] po : pos) {
                result.add(String.valueOf(po));
            }
            resList.add(result);
            return;
        }
        for (int i = 0; i < n; i++) {
            pos[row][i] = 'Q';
            if (!conflicted(row, i)) {
                put(row + 1, n);
            }
            pos[row][i] = '.';
        }
    }

    private boolean conflicted(int x, int y) {
        for (int i = 0; i < pos.length; i++) {
            for (int j = 0; j < pos[0].length; j++) {
                if (pos[i][j] == 'Q' && (i != x || j != y)) {
                    if (i == x || j == y) {
                        return true;
                    }
                    if (Math.abs(i - x) == Math.abs(j - y)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 矩阵置0：给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * */
public class Leetcode073 {
    public void setZeroes(int[][] matrix) {
        List<Integer> rowList = new ArrayList<>();
        List<Integer> columnList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowList.add(i);
                    columnList.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rowList.contains(i) || columnList.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

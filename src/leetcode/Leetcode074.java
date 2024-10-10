package leetcode;

/**
 * 搜索二维矩阵
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * 1、每行中的整数从左到右按非严格递增顺序排列。
 * 2、每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false
 * @author: ZJY
 * @date: 2022/12/3 2:14 下午
 */
public class Leetcode074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = searchRow(matrix, target);
        return searchColumn(matrix, row, target);
    }

    public int searchRow(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left == 0 ? left : left - 1;
    }

    public boolean searchColumn(int[][] matrix, int row, int target) {
        int left = 0;
        int right = matrix[row].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] < target) {
                left = mid + 1;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(new Leetcode074().searchMatrix(matrix, 5));
    }
}

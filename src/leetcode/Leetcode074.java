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

    private int searchRow(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        while (low < high) {
            // 向上取整的情况，high=len-1也可以取到high值
            int mid = low + (high - low + 1) / 2;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean searchColumn(int[][] matrix, int row, int target) {
        int low = 0;
        int high = matrix[0].length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(new Leetcode074().searchMatrix(matrix, 5));
    }
}

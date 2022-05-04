package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int height = matrix.length;
        if (height == 0) {
            return Collections.emptyList();
        }
        int width = matrix[0].length;
        int left = 0, right = width - 1, top = 0, buttom = height - 1;
        List<Integer> resList = new ArrayList<>();
        while (true) {
            for (int i = left; i <= right; i++) {
                resList.add(matrix[top][i]);
            }
            top++;
            if (top > buttom) {
                break;
            }
            for (int i = top; i <= buttom; i++) {
                resList.add(matrix[i][right]);
            }
            right--;
            if (left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                resList.add(matrix[buttom][i]);
            }
            buttom--;
            if (top > buttom) {
                break;
            }
            for (int i = buttom; i >= top; i --) {
                resList.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = new Leetcode054().spiralOrder(nums);
        list.stream().forEach(System.out::print);
    }
}

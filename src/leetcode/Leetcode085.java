package leetcode;


import java.util.Stack;

/**
 * 最大矩形 这一题可以抽象成84题
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * @author: ZJY
 * @date: 2022/6/4 10:40 下午
 */
public class Leetcode085 {
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        int[] heights = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j]++;
                }
            }
            max = Math.max(max, largestRectangleArea(heights));
        }
        return max;
    }

    private int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int[] newHeights = new int[heights.length + 2];
        // 首尾各添加一个0便于处理
        for (int i = 0; i < heights.length; i++) {
            newHeights[i+1] = heights[i];
        }
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int top = stack.pop();
                int width = i - stack.peek() - 1;
                max = Math.max(max, newHeights[top] * width);
            }
            stack.add(i);
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(new Leetcode085().maximalRectangle(matrix));
    }
}

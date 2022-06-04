package leetcode;

import java.util.Stack;

/**
 * 柱状图中的最大矩形https://blog.csdn.net/Zolewit/article/details/88863970
 * 单调栈
 * @author: ZJY
 * @date: 2022/6/4 5:45 下午
 */
public class Leetcode084 {
    public int largestRectangleArea(int[] heights) {
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
        int[] heights = new int[]{5,4,1,2};
        System.out.println(new Leetcode084().largestRectangleArea(heights));
    }
}

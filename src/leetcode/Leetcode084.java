package leetcode;

import java.util.Stack;

/**
 * 柱状图中的最大矩形https://blog.csdn.net/Zolewit/article/details/88863970 单调栈
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
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

    // 自己写的，用了两个单调栈
    public int largestRectangleArea2(int[] heights) {
        Stack<Integer> stk1 = new Stack<>();
        int[] rightMax = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stk1.isEmpty() && heights[i] >= heights[stk1.peek()]) {
                stk1.pop();
            }
            rightMax[i] = stk1.isEmpty() ? i : stk1.peek() - i;
            stk1.push(i);
        }
        Stack<Integer> stk2 = new Stack<>();
        int[] leftMin = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!stk2.isEmpty() && heights[i] <= heights[stk2.peek()]) {
                stk2.pop();
            }
            leftMin[i] = stk2.isEmpty() ? i : i - stk2.peek();
            stk2.push(i);
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, (rightMax[i] - leftMin[i]) * heights[i]);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{5,4,1,2};
        System.out.println(new Leetcode084().largestRectangleArea(heights));
    }
}

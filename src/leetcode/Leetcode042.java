package leetcode;

/**
 * 接雨水
 * 字节题
 * @author: ZJY
 * @date: 2022/2/26 6:08 下午
 */
public class Leetcode042 {
    public int trap(int[] height) {
        int[] leftMaxArr = new int[height.length];
        int[] rightMaxArr = new int[height.length];
        int leftMax = 0;
        for (int i = 0; i < height.length; i++) {
            leftMaxArr[i] = Math.max(leftMax, height[i]);
            leftMax = leftMaxArr[i];
        }
        int rightMax = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            rightMaxArr[i] = Math.max(rightMax, height[i]);
            rightMax = rightMaxArr[i];
        }
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            int min = Math.min(leftMaxArr[i], rightMaxArr[i]);
            total += min - height[i];
        }
        return total;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Leetcode042().trap(height));
    }
}

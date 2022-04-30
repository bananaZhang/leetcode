package leetcode;

/**
 * 盛水最多的容器
 * 双指针
 * @author: ZJY
 * @date: 2022/4/30 7:38 下午
 */
public class Leetcode011 {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            maxArea = Math.max(maxArea, (r - l) * Math.min(height[r], height[l]));
            // 盛水的多少取决于短的那个，只有向内移动短的那个，才有可能获得更大的盛水量
            if (height[l] <= height[r]) {
                l ++;
            } else {
                r --;
            }
        }
        return maxArea;
    }
}

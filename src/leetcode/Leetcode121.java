package leetcode;

/**
 * 买卖股票的最佳时机，给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 动态规划
 * @author: ZJY
 * @date: 2022/2/19 9:02 下午
 */
public class Leetcode121 {
    public int maxProfit(int[] prices) {
        int[] maxEarn = new int[prices.length];
        int minPrice = Integer.MAX_VALUE;
        // 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            int max = i == 0 ? 0 : Math.max(maxEarn[i-1], prices[i] - minPrice);
            maxEarn[i] = max;
        }
        return maxEarn[prices.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2};
        System.out.println(new Leetcode121().maxProfit(arr));
    }
}

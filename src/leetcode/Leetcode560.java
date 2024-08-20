package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * @author: ZJY
 * @date: 2022/6/5 7:25 下午
 */
public class Leetcode560 {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            Integer value = map.getOrDefault(sum, 0);
            map.put(sum, ++value);
        }
        return count;
    }
}

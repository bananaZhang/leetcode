package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为 K 的子数组
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

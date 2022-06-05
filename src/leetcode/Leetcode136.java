package leetcode;

/**
 * 只出现一次的数字：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 交换律：a ^ b ^ c <=> a ^ c ^ b
 * 任何数于0异或为任何数 0 ^ n => n
 * 相同的数异或为0: n ^ n => 0
 * @author: ZJY
 * @date: 2022/6/5 6:18 下午
 */
public class Leetcode136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}

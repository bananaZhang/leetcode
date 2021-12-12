package leetcode;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * @author: ZJY
 * @date: 2021/12/12 6:28 下午
 */
public class Leetcode088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int[] result = new int[m + n];
        while (i < m && j < n) {
            result[i+j] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < m) {
            result[i+j] = nums1[i++];
        }
        while (j < n) {
            result[i+j] = nums2[j++];
        }
        for (int k = 0; k < m + n; k ++) {
            nums1[k] = result[k];
        }
    }
    /**
     * 优化：由于nums1后面是空的，所以可以采用逆向双指针，两个数组分别从后向前迭代，将较大的数放到nums1数组的尾部，
     * 这样就不需要额外的辅助空间了
     */
}

package leetcode;

/**
 * 寻找两个正序数组的中位数
 * 字节题 https://www.acwing.com/solution/content/14344/
 * @author: ZJY
 * @date: 2022/4/24 10:32 下午
 */
public class Leetcode004 {

    // 分别找第 (m+n+1)/2 个，和 (m+n+2)/2 个，然后求其平均值即可，这对奇偶数均适用。
    // 若 m+n 为奇数的话，那么其实 (m+n+1)/2 和 (m+n+2)/2 的值相等，相当于两个相同的数字相加再除以2，还是其本身。
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0d;
    }

    private int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        // 起始位置大于数组长度时，只需要从另一个数组找就行了
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        // k=1时直接拿第一个元素
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        // 分别在nums1和nums2中找第 k/2 个元素，如果某个数组的个数都不到 k/2 个，自然无法淘汰，所以将其对应的 midVal 值设为整型
        // 最大值（目的是要在 nums1 或者 nums2 中先淘汰 K/2 个较小的数字，判断的依据就是看 midVal1 和 midVal2 谁更小）
        int midVal1 = (i + k/2 - 1 < nums1.length) ? nums1[i + k/2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k/2 - 1 < nums2.length) ? nums2[j + k/2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k/2, nums2, j, k - k/2);
        } else {
            return findKth(nums1, i, nums2, j + k/2, k - k/2);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 2, 4, 4};
        int[] nums2 = new int[]{2, 2, 4, 4};
        System.out.println(new Leetcode004().findMedianSortedArrays(nums1, nums2));
    }
}

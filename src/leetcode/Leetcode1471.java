package leetcode;

import java.util.Arrays;

/**
 * 数组中的 k 个最强值
 * 设 m 为数组的中位数，只要满足下述两个前提之一，就可以判定 arr[i] 的值比 arr[j] 的值更强
 * |arr[i] - m| > |arr[j] - m|
 * |arr[i] - m| == |arr[j] - m|，且 arr[i] > arr[j]
 * @author: ZJY
 * @date: 2022/12/3 2:10 下午
 */
public class Leetcode1471 {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int midNum = arr[(arr.length - 1) / 2];
        Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedArr, (o1, o2) -> {
            int res = Math.abs(o1 - midNum) - Math.abs(o2 - midNum);
            if (res > 0) {
                return -1;
            } else if (res == 0) {
                if (o1 > o2) {
                    return -1;
                }
            }
            return 1;
        });

        int[] resArr = new int[k];
        for (int i = 0; i < k; i++) {
            resArr[i] = boxedArr[i];
        }
        return resArr;
    }
}

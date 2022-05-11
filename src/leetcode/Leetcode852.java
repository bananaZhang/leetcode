package leetcode;

/**
 * 山脉数组的峰顶索引
 * @author: ZJY
 * @date: 2022/5/11 9:25 下午
 */
public class Leetcode852 {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                break;
            }
            // 注意这里l和r的赋值
            if (arr[mid] < arr[mid + 1]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(new Leetcode852().peakIndexInMountainArray(arr));
    }
}

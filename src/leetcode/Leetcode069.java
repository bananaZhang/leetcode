package leetcode;

/**
 * 求一个正整数的算数平方根，舍弃小数部分（二分法）
 * @author: ZJY
 * @date: 2021/12/19 4:29 下午
 */
public class Leetcode069 {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        long result = -1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode069().mySqrt(8));
    }
}

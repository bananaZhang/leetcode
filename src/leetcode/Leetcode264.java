package leetcode;

/**
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 丑数 就是质因子只包含 2、3 和 5 的正整数。
 * */
public class Leetcode264 {
    public int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int p1 = 0, p2 = 0, p3 = 0;
        for (int i = 1; i < n; i++) {
            int num1 = uglyNums[p1] * 2;
            int num2 = uglyNums[p2] * 3;
            int num3 = uglyNums[p3] * 5;
            uglyNums[i] = Math.min(num1, Math.min(num2, num3));
            if (uglyNums[i] == num1) {
                p1++;
            }
            if (uglyNums[i] == num2) {
                p2++;
            }
            if (uglyNums[i] == num3) {
                p3++;
            }
        }
        return uglyNums[n-1];
    }
}

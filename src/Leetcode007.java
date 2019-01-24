/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。假设我们的环境只能存储得下 32 位的有符号整数，
 * 则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @author ZJY
 * @date 2019/1/24 19:35
 */
public class Leetcode007 {
    public int reverse(int x) {
        int result = 0;
        int count = 0;// 统计入参x的位数
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
            count ++;
            // 一旦到9位时需要判断溢出问题
            if (count == 9 && x != 0) {
                // 正数未溢出的情况
                if (x > 0 && result <= Integer.MAX_VALUE / 10 && x <= Integer.MAX_VALUE % 10) {
                    continue;
                }
                // 负数未溢出的情况
                if (x < 0 && result >= Integer.MIN_VALUE / 10 && x >= Integer.MIN_VALUE % 10) {
                    continue;
                }
                return 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode007().reverse(-123456789));
    }
}

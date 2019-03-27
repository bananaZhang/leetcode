package leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @author ZJY
 * @date 2019/1/24 20:01
 */
public class Leetcode009 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode009().isPalindrome(1233421));
    }
}

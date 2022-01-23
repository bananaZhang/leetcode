package leetcode;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * @author: ZJY
 * @date: 2022/1/23 11:14 上午
 */
public class Leetcode415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int remain = 0;
        while (i >= 0 || j >= 0 || remain > 0) {
            if (i >= 0) {
                remain += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                remain += num2.charAt(j--) - '0';
            }
            sb.append(remain % 10);
            remain = remain / 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode415().addStrings("6", "501"));
    }
}

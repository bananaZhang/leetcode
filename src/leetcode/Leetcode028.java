package leetcode;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串
 * 出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * @author: ZJY
 * @date: 2021/11/20 9:03 下午
 */
public class Leetcode028 {
    /**
     * 用kmp, CNM
     * 或者使用str.indexOf() 滑稽
     */
    public int strStr(String haystack, String needle) {
        // 下面的代码是超时的
        // TODO 使用KMP
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if (haystack.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            int k = i;
            for (int j = 0; j < needle.length(); j++) {
                if (k < haystack.length() && haystack.charAt(k) == needle.charAt(j)) {
                    k++;
                    continue;
                }
                break;
            }
            if ((k - i) == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode028().strStr("mississippi", "issipi"));
    }
}

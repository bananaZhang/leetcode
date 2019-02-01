import java.util.Arrays;

/**
 * 最长公共前缀
 * 输入：["flower","flow","flight"]
 * 输出："fl"
 * @author: ZJY
 * @date: 2019/2/1 下午7:41
 */
public class Leetcode014 {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs == null || strs.length == 0) {
            return result;
        }
        int minLength = Arrays.stream(strs).mapToInt(String::length).min().getAsInt();
        for (int i = 0; i < minLength; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if (c == str.charAt(i)) {
                    continue;
                }
                return result;
            }
            result += c;
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode014 test = new Leetcode014();
        System.out.println(test.longestCommonPrefix(new String[]{"a"}));
    }
}

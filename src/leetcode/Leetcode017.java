package leetcode;

import java.util.*;

/**
 * 电话号码的字母组合：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 回溯法
 * @author: ZJY
 * @date: 2022/1/2 9:57 下午
 */
public class Leetcode017 {

    private List<String> resultList = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();
    private Map<String, List<String>> map = buildMap();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.trim().length() == 0) {
            return Collections.emptyList();
        }
        backtrack(digits, 0);
        return resultList;
    }

    private void backtrack(String digits, int index) {
        if (digits.length() == sb.length()) {
            resultList.add(sb.toString());
            return;
        }
        List<String> table = map.get(Character.toString(digits.charAt(index)));
        for (String str : table) {
            sb.append(str);
            backtrack(digits, index + 1);
            sb.deleteCharAt(index);
        }
    }

    private Map<String, List<String>> buildMap() {
        Map<String, List<String>> table = new HashMap<>();
        table.put("2", Arrays.asList("a", "b", "c"));
        table.put("3", Arrays.asList("d", "e", "f"));
        table.put("4", Arrays.asList("g", "h", "i"));
        table.put("5", Arrays.asList("j", "k", "l"));
        table.put("6", Arrays.asList("m", "n", "o"));
        table.put("7", Arrays.asList("p", "q", "r", "s"));
        table.put("8", Arrays.asList("t", "u", "v"));
        table.put("9", Arrays.asList("w", "x", "y", "z"));
        return table;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode017().letterCombinations("23"));
    }
}

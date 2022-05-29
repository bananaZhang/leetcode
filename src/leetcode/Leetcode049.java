package leetcode;

import java.util.*;

/**
 * 字母异位词分组
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * @author: ZJY
 * @date: 2022/5/1 10:05 下午
 */
public class Leetcode049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String newStr = new String(charArr);
            List<Integer> list = map.getOrDefault(newStr, new ArrayList<>());
            list.add(i);
            map.put(newStr, list);
        }
        List<List<String>> resList = new ArrayList<>();
        for (List<Integer> value : map.values()) {
            List<String> list = new ArrayList<>();
            for (Integer index : value) {
                list.add(strs[index]);
            }
            resList.add(list);
        }
        return resList;
    }
}

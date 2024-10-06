package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 字母异位词分组
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * @author: ZJY
 * @date: 2022/5/1 10:05 下午
 */
public class Leetcode049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = Arrays.stream(strs).collect(Collectors.groupingBy((str) -> {
                    char[] arr = str.toCharArray();
                    Arrays.sort(arr);
                    return new String(arr);
                }
        ));
        return new ArrayList<>(map.values());
    }
}

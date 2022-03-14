package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU 算法
 * @author: ZJY
 * @date: 2022/3/13 7:16 下午
 */
public class Leetcode146 {
    private LinkedHashMap<Integer, Integer> linkedHashMap;

    public Leetcode146(int capacity) {
        /**
         * 按照访问顺序排序，并且当size大于capacity时，淘汰掉最老的数据
         */
        linkedHashMap = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (!linkedHashMap.containsKey(key)) {
            return -1;
        }
        return linkedHashMap.get(key);
    }

    public void put(int key, int value) {
        linkedHashMap.put(key, value);
    }

    public static void main(String[] args) {
        Leetcode146 lru = new Leetcode146(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1));
        lru.put(3, 3);
        System.out.println(lru.get(2));
        lru.put(4, 4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
    }
}

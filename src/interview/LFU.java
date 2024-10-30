package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class LFU<K, V> {

    private int capacity;
    private Map<K, LfuNode<K, V>> cache;
    private TreeSet<LfuNode<K, V>> treeSet;

    public LFU(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.treeSet = new TreeSet<>();
    }

    public V get(K key) {
        LfuNode<K, V> node = cache.get(key);
        if (node == null) {
            return null;
        }
        treeSet.remove(node);
        LfuNode<K, V> value = cache.get(key);
        treeSet.add(node);
        return value.getValue();
    }

    public void put(K key, V value) {
        LfuNode<K, V> node = cache.get(key);
        if (node == null) {
            node = new LfuNode<>(key, value);
            if (treeSet.size() >= capacity) {
                treeSet.remove(node);
                cache.remove(treeSet.first().key);
            }
        } else {
            treeSet.remove(node);
            node.setValue(value);
        }
        treeSet.add(node);
        cache.put(key, node);
    }

    static class LfuNode<K, V> implements Comparable<LfuNode<K, V>> {
        private K key;
        private V value;
        private long lastAccessTime;
        private int accessCount;

        LfuNode(K key, V value) {
            this.key = key;
            setValue(value);
        }

        public void setValue(V value) {
            this.value = value;
            lastAccessTime = System.currentTimeMillis();
            accessCount++;
        }

        public V getValue() {
            lastAccessTime = System.currentTimeMillis();
            accessCount++;
            return value;
        }

        @Override
        public int compareTo(LfuNode<K, V> o) {
            int res = Integer.compare(this.accessCount, o.accessCount);
            return res != 0 ? res : Long.compare(this.lastAccessTime, o.lastAccessTime);
        }
    }
}

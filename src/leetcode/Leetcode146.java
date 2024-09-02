package leetcode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * LRU 算法
 * 字节题
 *
 * @author: ZJY
 * @date: 2022/3/13 7:16 下午
 */
public class Leetcode146 {
    private final int capacity;

    private int size;

    private LruNode head;

    private LruNode tail;

    private final Map<Integer, LruNode> cache = new ConcurrentHashMap<>();

    public Leetcode146(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new LruNode();
        tail = new LruNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LruNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        LruNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }
        node = new LruNode(key, value);
        cache.put(key, node);
        addNode(node);
        size++;
        if (size > capacity) {
            deleteTail();
        }
    }

    private void addNode(LruNode node) {
        LruNode next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    private void moveToHead(LruNode node) {
        LruNode prev = node.prev;
        LruNode next = node.next;
        prev.next = next;
        next.prev = prev;
        addNode(node);
    }

    private void deleteTail() {
        LruNode deleteNode = tail.prev;
        cache.remove(deleteNode.key);
        LruNode prev = deleteNode.prev;
        tail.prev = prev;
        prev.next = tail;
        size--;
    }

    private class LruNode {
        int key;
        int value;
        LruNode prev;
        LruNode next;

        public LruNode() {
        }

        public LruNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
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

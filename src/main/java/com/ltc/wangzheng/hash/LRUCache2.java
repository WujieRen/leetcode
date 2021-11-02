package com.ltc.wangzheng.hash;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);
        cache.put(2,1);
        cache.put(1,1);
        iterate();
        System.out.println(cache.get(2));
        iterate();
        cache.put(4, 1);
        System.out.println(cache.get(1));
        iterate();
        System.out.println(cache.get(2));
        iterate();

    }

    private static class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;

        DLinkedNode() {
        }

        DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, DLinkedNode> map = new HashMap<Integer, DLinkedNode>();
    static DLinkedNode head;
    static DLinkedNode tail;
    int capacity;
    int size;

    private static void iterate() {
        DLinkedNode tmp = head.next;
        while(tmp!=tail) {
            System.out.print(tmp.key + "-->");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public LRUCache2(int capacity) {
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        head.pre = null;
        tail.pre = head;
        tail.next = null;
        this.size = 0;
        this.capacity = capacity;
    }

    public void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        map.remove(node.key);
        --size;
    }

    public void addToTail(DLinkedNode newNode) {
        tail.pre.next = newNode;
        newNode.next = tail;
        newNode.pre = tail.pre;
        tail.pre = newNode;
        map.put(newNode.key, newNode);
        ++size;
    }

    /**
     * 如果不存在，返回-1
     * 如果存在：
     *  1。 将节点移除从链表中移除，放到最后
     *  2。 返回节点值
     *
     * @param key
     * @return
     */
    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null || size == 0) return -1;
        removeNode(node);
        addToTail(node);
        return node.value;
    }

    /**
     * 存在：
     *  1。 更新值；
     *  2。 将节点移除，并放置到最后（即最新访问节点）
     * 不存在：
     *  1。 新增；
     *      1。大小已满  ---》 先删头，再新增
     *      2。大小未满  ---》 直接添加到链尾
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node != null) {
            node.value = value;
            removeNode(node);
            addToTail(node);
            return;
        }
        if (size == capacity) {
            removeNode(head.next);
        }
        DLinkedNode newNode = new DLinkedNode(key, value);
        addToTail(newNode);
    }
}

package com.ltc.wangzheng.hash;


public class LRUCache {

    private static class LinkNode{
        int key;
        int value;
        LinkNode next;

        LinkNode() {};
        LinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    LinkNode head;
    LinkNode tail;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        head = new LinkNode();
        tail = head;
        this.size = 0;
        this.capacity = capacity;
    }

    public LinkNode getNode(int key) {
        LinkNode cur = head.next;
        LinkNode pre = head;
        while(cur != null) {
            if(cur.key == key) break;
            cur = cur.next;
            pre = pre.next;
        }
        if(cur != null && cur != tail) {
            pre.next = cur.next;
            cur.next = null;
            tail.next = cur;
            tail = cur;
        }
        return cur;
    }

    public int get(int key) {
        LinkNode node = getNode(key);
        return node == null ? -1 : node.value;
    }

    public void put(int key, int value) {
        if(getNode(key) != null) {        //存在的话直接把它放到最后并更新value;但是这里得要求值不是-1
            getNode(key).value = value;
            return;
        }
        LinkNode newNode = new LinkNode(key, value);
        tail.next = newNode;
        tail = newNode;
        if(size == capacity) {      //不存在首先看容器大小满了没
            LinkNode delNode = head.next;
            head.next = delNode.next;
            delNode.next = null;
        } else {
            size++;
        }
    }

}

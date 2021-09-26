package com.ltc.rwj.queue;

/**
 * @author rwj
 * @create_time 2021/7/31
 * @description 用双向链表实现的队列，链式队列。
 *                  我自己实现的方式，参照了别人的代码后发现还可以优化。看OtherListQueue
 */
public class DoublyLinkedQueue {

    private int size;
    private int cnt;
    Node head;
    Node tail;

    class Node {
        String val;
        Node pre;
        Node next;

        Node(String val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val;
        }
    }

    DoublyLinkedQueue(int size) {
        this.size = size;
    }

    public void iterateStack() {
        Node tmp = head;
        while(tmp != null) {
            System.out.print(tmp + "\t");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public boolean enqueue(String val) {
        if(cnt == size) return false;
        ++cnt;
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            tail = newNode;
            return true;
        }
        newNode.next = head;
        head.pre = newNode;
        head = newNode;
        return true;
    }

    public Node dequeue() {
        if(cnt == 0) return null;
        Node firstIn = tail;
        tail = tail.pre == null ? head : tail.pre;
        tail.next = null;
        cnt--;
        return firstIn;
    }

}

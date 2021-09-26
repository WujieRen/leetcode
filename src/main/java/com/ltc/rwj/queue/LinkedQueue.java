package com.ltc.rwj.queue;

/**
 * @author rwj
 * @create_time 2021/7/31
 * @description 用单链表实现的队列，链式队列。
 *      参照了别人的代码后优化的。
 *      一开始想着是这样会在出栈后导致弃用Node占用的内存不会释放。
 *      后来发现oldHead的指针一直指向下一个head。
 *      即虽然当时不会释放；但是当下一次deque后，上一次弃用的Node节点地址就不会再被引用。
 *      就会被JVM垃圾回收机制在合适的时间回收掉。
 */
public class LinkedQueue {

    private int size;   //队列容量大小
    private int cnt;    //队列元素个数
    Node head;
    Node tail;

    class Node {
        String val;
        Node next;

        Node(String val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val;
        }
    }

    LinkedQueue(int size) {
        this.size = size;
    }

    public boolean enqueue(String item) {
        if(cnt == size) return false;
        Node newNode = new Node(item);
        cnt++;
        if(head == null){
            head = newNode;
            tail = newNode;
            return true;
        }
        tail.next = newNode;
        tail = newNode;
        return true;
    }

    public Node dequeue() {
        if(cnt == 0) return null;
        Node oldHead = head;
        head = head.next == null ? tail : head.next;        //TODO：注意当cnt==1时，head.next就是null了。
        cnt--;
        return oldHead;
    }

    public void iterator() {        //TODO:注意遍历的时候不能改变head的引用
        Node tmp = head;
        while(tmp != null) {
            System.out.println(tmp);
            tmp = tmp.next;
        }
    }

}

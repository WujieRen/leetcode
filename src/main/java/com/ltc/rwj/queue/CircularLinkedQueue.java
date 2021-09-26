package com.ltc.rwj.queue;

/**
 * @author rwj
 * @create_time 2021/8/1
 * @description
 */
public class CircularLinkedQueue {
    class Node {
        String val;
        Node next;

        Node(String val) {
            this.val = val;
        }

        public void setVal(String val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val;
        }
    }

    private int size;
    private int cnt;
    Node head;
    Node tail;

    CircularLinkedQueue(int size) {
        this.size = size;
    }

    //TODO：这是一开始写但通过测试的；后来仔细一想这个严格意义上来说不算循环链表的实现；
    //      因为每次队列满的时候，都要重新创建一个newNode；再把tail.next置为null后再置为newNode；
    //      而且频繁地这么操作；一方面容易造成内存碎片；另一方面会增加JVMgc的概率。
    /*public boolean enqueue(String item) {
        if(cnt == size) {      //队列已满
            tail.next = head;
            return false;
        }

        Node newNode = new Node(item);
        if(cnt == 0) {              //队列为空
            head = newNode;
            tail = newNode;
            cnt++;
            return true;
        }

        tail.next = newNode;
        tail = newNode;
        cnt++;
        return true;
    }*/

    /*public Node dequeue() {
        if(cnt == 0) return null;
        Node oldHead = head;
        head = head.next;
        if(cnt == size) {
            tail.next = null;
        }
        cnt--;
        return oldHead;
    }*/

    //TODO: 优化
    boolean flag  = false;  //链表节点数是否==队列size；一点那等于说明已经构成环了。
                            //后续就不再进行节点创建；而是循环引用之前创建好的节点，只是更新它们的值。
    public boolean enqueue(String item) {
        if(cnt == size) {      //队列已满
            if(!flag) {
                tail.next = head;
                flag = true;
            }
            return false;
        }

        if(!flag) {
            Node newNode = new Node(item);
            if(cnt == 0) {
                head = newNode;
                tail = newNode;
                cnt++;
                return true;
            }
            tail.next = newNode;
            tail = newNode;
            cnt++;
            return true;
        } else {
            tail.next.setVal(item);
            tail = tail.next;
            cnt++;
            return true;
        }
    }

    public Node dequeue() {
        if(cnt == 0) return null;
        Node oldHead = head;
        head = head.next;
        cnt--;
        return oldHead;
    }

    public void iterator() {
        Node tmp = head;
        for(int i = 0; i < cnt; i++) {
            System.out.println(tmp);
            tmp = tmp.next;
        }
    }


}

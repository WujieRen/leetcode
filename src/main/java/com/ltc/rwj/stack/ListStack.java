package com.ltc.rwj.stack;

/**
 * @author rwj
 * @create_time 2021/7/31
 * @description 基于数组实现的顺序栈
 *                  栈：先进后出
 */
public class ListStack {

    Node header;

    ListStack() {}
    ListStack(String item) {
        header = new Node(item);
    }

    public void iterateStack() {
        Node tmp = header;
        while(tmp != null) {
            System.out.print(tmp + "\t");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public boolean push(String item) {
        if(header == null) return false;
        Node newNode = new Node(item);
        newNode.next = header;
        header = newNode;
        return true;
    }

    public Node pop() {
        Node tmp = this.header;
        if (tmp == null) return null;
        this.header = this.header.next;
        return tmp;
    }

    class Node {
        String val;
        Node next;
        Node(String val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return this.val;
        }
    }
}

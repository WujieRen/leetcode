package com.ltc.wangzheng.stack;


import java.util.LinkedList;

public class CQueue2 {

    private LinkedList list;

    public CQueue2() {
        list = new LinkedList();
    }

    public void appendTail(int value) {
        list.addLast(value);
    }

    public int deleteHead() {
        return list == null || list.size() == 0 ? -1 : (Integer) list.removeFirst();
    }
}

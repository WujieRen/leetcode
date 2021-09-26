package com.ltc.rwj.queue;

/**
 * @author rwj
 * @create_time 2021/7/31
 * @description 用数组实现的队列，顺序队列。
 */
public class ArrayQueue {

    private String[] items;
    private int length;
    private int head = 0;
    private int tail = 0;

    ArrayQueue(int length) {
        items = new String[length];
        this.length = length;
    }

    public boolean enqueue(String item) {
        //TODO:下面这个是我本来的写法，但是可以优化。
        /*if(tail == length && head == 0) return false;

        if(tail == length){
            for(int i = 0; i < (tail - head); i++) {
                items[i] = items[head++];
            }
            head = 0;
            tail = tail - head;
        }
        items[tail++] = item;*/

        if(tail == length) {
            if(head == 0) return false;     // tail == n表示队列末尾没有空间了
            for(int i = head; i < tail; ++i) {      // 数据搬移
                items[i-head] = items[i];
            }
            // 搬移完之后重新更新head和tail
            tail -= head;
            head = 0;
        }
        items[tail++] = item;
        return true;
    }

    public String dequeue() {
        if(tail == head) return null;
        return items[head++];
    }

}

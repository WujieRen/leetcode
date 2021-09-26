package com.ltc.rwj.queue;

/**
 * @author rwj
 * @create_time 2021/7/31
 * @description
 */
public class CircularQueue {

    String[] items;
    private int length;
    private int head = 0;
    private int tail = 0;

    CircularQueue(int length) {
        this.length = length;
        items = new String[10];
    }

    //TODO:我自己实现的方式         对比之下觉得我这种方式在多个地方修改了tail的值，的确是容易造成一些意想不到的结果
    //     所以对变量值的更新如果在一个地方可以搞定最好别分散在多个地方更新
    /*public boolean enqueue(String item) {
        if((tail + 1)%length == head) {
            return false;
        }
        if(tail + 1 == length) {        //数组实现的循环队列，每当tail+1==length时要重新从0开始
            items[tail] = item;
            tail = 0;
            return true;
        }
        items[tail++] = item;
        return true;
    }*/
    // 入队
    public boolean enqueue(String item) { // 队列满了
        if ((tail + 1) % length == head) return false;
        items[tail] = item;
        tail = (tail + 1) % length;
        return true;
    }

    /*public String dequeue() {
        if ((head + 1) == length) {
            String tmp = items[head];
            head = 0;
            return tmp;
        }
        if (head == tail) return null;
        return items[head++];
    }*/
    //出队
    public String dequeue() { // 如果head == tail 表示队列为
        if (head == tail) return null;
        String ret = items[head];
        head = (head + 1) % length;
        return ret;
    }

    public void iterator() {
        int tmp = head;
        while (tmp != tail) {
            if ((tmp + 1) == length) {
                tmp = 0;
            }
            System.out.println(items[tmp++]);
        }
    }
}

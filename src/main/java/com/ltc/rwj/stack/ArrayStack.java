package com.ltc.rwj.stack;

/**
 * @author rwj
 * @create_time 2021/7/31
 * @description 基于数组实现的顺序栈
 *      栈：先进后出
 */
public class ArrayStack {
    private String[] items;
    private int cnt;
    private int length;

    ArrayStack(int length) {
        this.items = new String[length];
        this.length = length;
    }

    public boolean push(String item) {
        if(cnt == length) return false;
        items[cnt++] = item;
        return true;
    }

    public String pop() {
        if(cnt == 0) return null;
        return items[--cnt];        //TODO:这里要注意，cnt指的是元素个数而不是下标；所以取值时要先-1再取
    }

}

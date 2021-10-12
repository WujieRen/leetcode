package com.ltc.wangzheng.stack;

/**
 * @author rwj
 * @create_time 2021/10/10
 * @description if else 比 stich 快
 */
public class TripleInOne2 {

    private int[] ary;
    private int stackSize;
    int cnt0, cnt1, cnt2;

    public TripleInOne2(int stackSize) {
        ary = new int[3 * stackSize];
        this.stackSize = stackSize;
    }

    public void push(int stackNum, int value) {
        int idx = stackNum * stackSize;
        if(stackNum == 0) {
            if (cnt0 == stackSize) return;
            idx += cnt0++;
        }
        if(stackNum == 1) {
            if (cnt1 == stackSize) return;
            idx += cnt1++;
        }
        if(stackNum == 2) {
            if (cnt2 == stackSize) return;
            idx += cnt2++;
        }
        ary[idx] = value;
    }

    public int pop(int stackNum) {
        int idx = stackNum * stackSize;
        if(stackNum == 0) {
            if (cnt0 == 0) return -1;
            idx += --cnt0;
        }
        if(stackNum == 1) {
            if (cnt1 == 0) return -1;
            idx += --cnt1;
        }
        if(stackNum == 2) {
            if (cnt2 == 0) return -1;
            idx += --cnt2;
        }
        return ary[idx];
    }

    public int peek(int stackNum) {
        int idx = stackNum * stackSize;
        if(stackNum == 0) {
            if (cnt0 == 0) return -1;
            idx += (cnt0 - 1);
        }
        if(stackNum == 1) {
            if (cnt1 == 0) return -1;
            idx += (cnt1 - 1);
        }
        if(stackNum == 2) {
            if (cnt2 == 0) return -1;
            idx += (cnt2 - 1);
        }
        return ary[idx];
    }

    public boolean isEmpty(int stackNum) {
        if(stackNum == 0 && cnt0 == 0) {
            return true;
        }
        if(stackNum == 1 && cnt1 == 0) {
            return true;
        }
        return stackNum == 2 && cnt2 == 0;
    }
}
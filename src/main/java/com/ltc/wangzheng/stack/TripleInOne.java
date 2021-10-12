package com.ltc.wangzheng.stack;

/**
 * @author rwj
 * @create_time 2021/10/10
 * @description
 */
public class TripleInOne {

    private int[] ary;
    private int stackSize;
    int cnt0, cnt1, cnt2;

    public TripleInOne(int stackSize) {
        ary = new int[3 * stackSize];
        this.stackSize = stackSize;
    }

    public void push(int stackNum, int value) {
        int idx = stackNum * stackSize;
        switch (stackNum) {
            case 0:
                if (cnt0 == stackSize) return;
                idx += cnt0++;
                break;
            case 1:
                if (cnt1 == stackSize) return;
                idx += cnt1++;
                break;
            case 2:
                if (cnt2 == stackSize) return;
                idx += cnt2++;
                break;
            default:
                return;
        }
        ary[idx] = value;
    }

    public int pop(int stackNum) {
        int idx = stackNum * stackSize;
        switch (stackNum) {
            case 0:
                if (cnt0 == 0) return -1;
                idx += --cnt0;
                break;
            case 1:
                if (cnt1 == 0) return -1;
                idx += --cnt1;
                break;
            case 2:
                if (cnt2 == 0) return -1;
                idx += --cnt2;
                break;
            default:
                return -1;
        }
        return ary[idx];
    }

    public int peek(int stackNum) {
        int idx = stackNum * stackSize;
        switch (stackNum) {
            case 0:
                if (cnt0 == 0) return -1;
                idx += (cnt0 - 1);
                break;
            case 1:
                if (cnt1 == 0) return -1;
                idx += (cnt1 - 1);
                break;
            case 2:
                if (cnt2 == 0) return -1;
                idx += (cnt2 - 1);
                break;
            default:
                return -1;
        }
        return ary[idx];
    }

    public boolean isEmpty(int stackNum) {
        switch (stackNum) {
            case 0:
                if (cnt0 == 0) return true;
                break;
            case 1:
                if (cnt1 == 0) return true;
                break;
            case 2:
                if (cnt2 == 0) return true;
                break;
            default:
                return true;
        }
        return false;
    }
}
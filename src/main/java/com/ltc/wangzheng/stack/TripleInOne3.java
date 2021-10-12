package com.ltc.wangzheng.stack;

/**
 * @author rwj
 * @create_time 2021/10/10
 * @description
 */
public class TripleInOne3 {

    private int[][] stack;
    private int[] locations;

    public TripleInOne3(int stackSize) {
        stack = new int[3][stackSize];
        locations = new int[3];

    }

    public void push(int stackNum, int value) {
        int[] cur = stack[stackNum];
        int index = locations[stackNum];
        if(index < cur.length){
            cur[index] = value;
            locations[stackNum]++;
        }
    }

    public int pop(int stackNum) {
        int[] cur = stack[stackNum];
        int index = locations[stackNum];
        if(index > 0){
            int ans =  cur[index - 1];
            locations[stackNum]--;
            return ans;
        }
        return -1;
    }

    public int peek(int stackNum) {
        int[] cur = stack[stackNum];
        int index = locations[stackNum];
        if(index > 0){
            return  cur[index - 1];

        }
        return -1;
    }

    public boolean isEmpty(int stackNum) {
        return locations[stackNum] == 0;
    }
}

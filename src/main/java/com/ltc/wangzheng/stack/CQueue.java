package com.ltc.wangzheng.stack;

import java.util.Stack;

public class CQueue {

    Stack<Integer> leftStack;
    Stack<Integer> rightStack;

    public CQueue() {
        leftStack = new Stack<Integer>();
        rightStack = new Stack<Integer>();
    }

    public void appendTail(int value) {
        leftStack.push(value);
    }

    public int deleteHead() {
         while(!leftStack.empty()) {
             int val = leftStack.pop();
             rightStack.push(val);
         }
         if(rightStack.empty()) return -1;
         int res = rightStack.pop();
         while(!rightStack.empty()) {
             leftStack.push(rightStack.pop());
         }
         return res;
    }

}

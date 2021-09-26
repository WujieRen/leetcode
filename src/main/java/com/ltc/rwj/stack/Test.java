package com.ltc.rwj.stack;

/**
 * @author rwj
 * @create_time 2021/7/31
 * @description
 */
public class Test {
    public static void main(String[] args) {
       /* ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push("a");
        arrayStack.push("b");
        arrayStack.push("c");
        arrayStack.push("d");
        arrayStack.push("e");
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());*/

       ListStack listStack = new ListStack("a");
       listStack.push("b");
       listStack.push("c");
       listStack.push("d");
       listStack.push("e");
       listStack.iterateStack();
        System.out.println(listStack.pop());
        System.out.println(listStack.pop());
        System.out.println(listStack.pop());
        System.out.println(listStack.pop());
        System.out.println(listStack.pop());
        System.out.println(listStack.pop());
    }
}

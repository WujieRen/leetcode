package com.ltc.wangzheng.binary_tree.flatten;

/**
 * @author rwj
 * @create_time 2021/12/13
 * @description
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

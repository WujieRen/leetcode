package com.ltc.wangzheng.binary_tree.n_tree;

import java.util.List;

/**
 * @author rwj
 * @create_time 2021/11/24
 * @description
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

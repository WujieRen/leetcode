package com.ltc.wangzheng.binary_tree.n_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author rwj
 * @create_time 2021/11/29
 * @description
 */
public class LevelOrderNtreeRecursion {

    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        o1_m1(root, res, 0);
        return res;
    }

    /**
     * 复杂度O(n)；而非递归那种写法是O(n^2)
     * @param node
     * @param res
     * @param depth
     */
    public void o1_m1(Node node, List<List<Integer>> res, int depth) {
        if (node == null) return;
        if(res.size() == depth) res.add(new LinkedList<>());
        res.get(depth).add(node.val);
        List<Node> children = node.children;
        for (Node subNode : children) o1_m1(subNode, res, depth + 1);
    }


    //TODO: -----------------自己的写法；写了个锤子的递归，只是个形式上的递归；真正思维上并没有实现一个好的递归...

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> leftStack = new Stack<>();
        leftStack.push(root);
        Stack<Node> rightStack = new Stack<>();
        m1(res, leftStack, rightStack);
        return res;
    }

    public void m1(List<List<Integer>> res, Stack<Node> stack1, Stack<Node> stack2) {
        if (stack1.isEmpty()) return;
        List<Integer> list = new LinkedList<>();
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);
            list.add(node.val);
        }
        res.add(list);
        while (!stack2.isEmpty()) {
            Node node = stack2.pop();
            List<Node> subNodes = node.children;
            if (subNodes != null) {
                for (int i = subNodes.size() - 1; i >= 0; --i) {
                    stack1.push(subNodes.get(i));
                }
            }
        }
        m1(res, stack1, stack2);
    }

    //以下是非递归代码
    /*public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Node> leftStack = new Stack<>();
        leftStack.push(root);
        Stack<Node> rightStack = new Stack<>();
        while (!leftStack.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            while (!leftStack.isEmpty()) {
                Node node = leftStack.pop();
                rightStack.push(node);
                list.add(node.val);
            }
            res.add(list);
            while (!rightStack.isEmpty()) {
                Node node = rightStack.pop();
                List<Node> subNodes = node.children;
                if(subNodes != null) {
                    for (int i = subNodes.size() - 1; i >= 0; --i) {
                        leftStack.push(subNodes.get(i));
                    }
                }
            }
        }
        return res;
    }*/
}

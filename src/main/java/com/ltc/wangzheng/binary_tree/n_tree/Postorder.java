package com.ltc.wangzheng.binary_tree.n_tree;

import java.util.*;

/**
 * @author rwj
 * @create_time 2021/11/24
 * @description n叉树后序遍历
 */
public class Postorder {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<>();
        postOrder(root, list);
        return list;
    }

    public void postOrder(Node root, List<Integer> list) {
        if(root == null) return;
        if(root.children != null && root.children.size() != 0) {
            for(Node node : root.children) {
                postOrder(node, list);
            }
        }
        list.add(root.val);
    }

    public List<Integer> o1(Node root) {
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }

        //叶子节点->中间节点
        if(root.children!=null && !root.children.isEmpty()){
            for(Node i:root.children){
                result.addAll(postorder(i));
            }
        }

        result.add(root.val);

        return result;
    }

    public List<Integer> o2(Node root) {
        List<Integer> list1 = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        if(root==null) return list1;
        stack.push(root);
        while(!stack.isEmpty()){
            Node temp = stack.poll();
            list1.add(temp.val);
            for(Node node : temp.children){
                stack.push(node);
            }
        }
        Collections.reverse(list1);
        return list1;
    }
}

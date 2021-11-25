package com.ltc.wangzheng.binary_tree.n_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/11/24
 * @description
 */
public class Preorder {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        preOrder(root, list);
        return list;
    }

    public void preOrder(Node root, List<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        if(root.children != null && root.children.size() != 0) {
            for(Node node : root.children) {
                preOrder(node, list);
            }
        }
    }

    public List<Integer> o1(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        LinkedList<Node> queue = new LinkedList<Node>();
        if(root==null){
            return res;
        }
        queue.add(root);
        while(queue.size()!=0){
            Node node = queue.poll();
            res.add(node.val);
            for(int i=node.children.size()-1;i>=0;i--){
                queue.addFirst(node.children.get(i));
            }
        }
        return res;
    }

}

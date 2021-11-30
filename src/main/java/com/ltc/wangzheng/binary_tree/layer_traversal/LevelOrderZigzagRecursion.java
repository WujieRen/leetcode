package com.ltc.wangzheng.binary_tree.layer_traversal;

import com.ltc.wangzheng.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/11/29
 * @description
 */
public class LevelOrderZigzagRecursion {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        addNode(root, 0);
        return res;
    }

    public void addNode(TreeNode node, int depth) {
        if(node == null) return;
        if(depth == res.size()) res.add(new LinkedList<>());
        if(depth % 2 == 0) res.get(depth).add(node.val);
        else res.get(depth).add(0, node.val);
        addNode(node.left, depth+1);
        addNode(node.right, depth+1);
    }

}

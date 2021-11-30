package com.ltc.wangzheng.binary_tree.layer_traversal;

import com.ltc.wangzheng.binary_tree.TreeNode;

import java.util.*;

/**
 * @author rwj
 * @create_time 2021/11/28
 * @description
 */
public class LevelOrderZigzag {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, null, new TreeNode(7, new TreeNode(8), new TreeNode(9))));
        TreeNode n2 = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, new TreeNode(6, new TreeNode(7), new TreeNode(8, new TreeNode(9), new TreeNode(10)))), new TreeNode(5)), new TreeNode(3));
        System.out.println(levelOrder(n1));
        System.out.println(levelOrder2(n1));
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
//        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
//                if(depth%2==0) list.add(cur.val);
                if(res.size() % 2 == 0) list.add(cur.val);
                else list.add(0, cur.val);
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            res.add(list);
//            depth++;
        }
        return res;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        while(queue.peek() != null) {
            List<Integer> list = new LinkedList<>();
            while(queue.peek() != null) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(i%2 == 0) {
                    if(node.left != null) stack.push(node.left);
                    if(node.right != null) stack.push(node.right);
                } else {
                    if(node.right != null) stack.push(node.right);
                    if(node.left != null) stack.push(node.left);
                }
            }
            res.add(list);
            while(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                queue.add(node);
            }
            ++i;
        }
        return res;
    }
}

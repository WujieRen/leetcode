package com.ltc.wangzheng.binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author rwj
 * @create_time 2021/12/1
 * @description
 */
public class MaxDepth {

    //TODO: 预留，是否可以只使用一个栈得到正确结果？
    public int maxDepth2(TreeNode root) {
        return 0;
    }


    /**
     * 以队列实现
     * @param root  根节点
     * @return  深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            ++depth;
        }
        return depth;
    }
}

package com.ltc.wangzheng.binary_tree;

import com.ltc.wangzheng.binary_tree.n_tree.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author rwj
 * @create_time 2021/12/1
 * @description
 */
public class MaxDepthNTree {

    /**
     * ------------------ 方法三   ------------------
     */

    public int maxDepth3(Node root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }

        for (Node cur : root.children) {
            depth = Math.max(depth, maxDepth3(cur));
        }

        return depth+1;
    }


    /**
     * ------------------ 方法二   ------------------
     */

    int maxDepth;

    public int maxDepthRecursion(Node root) {
        recursionInDepth(root, 0);
        return maxDepth;
    }

    public void recursionInDepth(Node node, int depth) {
        if (node == null || node.children == null) return;
        for (Node cur : node.children) {
            recursionInDepth(cur, depth + 1);
        }
        maxDepth = Math.max(depth, maxDepth);
    }


    /**
     * ------------------ 方法一   ------------------
     */

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node cur = queue.poll();
                queue.addAll(cur.children);
            }
            ++depth;
        }
        return depth;
    }
}

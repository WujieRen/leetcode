package com.ltc.wangzheng.binary_tree.n_tree;

import com.ltc.wangzheng.binary_tree.TreeNode;

import java.util.*;

/**
 * @author rwj
 * @create_time 2021/11/28
 * @description
 */
public class LevelOrderNtree {

    /**
     * o2_m2的时间复杂度明显比o1_m1的时间复杂度要低；
     * 优化点在于o1_m1中每次对于一个节点处理的时候，多遍历了一次该节点的子节点；所以每次处理的次数是和子节点个数成正比；
     * 而o2_m2每次只处理当前节点，addAll(subNodes)只处理了一遍子节点
     *
     * 时间复杂度： O(n^2)
     *  所有的节点都会放到Queue中；所以最外层for循环会执行n次；
     *  每次拿出Queue中的节点又会去把每一个节点的子节点全部放到Queue中；
     * @param root
     * @return
     */
    public List<List<Integer>> o2_m2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {//执行次数其实是少于n次的；但是和下面那个for循环加起来应该就是n次；
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < size; ++i) {//总体执行次数和外层循环一致；都是n次
                Node node = queue.poll();
                list.add(node.val);
                queue.addAll(node.children);    //该操作内部其实是对node.children的一个for循环和遍历；所以整体次数是n^2
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> o1_m1(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new LinkedList<>();
        list.add(root.val);
        res.add(list);
        while (!queue.isEmpty()) {
            int size = queue.size();
            list = new LinkedList<>();
            for (int i = 0; i < size; ++i) {
                Node cur = queue.poll();
                List<Node> children = cur.children;
                for (Node node : children) list.add(node.val);
                queue.addAll(children);
            }
            if(list.size() > 0) res.add(list);
        }
        return res;
    }

    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q1 = new LinkedList<>();
        q1.add(root);
        Queue<Node> q2 = new LinkedList<>();
        while (!q1.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            while (!q1.isEmpty()) {
                Node node = q1.poll();
                q2.add(node);
                list.add(node.val);
            }
            res.add(list);
            while (!q2.isEmpty()) {
                Node node = q2.poll();
                List<Node> subNodes = node.children;
                if (subNodes != null) {
                    q1.addAll(subNodes);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> leftStack = new Stack<>();
        leftStack.push(root);
        Stack<Node> rightStack = new Stack<>();
//        while (!leftStack.isEmpty() && leftStack.peek() != null) {
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
                if (subNodes != null) {
                    for (int i = subNodes.size() - 1; i >= 0; --i) {
                        leftStack.push(subNodes.get(i));
                    }
                }
            }
        }
        return res;
    }
}

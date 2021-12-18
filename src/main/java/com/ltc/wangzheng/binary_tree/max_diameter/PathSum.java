package com.ltc.wangzheng.binary_tree.max_diameter;

import com.ltc.wangzheng.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/12/16
 * @description
 */
public class PathSum {
    /**
     * 一开始我的写法
     */
    int sum;
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> list = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        addNodeToList(root, target);
        return res;
    }

    public void addNodeToList(TreeNode node, int target) {
        if (node == null) return;
        sum += node.val;
        list.add(node.val);
        if (sum == target && node.left == null && node.right == null) {
            List<Integer> tmp = new LinkedList<>(list);
            res.add(tmp);
        }
        addNodeToList(node.left, target);
        addNodeToList(node.right, target);
        list.removeLast();
        sum -= node.val;
    }

    /**
     * 借鉴了大佬的优化
     */
    List<List<Integer>> res2 = new ArrayList<>();
    Deque<Integer> list2 = new LinkedList<>();

    public List<List<Integer>> pathSum2(TreeNode root, int target) {
        addNodeToList2(root, target);
        return res2;
    }

    public void addNodeToList2(TreeNode node, int target) {
        if (node == null) return;

        list2.add(node.val);
        target -= node.val;
        if (node.left == null && node.right == null && target == 0) res2.add(new LinkedList<>(list2));

        addNodeToList(node.left, target);
        addNodeToList(node.right, target);
        list2.removeLast();
    }

    /** 看评论里这样也是可以的 */
    public List<List<Integer>> pathSum3(TreeNode root, int target) {
//        Deque<Integer> que = new LinkedList<>();
        addNodeToList3(root, target, new LinkedList<>());
        return res2;
    }
    public void addNodeToList3(TreeNode node, int target, List<Integer> que) {
        if (node == null) return;

        que.add(node.val);
        addNodeToList3(node.left, target-node.val, que);
        addNodeToList3(node.right, target-node.val, que);

        if (node.left == null && node.right == null && target == node.val) res.add(new LinkedList<>(que));
        //TODO: 如果用这个处理，que的类型必须是List<>才能得到正确结果，
        // 如果是Deque，结果错误，为什么？？？？？？？？？？？？？？？？？
        // 而如果用List<>作为参数的话，就没有removeLast()这个方法了
        que.remove(list.size());
    }
}

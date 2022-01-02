package com.ltc.wangzheng.dfs_bfs;

import java.util.*;

/**
 * @author rwj
 * @create_time 2022/1/1
 * @description https://leetcode-cn.com/problems/open-the-lock/
 *
 * 以下写法效率还是很低。 队列读取哪里优化以下效率是原先的 5倍左右
 *
 * 另外，Set的效率要比List高很多；在把deadends转为list那里，如果转换成Set的话，效率又可以提升4倍左右
 * 见 OpenLock2
 */
public class OpenLock {
    public static int openLock(String[] deadends, String target) {
        if ("00".equals(target)) return 0;

        int step = 0;
        List<String> deadList = Arrays.asList(deadends); //TODO: 转换为以下Set，效率能提升4倍左右
//        Set<String> deadList = new HashSet<>(Arrays.asList(deadends));
        if(deadList.contains("00")) return -1;
        Set<String> visited = new HashSet<>();
        visited.add("00");
//        Queue<String> que = new LinkedList<>();
        Queue<String> que = new LinkedList<>();
        que.add("00");
        //TODO: 这种写法的话，step++相当于在"00"就是第一层
        while (!que.isEmpty()) {
            ++step; // 所以这样的结果会比下面的结果大 1
            int size = que.size();
            for (int i = 0; i < size; ++i) {
                //1.取出值，如果命中死亡数字，跳过
                String cur = que.poll();
                if (!"00".equals(cur) && (deadList.contains(cur) || visited.contains(cur))) continue;
                //2.没有命中，对比是否和目标值相等
                if (target.equals(cur)) return step; //相等就说明找到了
                //不相等的话，把该数字下的所有可能数字，添加到队列中
                que.addAll(getNexts(cur));
                visited.add(cur);
            }
//            ++step;//如果不想让step大1，就要写在这里
        }
        /**
         * 上下两种写法中 step 的位置放在哪里导致结果的不同
         * 关键要理解 step 在代码中的涵义；这样才能理解为什么结果会出现 1 的偏差
         *      上面这种写法的step++ 刚进入循环对应的是 "00"，如果是 "00"就算是第一层
         *      下面这种写法"00"这层是不算第一层的， "00"的下一层才算是第一层
         *
         * 另外，上面那种写法的效率极低；因为 que.addAll() 相当的遍历了一遍 下一层元素； 然后下一次for循环进来还得遍历一遍
         * 下面这种写法是只遍历了一遍
         */
        //TODO: 这种写法相当于 step==1 时已经在 "00"的下一层了
        /*while (!que.isEmpty()) {
            ++step; //
            int size = que.size();
            for (int i = 0; i < size; ++i) {
                String status = que.poll();
                for (String nextStatus : getNexts(status)) {
                    if (!visited.contains(nextStatus) && !deadList.contains(nextStatus)) {
                        if (nextStatus.equals(target)) {
                            return step;
                        }
                        que.offer(nextStatus);
                        visited.add(nextStatus);
                    }
                }
            }
        }*/
        return -1;
    }

    public static List<String> getNexts(String cur) {
        /*List<String> list = new LinkedList<>();
        for (int i = 0; i < 2; ++i) {
            StringBuilder sb = new StringBuilder(cur);
            sb.setCharAt(i, sb.charAt(i) == '0' ? '9' : (char) (sb.charAt(i) - 1)); // 每次-1才会变成0
            list.add(sb.toString());
            sb.setCharAt(i, sb.charAt(i) == '9' ? '0' : (char) (sb.charAt(i) + 1)); // 每次+1才会变成9
            list.add(sb.toString());
        }
        return list;*/
        List<String> ret = new ArrayList<String>();
        char[] array = cur.toCharArray();
        for (int i = 0; i < 4; ++i) {
            char num = array[i];
            array[i] = num == '0' ? '9' : (char) (num - 1);
            ret.add(new String(array));
            array[i] = num == '9' ? '0' : (char) (num + 1);
            ret.add(new String(array));
            array[i] = num;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(openLock(new String[]{"05", "07"}, "11"));
    }
}

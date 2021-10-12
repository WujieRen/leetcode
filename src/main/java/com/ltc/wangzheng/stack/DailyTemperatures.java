package com.ltc.wangzheng.stack;

/**
 * @author rwj
 * @create_time 2021/10/11
 * @description 这个写法居然要1829ms....
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        int slow = 0, fast = 1;
        while (slow < len) {
            while (fast < len) {
                if (temperatures[fast] > temperatures[slow]) {
                    res[slow] = fast - slow;
                    break;
                }
                ++fast;
            }
            if(slow == len - 2) break;
            ++slow;
            fast = slow + 1;
        }
        return res;
    }
}

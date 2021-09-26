package com.ltc.wangzheng.pure_code;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author rwj
 * @create_time 2021/9/23
 * @description 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *               所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 *
 */
public class SumTwoNum {
    public static void main(String[] args) {
        int[][] res = f1(new int[]{5, 4, 3, 4, 2, 6}, 8);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

    // O(n^2)
    private static int[][] f1(int[] nums, int sum) {
        int size = nums.length;
        int[][] res = new int[size/2][2];
        int row = 0;
        for(int i = 0; i < size; ++i) {
            for(int j = i + 1; j < size; ++j) {
                if(nums[i] + nums[j] == sum) {
                    res[row++] = new int[]{i, j};
                    break;
                }
            }
        }
        return res;
    }

    public static int[] f2(int[] nums, int target) {
        int size = nums.length;
        int[] res = new int[2];
        HashMap<Integer, Integer> hashNum = new HashMap<Integer, Integer>(2*nums.length);
        for(int i = 0; i < size; ++i) {
            if(hashNum.containsKey(target - nums[i])) {
                return new int[]{hashNum.get(nums[i]), i};
            }
            hashNum.put(nums[i], i);
        }
        return res;
    }
}

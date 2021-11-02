package com.ltc.wangzheng.hash;

import java.util.HashMap;
import java.util.Map;

public class FindSwapValues {
    public static void main(String[] args) {

    }
    public int[] findSwapValues(int[] array1, int[] array2) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum1 = 0;
        for (int num : array1) {
            map.put(num, num);
            sum1 += num;
        }
        int sum2 = 0;
        for (int num : array2) {
            sum2 += num;
        }
        if (sum1 == sum2) {
            for (int num : array2) {
                if (map.containsKey(num)) return new int[]{num, num};
            }
        }
        int subtract = Math.abs(sum1 - sum2);
        if (subtract % 2 == 0) {
            int indexNum = subtract/2;
            for (int j : array2) {
                if (map.get(j + indexNum) != null) return new int[]{map.get(j + indexNum), j};
                if (map.get(j - indexNum) != null) return new int[]{map.get(j - indexNum), j};
            }
        }
        return new int[]{};
    }
}

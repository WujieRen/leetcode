package com.ltc.wangzheng.binary_search;

public class MySqrt {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(mySqrt2(Integer.MAX_VALUE));
    }

    public static int mySqrt2(int x) {
        int left = 0, right = x / 2 + 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long curV = (long) mid * mid;
            if (curV == x) {
                return mid;
            } else if (curV > x) {
                long leftV = (long) (mid - 1) * (mid - 1);
                if(leftV <= x) return mid - 1;
                right = mid - 1;
            } else {
//                long rightV = (long) (mid + 1) * (mid + 1);
//                if(rightV > x) return mid;
                left = mid + 1;
            }
        }
        return right;
    }

}

package com.ltc.wangzheng.binary_search;

public class IsPerfectSquare {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(808201));
        System.out.println(isPerfectSquare(2147395600));
    }

    public static boolean isPerfectSquare2(int num) {
        if(num ==0 || num == 1) return true;
        int left = 1, right = num / 2 + 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long tmpV = (long)mid*mid;
            if(tmpV == num) {
                return true;
            } else if(tmpV > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    //TODO: 错误答案；试了半天无法解决值大于Integer.MAX_VALUE时的情况；遇到这种情况可以考虑放弃了。
    public static boolean isPerfectSquare(int num) {
        if(num ==0 || num == 1) return true;
//        if(num == Integer.MAX_VALUE) return false;
        int left = 1, right = num / 2;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int tmp = mid * mid;
            int tmpV = (mid * mid) <= 0 ? Integer.MAX_VALUE : mid*mid;
            if (tmpV == num && num != Integer.MAX_VALUE) return true;
            if (tmpV < num) left = mid + 1;
            if (tmpV > num || tmpV == Integer.MAX_VALUE) right = mid - 1;
        }
        return false;
    }
}

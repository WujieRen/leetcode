package com.ltc.wangzheng.binary_search;

public class GuessNumber {
    public static void main(String[] args) {

    }

    private int guess(int n) {
        return 0;
    }

    public int f1(int n) {
        int left = 1, right = n;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    public int guessNumber(int n) {
        int left = 1, right = n;
        while(left < right) {
            int mid = left + (right-left)/2;
            if(guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    public int guessNumber2(int n) {
        int left = 1, right = n;
        while(left < right) {   // 循环直至区间左右端点相同
            int mid = left + (right-left)/2;    // 防止计算时溢出
            if(guess(mid) <= 0) {   // 答案在区间 [left, mid] 中
                right = mid;    // 答案在区间 [mid+1, right] 中
            } else {
                left = mid+1;
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }

}

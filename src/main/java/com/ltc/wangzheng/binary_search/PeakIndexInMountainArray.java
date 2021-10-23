package com.ltc.wangzheng.binary_search;

public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray2(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
//            if(mid == 0) return arr[mid] > arr[mid+1] ? mid : mid + 1;
            if(mid == 0) return mid + 1;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (arr[mid + 1] > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


        public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int mV = arr[mid];
            int lV = mid == 0 ? Integer.MIN_VALUE : arr[mid - 1];
            int rV = mid == arr.length-1 ? Integer.MAX_VALUE : arr[mid + 1];
            if (mV > lV && mV > rV) {
                return mid;
            } else if (mV > lV && mV < rV) {
                left = mid + 1;
            } else if(mV < lV && mV > rV) {
                right = mid - 1;
            }
        }
        return left;
    }
}

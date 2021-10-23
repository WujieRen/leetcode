package com.ltc.wangzheng.binary_search;

public class SearchMatrix {

    public static void main(String[] args) {
        int[][] tmp = new int[1][2];
        tmp[0][0] = 1;
        tmp[0][1] = 1;
        System.out.println(o2(tmp, 2));
    }

    public static boolean o2(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = row * col - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int midValue = matrix[mid / col][mid % col];
            if (midValue == target) {
                return true;
            } else if (midValue > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public boolean o1(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1, row = -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (mid == matrix.length - 1) {
                row = mid;
                break;
            }
            if (matrix[mid][0] <= target && matrix[mid + 1][0] > target) {
                row = mid;
                break;
            }
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (row == -1) return false;
        left = 0;
        right = matrix[0].length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}

package com.ltc.wangzheng.binary_search;

public class NextGreatestLetter {
    public static void main(String[] args) {
        char[] cs = new char[]{'a','b','c','d','e','f','g','h','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        System.out.println(nextGreatestLetter3(cs, 'a'));

    }

    public static char nextGreatestLetter3(char[] letters, char target) {
        int maxIdx = letters.length - 1, low = 0, high = maxIdx;
        while (low <= high) {
            int mid = low + (high - low) / 2;

        }
        return letters[0];
    }


    public static char nextGreatestLetter2(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                if (mid != letters.length - 1 && letters[mid + 1] > target) return letters[mid + 1];
                left = mid + 1;
            } else {
                if (mid != 0 && letters[mid - 1] <= target) return letters[mid];
                right = mid - 1;
            }
        }
        return letters[0];
    }

    private static char f1(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        return f2(letters, left, right, target);
    }

    private static char f2(char[] letters, int left, int right, char target) {
        if (left >= right) return letters[0];
        int mid = left + (right - left) / 2;
        if (letters[mid] <= target) {
            if (mid != letters.length - 1 && letters[mid + 1] > target) return letters[mid + 1];
            return f2(letters, mid + 1, right, target);
        } else {
            if (mid != 0 && letters[mid - 1] <= target) return letters[mid];
            return f2(letters, left, mid - 1, target);
        }
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length, left = 0, right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                if (mid != len - 1 && letters[mid + 1] > target) return letters[mid + 1];
                left = mid + 1;
            } else {
                if (mid != 0 && letters[mid - 1] <= target) return letters[mid];
                right = mid - 1;
            }
        }
        return letters[0];
    }
}

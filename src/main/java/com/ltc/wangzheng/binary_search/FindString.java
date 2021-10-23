package com.ltc.wangzheng.binary_search;

public class FindString {
    public static void main(String[] args) {

    }

    public int findString2(String[] words, String s) {
        int left = 0, right = words.length - 1;
        while (left <= right) {
          int mid = (right-left)/2+left;
          if(words[mid].equals(s)) {
              return mid;
          } else if(words[mid].equals("")) {
              if(words[left].equals(s)) return left;
              left++;
          } else if (words[mid].compareTo(s) > 0) {
              right = mid - 1;
          } else {
              left = mid + 1;
          }
        }
        return -1;
    }

    public int findString(String[] words, String s) {
        int left = 0, right = words.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            String curWord = words[mid];
            if (curWord.equals(s)) {
                return mid;
            } else if(curWord.equals("")) {
                if(words[right].equals(s)) return right;
                right--;
            } else if (curWord.compareTo(s) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

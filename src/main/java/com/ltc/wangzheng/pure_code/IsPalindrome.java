package com.ltc.wangzheng.pure_code;

/**
 * @author rwj
 * @create_time 2021/9/24
 * @description
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isNumOrDigit('a'));
        System.out.println(f4("A man, a plan, a canal: Panama"));
    }

    //1ms
    public boolean f6(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            while (left < right && !((leftChar >= 'A' && leftChar <= 'Z')
                    || (leftChar >= 'a' && leftChar <= 'z')
                    || (leftChar >= '0' && leftChar <= '9'))) {
                leftChar = s.charAt(++left);
            }
            leftChar = leftChar > 'Z' ? (char) (leftChar - 32) : leftChar;
            char rightChar = s.charAt(right);
            while (left < right && !((rightChar >= 'A' && rightChar <= 'Z')
                    || (rightChar >= 'a' && rightChar <= 'z')
                    || (rightChar >= '0' && rightChar <= '9'))) {
                rightChar = s.charAt(--right);
            }
            rightChar = rightChar > 'Z' ? (char) (rightChar - 32) : rightChar;
            if (leftChar != rightChar) return false;
            ++left;
            --right;
        }
        return true;
    }

    private static boolean isNumOrDigit(char c) {
        return (c >= 'A' && c <= 'Z')
                || (c >= 'a' && c <= 'z')
                || (c >= '0' && c <= '9');
    }

    //2ms  相比较f6而言，只是提出来了一个方法，结果执行时间居然就慢了1ms...
    private static boolean f5(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            while (left < right && !isNumOrDigit(leftChar)) {
                leftChar = s.charAt(++left);
            }
            char rightChar = s.charAt(right);
            while (left < right && !isNumOrDigit(rightChar)) {
                rightChar = s.charAt(--right);
            }
            leftChar = leftChar > 'Z' ? (char) (leftChar - 32) : leftChar;
            rightChar = rightChar > 'Z' ? (char) (rightChar - 32) : rightChar;
            if (leftChar != rightChar) return false;
            ++left;
            --right;
        }
        return true;
    }

    private static boolean f4(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isNumOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !isNumOrDigit(s.charAt(right))) {
                --right;
            }
            char leftChar = s.charAt(left);
            leftChar = leftChar > 'Z' ? (char) (leftChar - 32) : leftChar;
            char rightChar = s.charAt(right);
            rightChar = rightChar > 'Z' ? (char) (rightChar - 32) : rightChar;
            if (leftChar != rightChar) return false;
            ++left;
            --right;
        }
        return true;
    }

    private static boolean f3(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char charLeft = s.charAt(left);
            char charRight = s.charAt(right);
            if (!isNumOrDigit(charLeft)) {
                ++left;
                continue;
            }
            if (!isNumOrDigit(charRight)) {
                --right;
                continue;
            }
            charLeft = charLeft > 'Z' ? (char) (charLeft - 32) : charLeft;
            charRight = charRight > 'Z' ? (char) (charRight - 32) : charRight;
            if (charLeft != charRight) return false;
            ++left;
            --right;
        }
        return true;
    }

    private static boolean f2(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }


    private static boolean f1(String s) {
        int n = s.length() - 1;
        for (int i = 0, j = n; i < j; ) {
            char left = Character.toLowerCase(s.charAt(i));
            char right = Character.toLowerCase(s.charAt(j));
            if (!Character.isLetterOrDigit(left)) {
                ++i;
                continue;
            }
            if (!Character.isLetterOrDigit(right)) {
                --j;
                continue;
            }
            if (left != right) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
}

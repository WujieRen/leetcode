package com.ltc.wangzheng.stack;

import java.util.LinkedList;

/**
 * @author rwj
 * @create_time 2021/10/10
 * @description
 */
public class Calculate {

    static LinkedList<Integer> nums = new LinkedList<Integer>();
    static LinkedList<Character> operators = new LinkedList<Character>();

    public static void main(String[] args) {
//        String s = "100000000/1/2/3/4/5/6/7/8/9/10";
        String s = "1*2-3/4+5*6-7*8+9/10";
        System.out.println(f1(s));
    }

    private static int calNum(int n1, int n2, char operator) {
        if (operator == '-') return n1 - n2;
        if (operator == '+') return n1 + n2;
        if (operator == '*') return n1 * n2;
        return n2 == 0 ? 0 : n1 / n2;
    }

    private static boolean isBigOperator(char o1, char o2) {
        return ((o1 == '*' || o1 == '/') && (o2 == '-' || o2 == '+'));
    }


    private static int f1(String s) {
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == ' ') continue;
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (i < len && Character.isDigit(s.charAt(i))) {
                    num = (num * 10 + (s.charAt(i) - 48));
                    ++i;
                }
                nums.addLast(num);
            }

            if (i >= len) break;

            char operator = s.charAt(i);
            if (operator == ' ') continue;
            if(operators.isEmpty()) {
                operators.addLast(operator);
                continue;
            }
            if (isBigOperator(operator, operators.peek())) {
                int numNext = 0;
                ++i;
                while (s.charAt(i) == ' ') ++i;
                while (i < len && Character.isDigit(s.charAt(i))) {
                    numNext = (numNext * 10 + (s.charAt(i) - 48));
                    ++i;
                }
                int numLast = nums.removeLast();
                int res = calNum(numLast, numNext, operator);
                nums.addLast(res);
                --i;
            } else {
                int num1 = nums.removeLast();
                int num2 = nums.removeLast();
                char lastOperator = operators.removeFirst();
                int tmpRes = calNum(num2, num1, lastOperator);
                nums.addLast(tmpRes);
                operators.addLast(operator);
            }
        }
        System.out.println(nums);
        System.out.println(operators);

        if(!nums.isEmpty() && !operators.isEmpty()) {
            return calNum(nums.removeFirst(), nums.removeFirst(), operators.removeFirst());
        } else {
            return nums.removeFirst();
        }
    }
}

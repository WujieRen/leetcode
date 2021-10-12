package com.ltc.wangzheng.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author rwj
 * @create_time 2021/10/11
 * @description
 */
public class Calculate2 {

    public static void main(String[] args) {
        String s = "5-3*2+4/6";
        System.out.println(calculate(s));
    }

    private static int calculate(String s) {
        s = s.replaceAll(" ","");//简直有毒有空格没认真读题的痛
        Deque<Integer> q = new ArrayDeque<Integer>();
        char flag = '+';
        int num = 0;
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10 + (s.charAt(i) - '0');
            }
            if(!Character.isDigit(s.charAt(i)) || i == s.length()-1){
                switch(flag){
                    case '+':
                        q.push(num);
                        break;
                    case '-':
                        q.push(-num);
                        break;
                    case '*':
                        q.push(q.pop()*num);
                        break;
                    case '/':
                        q.push(q.pop()/num);
                        break;
                }
                flag = s.charAt(i);
                num = 0;
            }
        }
        while(!q.isEmpty()){
            num += q.pop();
        }
        return num;
    }

}

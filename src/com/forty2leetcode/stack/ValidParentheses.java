package com.forty2leetcode.stack;

import java.util.Stack;

/*
* leetcode: 20
* author: Forty2
* date: 09/19/2017
*
* */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        if (s.length() % 2 != 0) {
            return false;
        }
        char[] arr = s.toCharArray();
        for (char t : arr) {
            if (t == '[' || t == '{' || t == '(') {
                stk.push(t);
            }
            if (t == ']' || t == ')' || t == '}') {
                if (stk.isEmpty()) {
                    return false;
                } else if (stk.peek() == '(' && t != ')') {
                    return false;
                } else if (stk.peek() == '{' && t != '}') {
                    return false;
                } else if (stk.peek() == '[' && t != ']') {
                    return false;
                }
                stk.pop();

            }

        }
        return stk.isEmpty();
    }
}

package com.wy.leetcode.question22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2020/4/23
 * @description
 */
public class Solution {
    /**
     * 第一种解法，暴力解法
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAll(new char[2 * n], 0, result);
        return result;
    }

    private void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (isValid(current)) {
                result.add(String.valueOf(current));
            }
            return;
        }
        current[pos] = '(';
        generateAll(current, pos + 1, result);
        current[pos] = ')';
        generateAll(current, pos + 1, result);
    }

    private boolean isValid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                balance++;
            }
            if (c == ')') {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    /**
     * 第二种解法，回溯
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        traceback(new char[2 * n], 0, 0, result, 0);
        return result;
    }

    private void traceback(char[] current, int open, int close, List<String> result, int pos) {
        if (current.length == pos) {
            result.add(String.valueOf(current));
            return;
        }
        if (open < current.length / 2) {
            current[pos] = '(';
            traceback(current, open + 1, close, result, pos + 1);
        }

        if (close < open) {
            current[pos] = ')';
            traceback(current, open, close + 1, result, pos + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        final List<String> strings = solution.generateParenthesis2(3);
        System.out.println(strings);
    }
}

package com.wy.leetcode.question17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wy
 * @date 2020/4/22
 * @description
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Solution {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    Map<Character, String> phoneChar = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String nextDigits) {
        // if there is no more digits to check
        if (nextDigits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = nextDigits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, nextDigits.substring(1));
            }
        }
    }

    public List<String> letterCombinations1(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        List<StringBuilder> builderList = new ArrayList<>();
        int len = digits.length();
        for (int i = 0; i < len; i++) {
            final char c = digits.charAt(i);
            final String currDigStr = phoneChar.get(c);
            final int currentDigitLen = currDigStr.length();
            for (int j = 0; j < currentDigitLen; j++) {
                final char c1 = currDigStr.charAt(j);
                for (StringBuilder stringBuilder : builderList) {
                    stringBuilder.append(c1);
                }
            }

        }
        return result;
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }
}

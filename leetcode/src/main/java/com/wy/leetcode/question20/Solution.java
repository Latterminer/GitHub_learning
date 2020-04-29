package com.wy.leetcode.question20;

import java.util.Stack;

/**
 * @author wy
 * @date 2020/4/23
 * @description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                characterStack.push(c);
            }
            if (c == ')' || c == ']' || c == '}') {
                if (characterStack.isEmpty()) {
                    return false;
                }
                final Character pop = characterStack.pop();
                if (c == ')' && !pop.equals('(')) {
                    return false;
                }
                if (c == ']' && !pop.equals('[')) {
                    return false;
                }
                if (c == '}' && !pop.equals('{')) {
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        final boolean valid = solution.isValid("()");
        System.out.println(valid);
    }
}

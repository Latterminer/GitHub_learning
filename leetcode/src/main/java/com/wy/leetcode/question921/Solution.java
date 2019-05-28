package com.wy.leetcode.question921;

import java.util.Stack;

/**
 * @author wy
 * @date 2019-05-28
 * @description 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
 * <p>
 * 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
 * <p>
 * 它是一个空字符串，或者
 * 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 * 它可以被写作 (A)，其中 A 是有效字符串。
 * 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："())"
 * 输出：1
 * 示例 2：
 * <p>
 * 输入："((("
 * 输出：3
 * 示例 3：
 * <p>
 * 输入："()"
 * 输出：0
 * 示例 4：
 * <p>
 * 输入："()))(("
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * S.length <= 1000
 * S 只包含 '(' 和 ')' 字符。
 */
public class Solution {
    /**
     * 借用辅助栈
     *
     * @param S
     * @return
     */
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push('(');
            } else if (c == ')' && !stack.isEmpty()) {
                stack.pop();
            } else {
                result++;
            }
        }
        result += stack.size();
        return result;
    }

    /**
     * 别人的方法
     *
     * @param S
     * @return
     */
    public int minAddToMakeValid1(String S) {
        int n = S.length();
        //1.空字符串
        if (n == 0) {
            return 0;
        }
        //3.AB
        int ans = 0;
        int cnt = 0;
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                cnt++;
            } else if (cnt > 0) {
                cnt--;
            } else {
                ans++;//消耗)
            }
        }
        //消耗剩余(
        ans += cnt;
        return ans;
    }
}

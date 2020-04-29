package com.wy.leetcode.question171;

/**
 * @author wangyong
 * @date 2019/5/28
 * @description
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     TestExecutionOrder -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 */
public class Solution {
    public int titleToNumber(String s) {
        int len = s.length();
        int result = 0;
        for (int i = 0; i< len; i++) {
            int base = (int) Math.pow(26, len-1-i);
            result += base* (s.charAt(i)-'A' +1);
        }
        return result;
    }
    public int titleToNumber1(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int ret = 0;
        for(char c:s.toCharArray()){
            ret = ret * 26 + c - 'A' + 1;
        }
        return ret;
    }
}

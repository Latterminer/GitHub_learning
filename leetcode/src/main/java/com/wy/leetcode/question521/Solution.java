package com.wy.leetcode.question521;

/**
 * @author wangyong
 * @date 2019/6/7
 * @description 给定两个字符串，你需要从这两个字符串中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 * <p>
 * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 * <p>
 * 输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。
 * <p>
 * 示例 :
 * <p>
 * 输入: "aba", "cdc"
 * 输出: 3
 * 解析: 最长特殊序列可为 "aba" (或 "cdc")
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-uncommon-subsequence-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 如果两个串相等，不存在独有的子序列，那么返回 -1; 如果两个串不相等，则返回长的那个
     *
     * @param a
     * @param b
     * @return
     */
    public int findLUSlength(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        return a.equals(b) ? -1 : lenA > lenB ? lenA : lenB;
    }
}

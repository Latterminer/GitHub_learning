package com.wy.leetcode.question942;

/**
 * @author wangyong
 * @date 2019/5/15
 * @description
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 *
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 *
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 *
 *
 * 示例 1：
 *
 * 输出："IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 *
 * 输出："III"
 * 输出：[0,1,2,3]
 */
public class Solution {
    /**
     * 减 从最大开始；增 从最小开始。
     * @param S
     * @return
     */
    public int[] diStringMatch(String S) {
        int len = S.length();
        int currentMax = len;
        int currentMin = 0;
        int[] result = new int[len + 1];
        for (int i = 0; i < len; i++) {
            char temp = S.charAt(i);
            if (temp == 'I') {
                result[i]=currentMin++;
            }
            if (temp == 'D') {
                result[i]=currentMax--;
            }
        }
        result[len] = currentMax;
        return result;
    }
}

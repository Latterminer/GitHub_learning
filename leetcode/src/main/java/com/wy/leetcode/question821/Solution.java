package com.wy.leetcode.question821;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2019-05-29
 * @description
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 *
 * 示例 1:
 *
 * 输入: S = "loveleetcode", C = 'e'
 * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * 说明:
 *
 * 字符串 S 的长度范围为 [1, 10000]。
 * C 是一个单字符，且保证是字符串 S 里的字符。
 * S 和 C 中的所有字母均为小写字母。
 */
public class Solution {
    public int[] shortestToChar(String S, char C) {
        int len = S.length();
        List<Integer> dict = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == C) {
                dict.add(i);
            }
        }
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int min = len;
            for (int j = 0; j < dict.size(); j++) {
                int dist = Math.abs(dict.get(j) - i);
                if (min > dist) {
                    min = dist;
                }
            }
            result[i] = min;
        }
        return result;
    }
}

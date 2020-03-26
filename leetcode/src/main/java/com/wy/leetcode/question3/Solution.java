package com.wy.leetcode.question3;

import java.util.HashMap;

/**
 * @author wy
 * @date 2020/3/24
 * @description
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> cache = new HashMap<>();
        final int length = s.length();
        int asw = 0;
        for (int i = 0, j = i+1; i < length && j < length; j++) {
            if (cache.containsKey(s.charAt(j))) {
                i = cache.get(s.charAt(j));
            }
            asw = Math.max(asw, j - i +1);
            cache.put(s.charAt(j), j + 1);
        }
        return asw;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s.equals("")) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        int max = 1;
        int now ;
        for (int i=1; i<chars.length; i++) {
            for (int j=start; j<i; j++) {
                if (chars[i] ==chars[j]) {
                    start = j+1;
                    break;
                }
            }
            now = i-start+1;
            if (now>max) {
                max = now;
            }
        }
        return max;
    }
}

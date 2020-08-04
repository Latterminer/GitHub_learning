package com.wy.leetcode.question139;

import java.util.List;

/**
 * @author wy
 * @date 2020/5/27
 * @description 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, 0);
    }

    /**
     * 递归匹配前缀，如果匹配前缀成功，则匹配剩下的字符串
     */
    private boolean helper(String s, List<String> workDict, int start) {
        if (start == s.length()) {
            return true;
        }

        for (int prefixEnd = start; prefixEnd < s.length(); prefixEnd++) {
            if (workDict.contains(s.substring(start, prefixEnd + 1)) && helper(s, workDict, prefixEnd + 1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * dp
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        final int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length + 1; j++) {
                if (dp[i] && wordDict.contains(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[length];
    }
}

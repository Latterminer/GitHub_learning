package com.wy.leetcode.question5;

/**
 * @author wy
 * @date 2020/3/26
 * @description
 */
public class Solution {
    /**
     * 暴力解法
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s.substring(i, j + 1)) && j + 1 - i > max.length()) {
                    max = s.substring(i, j + 1);
                }
            }
        }
        return max;
    }

    /**
     * dynamic programming
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String max = "";
        boolean[][] isPalindrome = new boolean[s.length()][s.length() + 1];
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                // 当子串的长度只有1，2，3时，只需要判断首尾两个字母相同就行
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                }
                if (isPalindrome[i][j] && j - i + 1 > max.length()) {
                    max = s.substring(i, j + 1);
                }
            }
        }
        return max;
    }

    private boolean isPalindrome(String s) {
        StringBuilder reversedStr = new StringBuilder(s).reverse();
        return s.equals(reversedStr.toString());
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        final String abbc = s.longestPalindrome2("cbbd");
        System.out.println(abbc);
    }
}

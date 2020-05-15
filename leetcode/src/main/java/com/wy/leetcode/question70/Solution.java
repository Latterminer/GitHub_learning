package com.wy.leetcode.question70;

/**
 * @author wy
 * @date 2020/5/15
 * @description
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class Solution {
    /**
     * 斐波那切数列
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int fibMinusOne = 1;
        int fibMinusTwo = 2;
        int fibN = 0;
        for (int i = 3; i <= n; i++) {
            fibN = fibMinusOne + fibMinusTwo;
            fibMinusOne= fibMinusTwo;
            fibMinusTwo = fibN;
        }
        return fibMinusTwo;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        final int i = solution.climbStairs(4);
        System.out.println(i);
    }
}

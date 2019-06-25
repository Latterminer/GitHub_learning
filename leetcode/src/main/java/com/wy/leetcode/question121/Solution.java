package com.wy.leetcode.question121;

/**
 * @author wy
 * @date 2019-06-22
 * @description
 */
public class Solution {
    /**
     * 第一种暴力解法，两次遍历
     * 第二种：动态规划，一次遍历，每一步都记录到当前为止最小的价格，最大的利润
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            int profit = price - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}

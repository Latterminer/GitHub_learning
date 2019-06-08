package com.wy.leetcode.question204;

/**
 * @author wangyong
 * @date 2019/6/8
 * @description
 */
public class Solution {
    /**
     * 按照定义来计算
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(i)) {
                result++;
            }
        }
        return result;
    }

    /**
     * 判断是否为质数
     * 如果N是合数，则一定存在大于1小于N的整数d1和d2，使得N=d1×d2。
     * 如果d1和d2均大于√N，则有：N＝d1×d2>√N×√N＝N。
     * 而这是不可能的，所以，d1和d2中必有一个小于或等于√N。
     *
     * @param num
     * @return
     */
    private static boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 厄拉多塞筛法
     * @param n
     * @return
     */
    public static int countPrimes1(int n) {
        boolean[] flags = new boolean[n];
        for (int i = 2; i < n; i++) {
            flags[i] = true;
        }

        /*
        厄拉多塞筛法
         */
        for (int i = 2; i * i < n; i++) {
            for (int j = i * i; j < n; j += i) {
                if (flags[j] && j % i == 0) {
                    flags[j] = false;
                }
            }
        }
        int result = 0;
        for (boolean b : flags) {
            if (b) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(
                499979));
    }
}

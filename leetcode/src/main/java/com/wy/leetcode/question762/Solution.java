package com.wy.leetcode.question762;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wangyong
 * @date 2019/6/7
 * @description
 * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
 *
 * （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
 *
 * 示例 1:
 *
 * 输入: L = 6, R = 10
 * 输出: 4
 * 解释:
 * 6 -> 110 (2 个计算置位，2 是质数)
 * 7 -> 111 (3 个计算置位，3 是质数)
 * 9 -> 1001 (2 个计算置位，2 是质数)
 * 10-> 1010 (2 个计算置位，2 是质数)
 * 示例 2:
 *
 * 输入: L = 10, R = 15
 * 输出: 5
 * 解释:
 * 10 -> 1010 (2 个计算置位, 2 是质数)
 * 11 -> 1011 (3 个计算置位, 3 是质数)
 * 12 -> 1100 (2 个计算置位, 2 是质数)
 * 13 -> 1101 (3 个计算置位, 3 是质数)
 * 14 -> 1110 (3 个计算置位, 3 是质数)
 * 15 -> 1111 (4 个计算置位, 4 不是质数)
 * 注意:
 *
 * L, R 是 L <= R 且在 [1, 10^6] 中的整数。
 * R - L 的最大值为 10000。
 *
 */
public class Solution {
    /**
     * 自己的解法，效率很慢
     *
     * @param L
     * @param R
     * @return
     */
    public static int countPrimeSetBits(int L, int R) {
        List<Integer> result = new LinkedList<>();
        for (int i = L; i <= R; i++) {
            /*
            求1的个数
             */
            int bits = 0;
            int temp = i;
            while (temp != 0) {
                if ((temp & 1) == 1) {
                    bits++;
                }
                temp = temp >> 1;
            }
            if (isPrime(bits)) {
                result.add(i);
            }
        }
        return result.size();
    }

    /**
     * 判断是否为质数
     *
     * @param num
     * @return
     */
    private static boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 用Integer中的bitcount计算1的个数
     *
     * @param L
     * @param R
     * @return
     */
    public int countPrimeSetBits1(int L, int R) {
        /*
        因为L和R都是整型，所以1的个数最多也就是32，把32中所有的质数找出来，用32位bit表示，1代表i为质数
         */
        int primeBit = 0x50451456;
        int ans = 0;
        for (; L <= R; L++) {
            //假设1的个数为10，那么需要判断primeBit的第i位是否是1，如果是则为质数，否则不是
            ans += (primeBit >> Integer.bitCount(L) - 1) & 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(6, 10));
    }
}

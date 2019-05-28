package com.wy.leetcode.question961;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangyong
 * @date 2019/5/19
 * @description
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 *
 * 返回重复了 N 次的那个元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 *
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 */
public class Solution {
    /**
     * 两种方法:
     * 一种是用set，另一种思路：
     * 有一半的数相等，那么排列中要么所有相同的数都不相邻，要么就必定存在相邻并相等的情形。
     * int repeatedNTimes(int* A, int ASize) { int i; if(A[1]==A[3]) return A[1];
     * @param A
     * @return
     */
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            boolean addResult = set.add(a);
            if (!addResult) {
                return a;
            }
        }
        return -1;
    }

    public int repeatedNtimes1(int[] A) {
        int i, len = A.length;
        for(i = 0; i + 1 < len; i++) {
            if(A[i] == A[i+1] || (i+2 < len && A[i] == A[i+2])) break;
        }
        return A[i];
    }
}

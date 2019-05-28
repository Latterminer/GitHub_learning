package com.wy.leetcode.question728;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyong
 * @date 2019/5/16
 * @description
 * 自除数 是指可以被它包含的每一位数除尽的数。
 *
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 *
 * 还有，自除数不允许包含 0 。
 *
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 *
 * 示例 1：
 *
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 */
public class Solution {
    /**
     *
     * @param left
     * @param right
     * @return
     */
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        firstLoop:
        for (int i = left; i <= right; i++) {
            String temp = String.valueOf(i);
            for (int j = 0; j < temp.length(); j++) {
                int num = temp.charAt(j) - '0';
                if (num == 0 || i % num != 0) {
                    continue firstLoop;
                }
            }
            result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22).toString());
    }
}

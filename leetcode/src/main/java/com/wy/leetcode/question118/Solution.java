package com.wy.leetcode.question118;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wangyong
 * @date 2019/6/7
 * @description 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        result.add(row1);
        if (numRows == 1) {
            return result;
        }
        List<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(1);
        result.add(row2);
        if (numRows == 2) {
            return result;
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            int len = result.get(i - 1).size() - 1;
            for (int j = 0; j < len; j++) {
                currentRow.add(result.get(i - 1).get(j) + result.get(i - 1).get(j + 1));
            }
            currentRow.add(1);
            result.add(currentRow);

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}

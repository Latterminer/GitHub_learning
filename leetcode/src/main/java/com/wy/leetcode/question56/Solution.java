package com.wy.leetcode.question56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wy
 * @date 2020/5/14
 * @description
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals.length == 0) {
            return new int[][]{};
        }
        final List<int[]> intervalList = Arrays.asList(intervals);
        intervalList.sort(Comparator.comparingInt(o -> o[0]));
        result.add(intervals[0]);
        for (int[] interval : intervalList) {
            final int[] currentLast = result.get(result.size()-1);
            //
            if (currentLast[1] >= interval[0]) {
                currentLast[1] = Math.max(currentLast[1], interval[1]);
            } else {
                result.add(interval);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    public int[][] merge1(int[][] intervals) {
        if (intervals == null || intervals.length < 2) return intervals;
        int length = intervals.length;

        int cut = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] <= intervals[j][1] && intervals[i][1] >= intervals[j][0]) {
                    intervals[j][0] = Math.min(intervals[i][0], intervals[j][0]);
                    intervals[j][1] = Math.max(intervals[i][1], intervals[j][1]);
                    intervals[i] = null;
                    cut++;
                    break;
                }
            }
        }

        int index = 0;
        int[][] res = new int[length - cut][2];
        for (int i = 0; i < length; i++) {
            if (intervals[i] != null) {
                res[index][0] = intervals[i][0];
                res[index][1] = intervals[i][1];
                index++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        final int[][] merge = solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        final int[][] merge = solution.merge(new int[][]{{1, 4}, {0, 4}});
        System.out.println(Arrays.deepToString(merge));
    }
}

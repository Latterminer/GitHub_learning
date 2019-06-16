package com.wy.leetcode.question75;

/**
 * @author wangyong
 * @date 2019/6/16
 * @description
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class Solution {
    /**
     * 第一种解法是计数法，循环1:分别统计0，1，2出现的次数，然后循环2:根据计数结果构建整个数组
     * 第二种解法：运用三个指针,
     * @param nums
     */
    public void sortColors(int[] nums) {
        int len = nums.length;
        int zeroRight = 0;
        int twoLeft = len -1;
        int curr = 0;
        //注意边界，要有等号
        while (curr <= twoLeft) {
            //当curr指向的数为0时，则把当前数与zeroRight所指的数交换
            if (nums[curr] == 0) {
                int temp = nums[curr];
                nums[curr] = nums[zeroRight];
                nums[zeroRight] = temp;
                curr++;
                zeroRight++;
            //当curr指向的数为2时，则把当前数与twoLeft所指的数交换
            } else if (nums[curr] == 2) {
                int temp = nums[curr];
                nums[curr] = nums[twoLeft];
                nums[twoLeft] = temp;
                twoLeft--;
            } else {
                curr++;
            }
        }
    }
}
